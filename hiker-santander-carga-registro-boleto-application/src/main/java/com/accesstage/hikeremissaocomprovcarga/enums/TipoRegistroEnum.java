package com.accesstage.hikeremissaocomprovcarga.enums;

public enum TipoRegistroEnum {

	HEADER("0", "HEADER"),
	REGISTRO_TRANSACAO_TIPO_1("1", "REGISTRO_TRANSACAO_TIPO_1"),
	REGISTRO_TRANSACAO_TIPO_2("2", "REGISTRO_TRANSACAO_TIPO_2"),
	REGISTRO_TRANSACAO_TIPO_3("3", "REGISTRO_TRANSACAO_TIPO_3"),
	REGISTRO_TRAILER("9", "REGISTRO_TRAILER");

	private TipoRegistroEnum(String codigo, String nome){
		this.codigo = codigo;
		this.nome = nome;
	}

	private String codigo;
	private String nome;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
