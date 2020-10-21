package com.accesstage.hikeremissaocomprovcarga.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesstage.hikeremissaocomprovcarga.clients.RegistroBoletoApiClient;
import com.accesstage.hikeremissaocomprovcarga.dto.BoletoResponseDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoPDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoQDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderLoteDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.ParametroSaidaVO;
import com.accesstage.hikeremissaocomprovcarga.dto.TrailerDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.TrailerLoteDTO;
import com.accesstage.hikeremissaocomprovcarga.enums.CaminhoArquivoEnum;
import com.accesstage.hikeremissaocomprovcarga.enums.InfoSantander;
import com.accesstage.hikeremissaocomprovcarga.enums.StatusProcessamentoEnum;
import com.accesstage.hikeremissaocomprovcarga.md.EntradaRequest;
import com.accesstage.hikeremissaocomprovcarga.md.Parametros;
import com.accesstage.hikeremissaocomprovcarga.repository.ParametrosRepository;
import com.accesstage.hikeremissaocomprovcarga.service.FileGenerator;
import com.accesstage.hikeremissaocomprovcarga.service.GerarArquivoService;
import com.accesstage.hikeremissaocomprovcarga.utils.Utils;
import com.accesstage.hikeremissaocomprovcarga.vo.ControleRegistroBoletoVO;
import com.accesstage.hikeremissaocomprovcarga.vo.RetornoRegistroVO;

@Service
public class FileGeneratorImpl implements FileGenerator {
	
	private final static String PRODUCAO = "P";	
	private final static String HOMOLOGACAO = "T";
	
	@Autowired
	private ParametrosRepository parametros;

	@Autowired
	private GerarArquivoService arquivoService;	
	
	@Autowired
	private RegistroBoletoApiClient api;	
	
	ParametroSaidaVO saidaVO = new ParametroSaidaVO();
	
	EntradaRequest request;
	
	private String lineHeader = "";

	private List<String> listaErroSegV;
	
	private Parametros param;
	
	private Long codArquivo;

	@Override
	public void processaRequisao(HeaderDTO header
			, DetalheSegmentoPDTO detalheSegmentoPDTO, DetalheSegmentoQDTO detalheSegmentoQDTO) throws Exception {		
		BoletoResponseDTO response = api.registraBoleto(request);
		/*** Gera o arquivo de retorno com o segmento V */		
		listaErroSegV.add(arquivoService.gerarLinhaSegmentoV(response, header, response.getDescricaoErro()));
		/**Grava a linha **/
		arquivoService.gravaLinha(arquivoService.gerarLinhaSegmentoT(response, detalheSegmentoPDTO),
				arquivoService.gerarLinhaSegmentoU(response, request),
				listaErroSegV);
		parametros.insereRetorno(retorno(codArquivo, response.getCodigoBarras(), response.getLinhaDigitavel()
				, detalheSegmentoPDTO.getIdentificacaoTituloBanco(), response.getDescricaoErro(), detalheSegmentoPDTO.getNumeroDocumentoCobranca()
				, detalheSegmentoQDTO.getNome(), param.getConvenio(), String.valueOf(detalheSegmentoPDTO.getValorNominalTitulo())));
	}
	@Override
	public void initHeaderFile(HeaderDTO header) {
		request = new EntradaRequest();
		listaErroSegV = new ArrayList<String>();
		if(Objects.nonNull(header)) {
			request.setCodigoBanco(header.getCodigoBancoCompensacao());
			param = recuperaParametros(header.getNumeroInscricaoEmpresa(), request);
			lineHeader = header.getLinhaInteira();
		}
	}
	@Override
	public void initHeagerLoteFile(HeaderLoteDTO headerLoteDTO) throws IOException {
		if(Objects.nonNull(headerLoteDTO)) {
			arquivoService.abreArquivo(lineHeader, headerLoteDTO.getLinhaInteira(), saidaVO);	
		}			
	}
	@Override
	public void segmentoP(DetalheSegmentoPDTO detalheSegmentoPDTO) {
		if(Objects.nonNull(detalheSegmentoPDTO)) {			
			request.setTituloNossoNumero(detalheSegmentoPDTO.getIdentificacaoTituloBanco());
			request.setTituloSeuNumero(detalheSegmentoPDTO.getNumeroDocumentoCobranca());
			request.setTituloDtVencto(Utils.removerCaracteresEspeciais(detalheSegmentoPDTO.getDataVencimentoTitulo()));
			request.setTituloDtEmissao(Utils.removerCaracteresEspeciais(detalheSegmentoPDTO.getDataEmissaoTitulo()));
			request.setTituloEspecie(detalheSegmentoPDTO.getEspecieTitulo());
			request.setTituloVlNominal(Utils.removerCaracteresEspeciais(detalheSegmentoPDTO.getValorNominalTitulo().toPlainString()));
			request.setTituloPcJuro(detalheSegmentoPDTO.getJurosMoraTaxa());
			request.setTituloPcDesc(detalheSegmentoPDTO.getCodigoDesconto());
			request.setTituloDtLimiDesc(detalheSegmentoPDTO.getDataDesconto());
			request.setTituloVlAbatimento(detalheSegmentoPDTO.getValorAbatimento().toPlainString());
			request.setTituloTpProtesto(detalheSegmentoPDTO.getCodigoProtesto());
			request.setTituloQtDiasProtesto(detalheSegmentoPDTO.getNumeroDiasProtesto());
			request.setTituloQtDiasBaixa(detalheSegmentoPDTO.getNumeroDiasBaixaDevolucao());
			request.setTituloVlDesc("");
			request.setTituloQtDiasMulta("");
			request.setTituloPcMulta("");
			request.setMensagem("");
		}		
	}
	@Override
	public void segmentoQ(DetalheSegmentoQDTO detalheSegmentoQDTO) {		
		if(Objects.nonNull(detalheSegmentoQDTO)) {
			request.setPagadorTpDoc(detalheSegmentoQDTO.getTipoInscricao());
			request.setPagadorNumDoc(Utils.removerCaracteresEspeciais(detalheSegmentoQDTO.getNumeroInscricao()));
			request.setPagadorNome(detalheSegmentoQDTO.getNome());
			request.setPagadorEnder(detalheSegmentoQDTO.getEndereco());
			request.setPagadorBairro(detalheSegmentoQDTO.getBairro());
			request.setPagadorCidade(detalheSegmentoQDTO.getCidade());
			request.setPagadorUf(detalheSegmentoQDTO.getUnidadeFederacao());
			request.setPagadorCep(detalheSegmentoQDTO.getCep());			
		}		
	}
	@Override
	public void fechaArquivo(TrailerLoteDTO trailerLoteDTO, TrailerDTO trailerDTO) throws IOException {
		if(Objects.nonNull(trailerLoteDTO) && Objects.nonNull(trailerDTO)) {
			arquivoService.fecharArquivo(trailerLoteDTO.getLinhaInteira(), trailerDTO.getLinhaInteira());			
		}
		parametros.updateRegistro(StatusProcessamentoEnum.SUCESSO.getCaminho(), codArquivo);		
	}
	
