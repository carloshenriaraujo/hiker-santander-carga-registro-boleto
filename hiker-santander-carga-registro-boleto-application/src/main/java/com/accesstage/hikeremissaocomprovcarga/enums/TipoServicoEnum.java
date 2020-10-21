package com.accesstage.hikeremissaocomprovcarga.enums;

public enum TipoServicoEnum {

	PAGAMENTO_FORNECEDOR(20),
	PAGAMENTO_CONTAS_TRIBUTOS_IMPOSTOS(22);

	private final Integer codigo;

	private TipoServicoEnum(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

}
