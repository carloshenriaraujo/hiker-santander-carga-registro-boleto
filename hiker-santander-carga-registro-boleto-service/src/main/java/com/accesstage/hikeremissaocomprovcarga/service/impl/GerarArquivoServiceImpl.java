package com.accesstage.hikeremissaocomprovcarga.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.accesstage.hikeremissaocomprovcarga.dto.BoletoResponseDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoPDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.ParametroSaidaVO;
import com.accesstage.hikeremissaocomprovcarga.enums.InfoSantander;
import com.accesstage.hikeremissaocomprovcarga.md.EntradaRequest;
import com.accesstage.hikeremissaocomprovcarga.service.GerarArquivoService;
import com.accesstage.hikeremissaocomprovcarga.utils.Constantes;
import com.accesstage.hikeremissaocomprovcarga.utils.Utils;
import com.google.common.base.Strings;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class GerarArquivoServiceImpl implements GerarArquivoService {
	
	SimpleDateFormat formataData = new SimpleDateFormat("yyyyMMddHHmmss");
	SimpleDateFormat dataOcorrencia = new SimpleDateFormat("ddMMyyyy");
	
	private File file =  null;
	BufferedWriter bw = null;
	FileWriter fw = null;
	
	@Override
	public void abreArquivo(String linhaHeader,String linhaHeaderLote
			, com.accesstage.hikeremissaocomprovcarga.dto.ParametroSaidaVO saidaVO) throws IOException {
		file = new File(saidaVO.getDiretorioSaida()+ nomeArquivo(saidaVO));
        // Se o arquivo nao existir, ele gera
        if (!file.exists()) {
            file.createNewFile();
        }		
        fw = new FileWriter(file.getAbsoluteFile());
        bw = new BufferedWriter(fw);
		bw.write(linhaHeader);
		bw.newLine();
		bw.write(linhaHeaderLote);
		bw.newLine();  
		
	}	

	@Override
	public void gravaLinha(String segT, String segU, List<String> segV
			) throws Exception {

		bw.write(segT);
		bw.newLine();		
		bw.write(segU);
		bw.newLine();		
		for (int i = 0; i < segV.size(); i++) {
			bw.write(segV.get(i));
			bw.newLine();
		}

	}
	
	@Override
	public void fecharArquivo(String linhaTrailerLote, String linhaTrailer) throws IOException {
		
		bw.write(linhaTrailerLote);
		bw.newLine();
		bw.write(linhaTrailer);		
		bw.close();
		
		log.info("[ARQUIVO CRIADO NO DIRETÓIRO - ]" + file.getAbsolutePath());		
		File diretorio = new File(Constantes.FEG_RESUBMIT);
		File arquivo = new File (file.getAbsolutePath());
		moveArquivoParaFegResubmit(diretorio, arquivo);
		
	}
	@Override
	public String gerarLinhaSegmentoV(BoletoResponseDTO api, HeaderDTO request, String mensagemErro) {
		
		String linha = InfoSantander.CODIGO_BANCO.getBanco() 
				+ request.getLoteServico() 
				+ InfoSantander.COD_SEGMENTO_V.getBanco() 
				+ request.getNumeroSequencialArquivo()
				+ InfoSantander.LETRA_SEGMENTO_V.getBanco() 
				+ String.format ("%-45.45s", api.getCodigoBarras()!=null? api.getCodigoBarras() : "")
				+ String.format ("%-48.48s", api.getLinhaDigitavel()!=null? api.getLinhaDigitavel() : "")
				+ String.format ("%-92.92s", mensagemErro)
				+ String.format("%-41.41s", "");
				
		return linha;
	}
	
	
	private String nomeArquivo(ParametroSaidaVO parametroSaidaVO) {
		
		return parametroSaidaVO.getSender()
				+"@" + parametroSaidaVO.getReceiver()
				+"@"+ parametroSaidaVO.getDocType()
				+"@"+ formataData.format(new Date()) ;		
	}

	private void moveArquivoParaFegResubmit(File diretorioDestino, File arquivo) {
		File novoArquivo = new File(diretorioDestino, arquivo.getName());		
		arquivo.renameTo(novoArquivo);
		log.info("[Arquivo renomeado para : ]  " + novoArquivo.getAbsolutePath());
	}

	@Override
	public String gerarLinhaSegmentoT(BoletoResponseDTO api, DetalheSegmentoPDTO detalheSegmentoPDTO) {
		String ocorrencia = "";
		
		if(Strings.isNullOrEmpty(api.getCodigoBarras())) {
			ocorrencia = "03";
		} else {
			ocorrencia = "02";
		}
		
		return Utils.stringFormat(InfoSantander.CODIGO_BANCO.getBanco() 
				+ detalheSegmentoPDTO.getLoteServico() 
				+ 3 
				+ detalheSegmentoPDTO.getNumeroSequencialRegistroLote()
				+ InfoSantander.LETRA_SEGMENTO_T.getBanco() 
				+ "0" 
				+ ocorrencia
				+ "0" 
//				+  request.getHeaderRequest().getBeneficiario().getAgenciaBeneficiario() 
				+ "00000000" 
//				+ request.getHeaderRequest().getBeneficiario().getContaRetorno()
				+ "0" 
//				+ request.getHeaderRequest().getBeneficiario().getDigitoVerificadorContaBeneficiario()
//				+ request.getTipoCarteiraTitulo()
//				+ Utils.stringFormat(Utils.tratarNulo(request.getNossoNumero()), "8")
//				+ Utils.stringFormat(Utils.tratarNulo(request.getDigitoVerificadorNossoNumero()), "1")
				+ Utils.stringFormat("", "8")
				+ "0" 
//				+ Utils.stringFormat(Utils.tratarNulo(request.getSeuNumero()), "10")
				+ Utils.stringFormat("", "5")
//				+ Utils.stringFormat(request.getDataSemFormatacao(), "8")
//				+ request.getValorCobrado()
				+ "000"
//				+ Utils.stringFormat(Utils.tratarNulo(request.getAgenciaPagadora()), "5")
//				+ "0"
//				+ Utils.stringFormat(Utils.tratarNulo(request.getIdentificacaoTituloEmpresa()), "25")
				+ "00"
//				+ request.getPagador().getTipoInscricaoPagador()
				+ "0"
//				+ request.getPagador().getCpfCnpjPagador()
//				+ Utils.stringFormat(request.getPagador().getNomePagador(), "30")
				+ Utils.stringFormat("", "10")
				+ "0000000000" 
				+ "000000000000000"
				+ "00000000"
				+ Utils.stringFormat("","2")
				+ Utils.stringFormat("", "17"), "240");
	}

	@Override
	public String gerarLinhaSegmentoU(BoletoResponseDTO api, EntradaRequest request) {
		String ocorrencia = "";
		
		if(Strings.isNullOrEmpty(api.getCodigoBarras())) {
			ocorrencia = "03";
		} else {
			ocorrencia = "02";
		}		
		
		return Utils.stringFormat(InfoSantander.CODIGO_BANCO.getBanco() 
//				+ request.getLoteServico() 
				+ 3 
//				+ request.getPagador().getNumeroSequencialLote()
				+ InfoSantander.LETRA_SEGMENTO_U.getBanco()
				+ Utils.stringFormat("", "1")
				+ Utils.stringFormat(Utils.tratarNulo(ocorrencia), "2")
				+ "000000000000000"
//				+ request.getValorDesconto()
//				+ request.getValorAbatimento()
//				+ request.getValorIof()
				+ "000000000000000"
				+ "000000000000000"
				+ "000000000000000000000000000000"
				+ Utils.stringFormat(dataOcorrencia.format(new Date()), "8")
				+ "00000000"
				+ "0000"
				+ "00000000"
				+ "000000000000000"
				+ Utils.stringFormat("", "30")
				+ "00000000000000000000000"
				+ "", "240");
	}
	
}
