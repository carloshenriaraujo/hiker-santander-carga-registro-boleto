package com.accesstage.hikeremissaocomprovcarga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HeaderLoteDTO extends SantanderDTO{

	private String codigoBancoCompensacao;
	private String loteServico;
	private String tipoRegistro;
	private String tipoOperacao;
	private String tipoServico;
	private String reservado;
	private String numeroVersaoLayoutLote;
	private String usoExclusiveCnab;
	private String tipoInscricaoEmpresa;
	private String numeroInscricaoEmpresa;
	private String reservado2;
	private String nomeBeneficiario;
	private String mensagem;
	private String numeroSequencialRemessaRetorno;
	private String numerodataGravacaoRemessaRetorno;
	private String usoExclusivoCnab2;
	private String linhaInteira;

	public HeaderLoteDTO() {
		super();
	}

}
