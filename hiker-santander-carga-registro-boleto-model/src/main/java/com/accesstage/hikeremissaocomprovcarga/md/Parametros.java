package com.accesstage.hikeremissaocomprovcarga.md;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Getter @Setter
public class Parametros {
	
	private String convenio;
	private String estacao;
	private int ambiente;
	
	private Long idEmpresa;
	private Long codigoBanco;
	private String sender;
	private String receiver; 
	private String doctype;
	private boolean api;
	private boolean edi;
	private String cnpj;

}
