package com.accesstage.hikeremissaocomprovcarga.service;

import java.io.IOException;
import java.util.List;

import com.accesstage.hikeremissaocomprovcarga.dto.BoletoResponseDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoPDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.ParametroSaidaVO;
import com.accesstage.hikeremissaocomprovcarga.md.EntradaRequest;

/***
 * 
 * @author atud
 *
 */
public interface GerarArquivoService {
	
	void gravaLinha(String segT, String segU, List<String> segV) throws Exception;
	
	String gerarLinhaSegmentoV(BoletoResponseDTO api, HeaderDTO request, String mensagemErro);
	
	String gerarLinhaSegmentoT(BoletoResponseDTO api, DetalheSegmentoPDTO detalheSegmentoPDTO);
	
	String gerarLinhaSegmentoU(BoletoResponseDTO api, EntradaRequest request);
	
	void abreArquivo(String linhaHeader,String linhaHeaderLote, ParametroSaidaVO saidaVO)  throws IOException;
	
	void fecharArquivo(String linhaTrailerLote, String linhaTrailer)  throws IOException;

}
