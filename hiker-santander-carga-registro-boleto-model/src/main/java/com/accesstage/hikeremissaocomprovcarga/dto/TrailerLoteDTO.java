package com.accesstage.hikeremissaocomprovcarga.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class TrailerLoteDTO extends SantanderDTO {

	private String codigoCompensacaoBanco;
	private String loteServico;
	private String tipoRegistro;
	private String usoExclusivoCnab;
	private String quantidadeRegistroLote;
	private String qtdTitulosCobrados;
	private String valorTotalTituloCarteiraSimples;
	private String qtdTitulosCobranca;
	private BigDecimal valorTotalTitulosCarteiraVinculada;
	private String qtdTitulosCobrancaCaucionada;
	private BigDecimal valorTotalTituloCarteiraCaucionada;
	private String qtdTitulosCobrancaDescontada;
	private BigDecimal valorTotalTituloCarteiraDescontada;
	private String numeroAviso;
	private String usoExclusivoCnab2;
	private String linhaInteira;

	public TrailerLoteDTO() {
		super();
	}
}
