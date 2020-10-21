package com.accesstage.hikeremissaocomprovcarga.vo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RetornoRegistroVO {
	
	private Long codArquivo;
	private String codigoBarras;
	private String linhaDigitavel;
	private String nossoNumero;
	private String erro;
	private String numeroTitulo;
	private String pagador;
	private String convenio;
	private String valorTitulo;

}
