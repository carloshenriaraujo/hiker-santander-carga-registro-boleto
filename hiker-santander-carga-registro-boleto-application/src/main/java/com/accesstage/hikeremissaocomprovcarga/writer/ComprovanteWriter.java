
package com.accesstage.hikeremissaocomprovcarga.writer;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoPDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoQDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.DetalheSegmentoRDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.HeaderLoteDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.SantanderDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.TrailerDTO;
import com.accesstage.hikeremissaocomprovcarga.dto.TrailerLoteDTO;
import com.accesstage.hikeremissaocomprovcarga.enums.StatusProcessamentoEnum;
import com.accesstage.hikeremissaocomprovcarga.service.impl.FileGeneratorImpl;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ComprovanteWriter implements ItemWriter<SantanderDTO>, Serializable {

	private static final long serialVersionUID = 1L;
	@Autowired
	private FileGeneratorImpl file;
	
	private TrailerLoteDTO trailerLoteDTO;
	
	private TrailerDTO trailerDTO;
	
	private DetalheSegmentoPDTO  detalheSegmentoPDTO;
	
	private DetalheSegmentoQDTO detalheSegmentoQDTO;
	
	private HeaderDTO headerDTO;
	
	private HeaderLoteDTO headerLoteDTO;

	@Override
	public void write(List<? extends SantanderDTO> comprovantes) throws Exception {
		int i = 0;
		this.nullObject();
		for (SantanderDTO dto : comprovantes) {
			if(HeaderDTO.class.isInstance(dto)) {
				headerDTO = new HeaderDTO();
				headerDTO = (HeaderDTO) dto;
				file.initHeaderFile(headerDTO);	
			} else if (HeaderLoteDTO.class.isInstance(dto)) {
				headerLoteDTO = new HeaderLoteDTO();
				headerLoteDTO = (HeaderLoteDTO) dto;				
				file.initHeagerLoteFile(headerLoteDTO);
			} else if(DetalheSegmentoPDTO.class.isInstance(dto)) {
				detalheSegmentoPDTO = new DetalheSegmentoPDTO();
				detalheSegmentoPDTO = (DetalheSegmentoPDTO) dto;
				file.segmentoP(detalheSegmentoPDTO);				
			} else if (DetalheSegmentoQDTO.class.isInstance(dto)) {
				detalheSegmentoQDTO = new DetalheSegmentoQDTO();
				detalheSegmentoQDTO = (DetalheSegmentoQDTO) dto;
				file.segmentoQ(detalheSegmentoQDTO);
			} else if (DetalheSegmentoRDTO.class.isInstance(dto)) {
				DetalheSegmentoRDTO detalheSegmentoRDTO = (DetalheSegmentoRDTO) dto;
			} else if (TrailerLoteDTO.class.isInstance(dto)) {
				trailerLoteDTO = (TrailerLoteDTO) dto;
			} else if (TrailerDTO.class.isInstance(dto)) {
				trailerDTO = (TrailerDTO) dto;
			}
			if(Objects.nonNull(detalheSegmentoPDTO) && Objects.nonNull(detalheSegmentoQDTO)) {								
				file.processaRequisao(headerDTO, detalheSegmentoPDTO, detalheSegmentoQDTO);				
			}
			if(i==0) {
				file.regitrarControleProcessamento(StatusProcessamentoEnum.PROCESSAMENTO.getCaminho(), headerDTO);				
			}
			i++;
		}
		file.fechaArquivo(trailerLoteDTO, trailerDTO);
		this.nullObject();
	}
	
	private void nullObject() {
		headerLoteDTO = null;
		detalheSegmentoPDTO = null;
		detalheSegmentoQDTO = null;
		trailerLoteDTO = null;
		trailerDTO = null;
	}
	
	
}
