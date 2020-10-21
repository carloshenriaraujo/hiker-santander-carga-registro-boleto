package com.accesstage.hikeremissaocomprovcarga.enums;

public enum FormaLancamentoEnum {
	
	CREDITO_CONTA_CORRENTE(01 , "Crédito em Conta Corrente/Salário"),
	CHEQUE_PAGAMENTO(02 , "Cheque Pagamento / Administrativo"),
	DOC_TED(03 , "DOC/TED (1) (2)"),
	CONTAS_ALARIO(04 , "Cartão Salário"),
	CREDITO_CONTA_POUPANCA(05 , "Crédito em Conta Poupança"),
	OP_DISPOSICAO(10 , "OP à Disposição"),
	PAGAMENTO_CONTAS_TRIBUTOS_CODIGO_BARRAS(11 , "Pagamento de Contas e Tributos com Código de Barras"),
	TRIBUTO_DARF_NORMAL(16 , "Tributo - DARF Normal"),
	TRIBUTO_GPS(17 , "Tributo - GPS (Guia da Previdência Social)"),
	TRIBUTO_DARF_SIMPLES(18 , "Tributo - DARF Simples"),
	TRIBUTO_IPTU(19 , "Tributo - IPTU – Prefeituras"),
	PAGAMENTO_AUTENTICACAO(20 , "Pagamento com Autenticação"),
	TRIBUTO_DARJ(21 , "Tributo – DARJ"),
	TRIBUTO_GARE_ICMS(22 , "Tributo - GARE-SP ICMS"),
	TRIBUTO_GARE_DR(23 , "Tributo - GARE-SP DR"),
	TRIBUTO_GARE_ITCMD(24 , "Tributo - GARE-SP ITCMD"),
	TRIBUTO_IPVA(25 , "Tributo - IPVA"),
	TRIBUTO_LICENCIAMENTO(26 , "Tributo - Licenciamento"),
	TRIBUTO_DPVAT(27 , "Tributo – DPVAT"),
	LIQUIDACAO_TITULOS_PROPRIO_BANCO(30 , "Liquidação de Títulos do Próprio Banco"),
	PAGAMENTO_TITULOS_OUTROS_BANCOS(31 , "Pagamento de Títulos de Outros Bancos"),
	EXTRATO_CONTA_CORRENTE(40 , "Extrato de Conta Corrente"),
	TED_OUTRA_TITULARIDADE(41 , "TED – Outra Titularidade (1)"),
	TED_MESMA_TITULARIDADE(43 , "TED – Mesma Titularidade (1)"),
	TED_TRANSFERENCIA_CONTA_INVESTIMENTO(44 , "TED para Transferência de Conta Investimento"),
	DEBITO_CONTA_CORRENTE(50 , "Débito em Conta Corrente"),
	EXTRATO_GESTAO_CAIXA(70 , "Extrato para Gestão de Caixa"),
	DEPOSITO_JUDICIAL_CONTA_CORRENTE(71 , "Depósito Judicial em Conta Corrente"),
	DEPOSITO_JUDICIAL_CONTA_POUPANCA(72 , "Depósito Judicial em Poupança"),
	EXTRATO_CONTA_INVESTIMENTO(73 , "Extrato de Conta Investimento");

	private final Integer codigo;
	private final String nome;

	private FormaLancamentoEnum(Integer codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

}
