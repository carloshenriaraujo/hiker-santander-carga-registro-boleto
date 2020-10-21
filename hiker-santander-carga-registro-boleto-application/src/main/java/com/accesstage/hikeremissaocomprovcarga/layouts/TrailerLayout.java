package com.accesstage.hikeremissaocomprovcarga.layouts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;

import com.accesstage.hikeremissaocomprovcarga.enums.TiposCampos;

public class TrailerLayout  implements ILayoutArquivo {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private String[] campos;
	private Range[] tamanhos;
	private Map<String, TiposCampos> tipos = new HashMap<String, TiposCampos>();


	private static final String CODIGO_COMPENSACAO_BANCO		= "codigoCompensacaoBanco";
	private static final String LOTE_SERVICO					= "loteServico";
	private static final String TIPO_REGISTRO					= "tipoRegistro";
	private static final String USO_EXCLUSIVO_CNAB 				= "usoExclusivoCnab";
	private static final String QUANTIDADE_LOTES_ARQUIVO		= "quantidadeLotesArquivo";
	private static final String QUANTIDADE_REGISTROS_ARQUIVO	= "quantidadeRegistrosArquivo";
	private static final String QUANTIDADE_CONTAS_LOTE			= "quantidadeContasLote";
	private static final String USO_EXCLUSIVO_CNAB2				= "usoExclusivoCnab2";

	private static final Range RANGE_CODIGO_COMPENSACAO_BANCO		= new Range(1,3);
	private static final Range RANGE_LOTE_SERVICO					= new Range(4,7);
	private static final Range RANGE_TIPO_REGISTRO					= new Range(8,8);
	private static final Range RANGE_USO_EXCLUSIVO_CNAB 			= new Range(9,17);
	private static final Range RANGE_QUANTIDADE_LOTES_ARQUIVO		= new Range(18,23);
	private static final Range RANGE_QUANTIDADE_REGISTROS_ARQUIVO	= new Range(24,29);
	private static final Range RANGE_QUANTIDADE_CONTAS_LOTE			= new Range(30,35);
	private static final Range RANGE_USO_EXCLUSIVO_CNAB2			= new Range(36,240);



	public TrailerLayout() {
		super();
		this.campos = new String[]{	CODIGO_COMPENSACAO_BANCO	,
									LOTE_SERVICO				,
									TIPO_REGISTRO				,
									USO_EXCLUSIVO_CNAB 			,
									QUANTIDADE_LOTES_ARQUIVO	,
									QUANTIDADE_REGISTROS_ARQUIVO,
									QUANTIDADE_CONTAS_LOTE		,
									USO_EXCLUSIVO_CNAB2};

		this.tamanhos = new Range[] { RANGE_CODIGO_COMPENSACAO_BANCO		,
										RANGE_LOTE_SERVICO					,
										RANGE_TIPO_REGISTRO					,
										RANGE_USO_EXCLUSIVO_CNAB 			,
										RANGE_QUANTIDADE_LOTES_ARQUIVO		,
										RANGE_QUANTIDADE_REGISTROS_ARQUIVO	,
										RANGE_QUANTIDADE_CONTAS_LOTE		,
										RANGE_USO_EXCLUSIVO_CNAB2};

		configurarTiposCampos();
	}

	private void configurarTiposCampos() {

		tipos.put(CODIGO_COMPENSACAO_BANCO		, TiposCampos.NUMERICO);
		tipos.put(LOTE_SERVICO					,TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO					,TiposCampos.NUMERICO);
		tipos.put(USO_EXCLUSIVO_CNAB 			,TiposCampos.ALFA_NUMERICO);
		tipos.put(QUANTIDADE_LOTES_ARQUIVO		,TiposCampos.NUMERICO);
		tipos.put(QUANTIDADE_REGISTROS_ARQUIVO	,TiposCampos.NUMERICO);
		tipos.put(QUANTIDADE_CONTAS_LOTE		,TiposCampos.NUMERICO);
		tipos.put(USO_EXCLUSIVO_CNAB2			,TiposCampos.ALFA_NUMERICO);

	}

	@Override
	public LineTokenizer configurarParser() {

		FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
       tokenizer.setColumns(tamanhos);
       tokenizer.setNames(campos);
       tokenizer.setStrict(true);
       return tokenizer;
	}

	public String[] getCampos() {
		return campos;
	}

	public Range[] getTamanhos() {
		return tamanhos;
	}

	public Map<String, TiposCampos> getTipos() {
		return tipos;
	}

	public void setTipos(Map<String, TiposCampos> tipos) {
		this.tipos = tipos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(tamanhos);
		result = prime * result + Arrays.hashCode(campos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TrailerLayout other = (TrailerLayout) obj;
		if (!Arrays.equals(tamanhos, other.tamanhos))
			return false;
		if (!Arrays.equals(campos, other.campos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrailerLayout [campos=" + Arrays.toString(campos) + ", tamanhos=" + Arrays.toString(tamanhos) + "]";
	}

}
