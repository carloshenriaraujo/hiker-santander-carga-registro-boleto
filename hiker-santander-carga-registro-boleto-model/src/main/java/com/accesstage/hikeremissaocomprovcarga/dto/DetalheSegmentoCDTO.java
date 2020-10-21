package com.accesstage.hikeremissaocomprovcarga.dto;

import java.math.BigDecimal;

public class DetalheSegmentoCDTO extends SantanderDTO {


	private Long codigoCompensacaoBanco ;
	private Long loteServico ;
	private Long tipoRegistro ;
	private Long numeroSequencialRegistroLote ;
	private String codigoSegmentoRegDetalhe ;
	private String usoExclusivoCnab ;
	private BigDecimal valorIr ;
	private BigDecimal valorIss ;
	private BigDecimal valorIof ;
	private BigDecimal valorOutrasDeducoes ;
	private BigDecimal valorOutrosAcrescimos ;
	private Long agenciaFavorecido ;
	private String digitoVerificadorAgencia ;
	private Long numeroContaCorrente ;
	private String digitoVerificadorConta ;
	private String digitoVerificadorAgConta ;
	private BigDecimal valorInss ;
	private String usoExclusivoCnab2 ;


	public DetalheSegmentoCDTO() {
		super();
	}


	public Long getCodigoCompensacaoBanco() {
		return codigoCompensacaoBanco;
	}


	public Long getLoteServico() {
		return loteServico;
	}


	public Long getTipoRegistro() {
		return tipoRegistro;
	}


	public Long getNumeroSequencialRegistroLote() {
		return numeroSequencialRegistroLote;
	}


	public String getCodigoSegmentoRegDetalhe() {
		return codigoSegmentoRegDetalhe;
	}


	public String getUsoExclusivoCnab() {
		return usoExclusivoCnab;
	}


	public BigDecimal getValorIr() {
		return valorIr;
	}


	public BigDecimal getValorIss() {
		return valorIss;
	}


	public BigDecimal getValorIof() {
		return valorIof;
	}


	public BigDecimal getValorOutrasDeducoes() {
		return valorOutrasDeducoes;
	}


	public BigDecimal getValorOutrosAcrescimos() {
		return valorOutrosAcrescimos;
	}


	public Long getAgenciaFavorecido() {
		return agenciaFavorecido;
	}


	public String getDigitoVerificadorAgencia() {
		return digitoVerificadorAgencia;
	}


	public Long getNumeroContaCorrente() {
		return numeroContaCorrente;
	}


	public String getDigitoVerificadorConta() {
		return digitoVerificadorConta;
	}


	public String getDigitoVerificadorAgConta() {
		return digitoVerificadorAgConta;
	}


	public BigDecimal getValorInss() {
		return valorInss;
	}


	public String getUsoExclusivoCnab2() {
		return usoExclusivoCnab2;
	}


	public void setCodigoCompensacaoBanco(Long codigoCompensacaoBanco) {
		this.codigoCompensacaoBanco = codigoCompensacaoBanco;
	}


	public void setLoteServico(Long loteServico) {
		this.loteServico = loteServico;
	}


	public void setTipoRegistro(Long tipoRegistro) {
		this.tipoRegistro = tipoRegistro;
	}


	public void setNumeroSequencialRegistroLote(Long numeroSequencialRegistroLote) {
		this.numeroSequencialRegistroLote = numeroSequencialRegistroLote;
	}


	public void setCodigoSegmentoRegDetalhe(String codigoSegmentoRegDetalhe) {
		this.codigoSegmentoRegDetalhe = codigoSegmentoRegDetalhe;
	}


	public void setUsoExclusivoCnab(String usoExclusivoCnab) {
		this.usoExclusivoCnab = usoExclusivoCnab;
	}


	public void setValorIr(BigDecimal valorIr) {
		this.valorIr = valorIr;
	}


	public void setValorIss(BigDecimal valorIss) {
		this.valorIss = valorIss;
	}


	public void setValorIof(BigDecimal valorIof) {
		this.valorIof = valorIof;
	}


	public void setValorOutrasDeducoes(BigDecimal valorOutrasDeducoes) {
		this.valorOutrasDeducoes = valorOutrasDeducoes;
	}


	public void setValorOutrosAcrescimos(BigDecimal valorOutrosAcrescimos) {
		this.valorOutrosAcrescimos = valorOutrosAcrescimos;
	}


	public void setAgenciaFavorecido(Long agenciaFavorecido) {
		this.agenciaFavorecido = agenciaFavorecido;
	}


	public void setDigitoVerificadorAgencia(String digitoVerificadorAgencia) {
		this.digitoVerificadorAgencia = digitoVerificadorAgencia;
	}


	public void setNumeroContaCorrente(Long numeroContaCorrente) {
		this.numeroContaCorrente = numeroContaCorrente;
	}


	public void setDigitoVerificadorConta(String digitoVerificadorConta) {
		this.digitoVerificadorConta = digitoVerificadorConta;
	}


	public void setDigitoVerificadorAgConta(String digitoVerificadorAgConta) {
		this.digitoVerificadorAgConta = digitoVerificadorAgConta;
	}


	public void setValorInss(BigDecimal valorInss) {
		this.valorInss = valorInss;
	}


	public void setUsoExclusivoCnab2(String usoExclusivoCnab2) {
		this.usoExclusivoCnab2 = usoExclusivoCnab2;
	}
}
