package com.accesstage.hikeremissaocomprovcarga.service;

import java.io.IOException;

import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoPDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoQDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderLoteDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.TrailerDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.TrailerLoteDTO;

public interface FileGenerator {
	
	void processaRequisao(HeaderDTO header, DetalheSegmentoPDTO detalheSegmentoPDTO
			,DetalheSegmentoQDTO detalheSegmentoQDTO) throws Exception;
	
	void initHeaderFile(HeaderDTO header);
	
	void initHeagerLoteFile(HeaderLoteDTO headerLoteDTO) throws IOException;
	
	void fechaArquivo(TrailerLoteDTO trailerLoteDTO, TrailerDTO trailerDTO) throws IOException;
	
	void segmentoP(DetalheSegmentoPDTO detalheSegmentoPDTO);
	
	void segmentoQ(DetalheSegmentoQDTO detalheSegmentoQDTO);
	
	void regitrarControleProcessamento(String status, HeaderDTO header);

}
