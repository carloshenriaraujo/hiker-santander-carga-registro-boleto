package com.accesstage.hikeremissaocomprovcarga.enums;

import lombok.Getter;

public enum NomeDoSistemaParaLogFornaxEnum {
	
	NOME_SISTEMA("hiker-registra-bradesco");

	private NomeDoSistemaParaLogFornaxEnum(String nome){
		this.nome = nome;
	}

	@Getter
	private String nome;

}
