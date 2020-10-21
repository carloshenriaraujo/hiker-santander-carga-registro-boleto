package com.accesstage.hikeremissaocomprovcarga.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DetalheSegmentoPDTO extends SantanderDTO{


	private String codigoCompensacaoBanco;
	private String loteServico;
	private String tipoRegistro;
	private String numeroSequencialRegistroLote;
	private String codigoSegmentoRegDetalhe;
	private String usoExclusivoCnab;
	private String codigoMovimentoRemessa;
	private String agenciaMantenedora;
	private String digitoVerificadorAgencia;
	private String numeroContaCorrente;
	private String digitoNumeroContaCorrente;
	private String contaCobrancaDestinatariaFIDC;
	private String digitoContaCobrancaDestinatariaFIDC;
	private String reservado;
	private String identificacaoTituloBanco;
	private String tipoCobranca;
	private String formaCadastro;
	private String tipoDocumento;
	private String reservado2;
	private String numeroDocumentoCobranca;
	private String dataVencimentoTitulo;
	private BigDecimal valorNominalTitulo;
	private String agenciaEncarregadaCobranca;
	private String digitoAgenciaEncarregadaCobranca;
	private String reservado3;
	private String especieTitulo;
	private String identificacaoTituloAceito;
	private String dataEmissaoTitulo;
	private String codigoJurosMora;
	private String dataJurosMora;
	private String jurosMoraTaxa;
	private String codigoDesconto;
	private String dataDesconto;
	private BigDecimal valorPercentualConcebido;
	private BigDecimal valorIof ;
	private BigDecimal valorAbatimento;
	private String identificacaoTituloEmpresa;
	private String codigoProtesto;
	private String numeroDiasProtesto;
	private String codigoBaixaDevolucao;
	private String reservado4;
	private String numeroDiasBaixaDevolucao;
	private String codigoMoeda;
	private String usoExclusivoFebraban;

	public DetalheSegmentoPDTO() {
		super();
	}

}
