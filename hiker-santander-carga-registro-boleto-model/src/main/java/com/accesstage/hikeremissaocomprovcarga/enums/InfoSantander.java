package com.accesstage.hikeremissaocomprovcarga.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum InfoSantander {
	
	CODIGO_BANCO("033"),
	COD_SEGMENTO_V("3"),
	LETRA_SEGMENTO_V("V"),
	LETRA_SEGMENTO_T("T"),
	LETRA_SEGMENTO_U("U"),
	APPLICATION("hiker-santander"),
	ENVIO("ENVIO"),
	RECEPCAO("RECEPCAO");
	
	private String banco;

}
