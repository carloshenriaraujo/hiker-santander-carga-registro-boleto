package com.accesstage.hikeremissaocomprovcarga.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DetalheSegmentoRDTO extends SantanderDTO {
	
	private String codigoCompensacaoBanco ;
	private String loteServico ;
	private String tipoRegistro ;
	private String numeroSequencialRegistroLote ;
	private String codigoSegmentoRegDetalhe ;
	private String usoExclusivoCnab;
	private String codigoMovimentacaoRemessa;
	private String codigoDesconto;
	private String dataDesconto;
	private String valorPercentualConcedido;
	private String reservado2;
	private String codigoMulta;
	private String dataMulta;
	private String valorPercentualAplicado;
	private String reservado3;
	private String mensagem;
	private String reservado4;

}
