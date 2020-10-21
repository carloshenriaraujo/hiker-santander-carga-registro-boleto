package com.accesstage.hikeremissaocomprovcarga.enums;

import lombok.Getter;

public enum DataBaseInfosEnum {
	
	SCHEMA("SCH_REGBOL");

	@Getter
	private String texto;

	private DataBaseInfosEnum(String texto) {
		this.texto = texto;
	}

}
