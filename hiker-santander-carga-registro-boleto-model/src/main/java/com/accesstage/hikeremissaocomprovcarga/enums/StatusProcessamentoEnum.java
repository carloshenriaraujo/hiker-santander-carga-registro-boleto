package com.accesstage.hikeremissaocomprovcarga.enums;

import lombok.Getter;

@Getter
public enum StatusProcessamentoEnum {
	
	PROCESSAMENTO("PROCESSAMENTO"),
	SUCESSO("SUCESSO"),
	ERRO("ERRO");

	private String caminho;

	private StatusProcessamentoEnum(String caminho) {
		this.caminho = caminho;
	}

}