	private void nomeArquivo(Parametros param) {
		saidaVO.setDiretorioSaida(CaminhoArquivoEnum.DIRETORIO_SUCESSO.getCaminho());
		saidaVO.setSender(param.getSender());
		saidaVO.setReceiver(param.getReceiver());
		saidaVO.setDocType(param.getDoctype());
	}
	
	private Parametros recuperaParametros(String cnpj, EntradaRequest request) {
		Parametros param = parametros.consultaParametros(cnpj);
		if(Objects.nonNull(param)) {
			request.setEstacao(param.getEstacao()); 
			request.setCodigoConvenio(param.getConvenio()); //3123421
			if(param.getAmbiente() == 1) {
				request.setAmbiente(PRODUCAO);
			} else {
				request.setAmbiente(HOMOLOGACAO);
			}		
			request.setSistema("YMB");				
			nomeArquivo(param);				
		} else {
			//registrar erro fornax.
		}
		return param;
	}
	
	private ControleRegistroBoletoVO registro(String status,String cnpj, String layout
			, String tracking, String sentidoTransacao, String ambiente) {
		ControleRegistroBoletoVO vo = new ControleRegistroBoletoVO();
		vo.setStatus(status);
		vo.setCnpj(cnpj);
		vo.setLayout(layout);
		vo.setSentidoTransacao(sentidoTransacao);
		vo.setTracking(tracking);
		vo.setAmbiente(ambiente);
		return vo;		
	}
	private RetornoRegistroVO retorno(Long codArquivo, String codigoBarras, String linhaDigitavel
			,String nossoNumero,String erro,String numeroTitulo,String pagador,String convenio,String valorTitulo) {
		RetornoRegistroVO vo = new RetornoRegistroVO();
		vo.setCodArquivo(codArquivo);
		vo.setCodigoBarras(codigoBarras);
		vo.setConvenio(convenio);
		vo.setErro(erro);
		vo.setLinhaDigitavel(linhaDigitavel);
		vo.setNossoNumero(nossoNumero);
		vo.setNumeroTitulo(numeroTitulo);
		vo.setPagador(pagador);
		vo.setValorTitulo(valorTitulo);		
		return vo;	
	}
	@Override
	public void regitrarControleProcessamento(String status, HeaderDTO header) {
		codArquivo = null;
		codArquivo = parametros.insereRegistroRemessa(registro(status, header.getNumeroInscricaoEmpresa()
				, "33"
				,"",InfoSantander.ENVIO.getBanco(), param.getAmbiente() == 1? "PRODUCAO" : "HOMOLOGACAO"));	
	}

}
