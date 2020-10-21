package com.accesstage.hikeremissaocomprovcarga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DetalheSegmentoQDTO extends SantanderDTO {

	private String codigoCompensacaoBanco ;
	private String loteServico ;
	private String tipoRegistro ;
	private String numeroSequencialRegistroLote ;
	private String codigoSegmentoRegDetalhe ;
	private String usoExclusivoCnab ;
	private String codigoMovimentacaoRemessa;
	private String tipoInscricao ;
	private String numeroInscricao;
	private String nome ;
	private String endereco ;
	private String bairro ;
	private String cidade ;
	private String cep ;
	private String sufixoCep ;
	private String unidadeFederacao ;
	private String tipoInscricaoSacado ;
	private String numeroInscricaoSacado ;
	private String nomeSacado ;
	private String identificadorCarne;
	private String sequencialParcela;
	private String quantidadeParcela;
	private String numeroPlano;
	private String reservado;

	public DetalheSegmentoQDTO() {
		super();
	}
}
