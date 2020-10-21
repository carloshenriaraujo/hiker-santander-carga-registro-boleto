package com.accesstage.hikeremissaocomprovcarga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HeaderDTO extends SantanderDTO{

	private String codigoBancoCompensacao;
	private String loteServico;
	private String tipoRegistro;
	private String reservado;
	private String tipoInscricaoEmpresa;
	private String numeroInscricaoEmpresa;
	private String codigoTransmissao;
	private String exclusivoCnab1;
	private String nomeEmpresa;
	private String nomeBanco;
	private String exclusivoCnab2;
	private String codigoRemessa;
	private String dataGeracaoArquivo;
	private String exclusivoCnab3;
	private String numeroSequencialArquivo;
	private String numeroVersaoLayoutArquivo;
	private String exclusivoCnab4;
	private String linhaInteira;

	public HeaderDTO() {
		super();
	}
}
