package com.accesstage.hikeremissaocomprovcarga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TrailerDTO  extends SantanderDTO {

	private String codigoCompensacaoBanco;
	private String loteServico;
	private String tipoRegistro;
	private String usoExclusivoCnab;
	private String quantidadeLotesArquivo;
	private String quantidadeRegistrosArquivo;
	private String quantidadeContasLote;
	private String usoExclusivoCnab2;
	private String linhaInteira;

	public TrailerDTO() {
		super();
	}
}
