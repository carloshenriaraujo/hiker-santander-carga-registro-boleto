package com.accesstage.hikeremissaocomprovcarga.vo;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ControleRegistroBoletoVO {
	
	private Long codigoArquivo;
	private String status;
	private String cnpj;
	private String layout;
	private String tracking;
	private Timestamp dataProcessamento;
	private String sentidoTransacao;
	private String ambiente;

}
