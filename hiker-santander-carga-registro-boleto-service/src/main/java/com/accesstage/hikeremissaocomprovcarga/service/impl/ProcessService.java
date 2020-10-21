package com.accesstage.hikeremissaocomprovcarga.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accesstage.hikeremissaocomprovcarga.clients.RegistroBoletoApiClient;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoPDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoQDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoRDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderLoteDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.SantanderDTO;
import com.accesstage.hikeremissaocomprovcarga.md.EntradaRequest;
import com.accesstage.hikeremissaocomprovcarga.md.Parametros;
import com.accesstage.hikeremissaocomprovcarga.repository.ParametrosRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProcessService {

	private String cnpj;
	
	@Autowired
	private RegistroBoletoApiClient api;
	
	@Autowired
	private ParametrosRepository parametros;	
	
	public void process(List<? extends SantanderDTO> comprovantes) {
		
		EntradaRequest request = new EntradaRequest();
		

		for (SantanderDTO dto : comprovantes) {
			if(HeaderDTO.class.isInstance(dto)) {				
				HeaderDTO headerDTO = (HeaderDTO) dto;
				request.setCodigoBanco(headerDTO.getCodigoBancoCompensacao());
				this.cnpj = headerDTO.getNumeroInscricaoEmpresa();
				
			} else if (HeaderLoteDTO.class.isInstance(dto)) {				
				HeaderLoteDTO headerLoteDTO = (HeaderLoteDTO) dto;
				
			} else if(DetalheSegmentoPDTO.class.isInstance(dto)) {				
				DetalheSegmentoPDTO  detalhe = (DetalheSegmentoPDTO) dto;
				
				request.setTituloNossoNumero(detalhe.getIdentificacaoTituloBanco());
				request.setTituloSeuNumero(detalhe.getNumeroDocumentoCobranca());
				request.setTituloDtVencto(detalhe.getDataVencimentoTitulo());
				request.setTituloDtEmissao(detalhe.getDataEmissaoTitulo());
				request.setTituloEspecie(detalhe.getEspecieTitulo());
				request.setTituloVlNominal(detalhe.getValorNominalTitulo().toPlainString());
				request.setTituloPcJuro(detalhe.getJurosMoraTaxa());
				request.setTituloPcDesc(detalhe.getCodigoDesconto());
				request.setTituloDtLimiDesc(detalhe.getDataDesconto());
				request.setTituloVlAbatimento(detalhe.getValorAbatimento().toPlainString());
				request.setTituloTpProtesto(detalhe.getCodigoProtesto());
				request.setTituloQtDiasProtesto(detalhe.getNumeroDiasProtesto());
				request.setTituloQtDiasBaixa(detalhe.getNumeroDiasBaixaDevolucao());
				request.setTituloQtDiasMulta("");
				
			} else if (DetalheSegmentoQDTO.class.isInstance(dto)) {
				DetalheSegmentoQDTO detalheSegmentoQDTO = (DetalheSegmentoQDTO) dto;
				
				request.setPagadorTpDoc(detalheSegmentoQDTO.getTipoInscricao());
				request.setPagadorNumDoc(detalheSegmentoQDTO.getNumeroInscricao());
				request.setPagadorNome(detalheSegmentoQDTO.getNome());
				request.setPagadorEnder(detalheSegmentoQDTO.getEndereco());
				request.setPagadorBairro(detalheSegmentoQDTO.getBairro());
				request.setPagadorCidade(detalheSegmentoQDTO.getCidade());
				request.setPagadorUf(detalheSegmentoQDTO.getUnidadeFederacao());
				request.setPagadorCep(detalheSegmentoQDTO.getCep());

			} else if (DetalheSegmentoRDTO.class.isInstance(dto)) {
				DetalheSegmentoRDTO detalhe = new DetalheSegmentoRDTO();
				
				request.setTituloPcMulta(detalhe.getValorPercentualConcedido());
				request.setTituloVlDesc(detalhe.getValorPercentualAplicado());
				request.setMensagem(detalhe.getMensagem());
			}			
				
		}
		Parametros param = parametros.consultaParametros(cnpj);
		request.setCodigoConvenio(param.getConvenio());		
		request.setEstacao(param.getEstacao());
		if(param.getAmbiente() == 1) {
			request.setAmbiente("P");
		} else {
			request.setAmbiente("T");
		}		
		request.setSistema("YMB");			
		api.registraBoleto(request);

	}
}
