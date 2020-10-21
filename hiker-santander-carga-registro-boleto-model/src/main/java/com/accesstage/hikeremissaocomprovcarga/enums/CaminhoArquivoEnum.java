package com.accesstage.hikeremissaocomprovcarga.enums;

/**
 *
 * @author carlos.cruz
 *
 */
public enum CaminhoArquivoEnum {

	DIRETORIO_ENTRADA("/data/cargabatch/arquivos/santander240/entrada/"),
	DIRETORIO_EXECUCAO("/data/cargabatch/arquivos/santander240/execucao/"),
	DIRETORIO_SUCESSO("/data/cargabatch/arquivos/santander240/sucesso/"),
	DIRETORIO_ERRO("/data/cargabatch/arquivos/santander240/erro/"),
	ARQUIVO_EXECUCAO("file:/data/cargabatch/arquivos/santander240/execucao/*"),
	DIRETORIO_DUPLICADO("/data/cargabatch/arquivos/santander240/duplicado/");

	private String caminho;

	private CaminhoArquivoEnum(String caminho) {
		this.caminho = caminho;
	}

	public String getCaminho() {
		return caminho;
	}

}
