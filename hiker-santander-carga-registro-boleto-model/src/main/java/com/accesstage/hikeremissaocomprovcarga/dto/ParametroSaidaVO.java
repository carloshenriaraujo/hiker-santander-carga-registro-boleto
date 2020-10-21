package com.accesstage.hikeremissaocomprovcarga.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ParametroSaidaVO {
	
	private String diretorioSaida;
	private String sender;
	private String receiver;
	private String docType;

}
