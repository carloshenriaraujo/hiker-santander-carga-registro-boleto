package com.accesstage.hikeremissaocomprovcarga.layouts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;

import com.accesstage.hikeremissaocomprovcarga.enums.TiposCampos;

public class TrailerLoteLayout implements ILayoutArquivo{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private String[] campos;
	private Range[] tamanhos;
	private Map<String, TiposCampos> tipos = new HashMap<String, TiposCampos>();


	private static final String CODIGO_COMPENSACAO_BANCO	= "codigoCompensacaoBanco";
	private static final Range RANGE_CODIGO_COMPENSACAO_BANCO	= new Range(1,3);
	
	private static final String LOTE_SERVICO				= "loteServico";
	private static final Range RANGE_LOTE_SERVICO				= new Range(4,7);
	
	private static final String TIPO_REGISTRO				= "tipoRegistro";
	private static final Range RANGE_TIPO_REGISTRO				= new Range(8,8);
	
	private static final String USO_EXCLUSIVO_CNAB 			= "usoExclusivoCnab";
	private static final Range RANGE_USO_EXCLUSIVO_CNAB 		= new Range(9,17);
	
	private static final String QUANTIDADE_REGISTROS_LOTE	= "quantidadeRegistroLote";
	private static final Range RANGE_QUANTIDADE_REGISTROS_LOTE	= new Range(18,23);
	
	private static final String QUANTIDADE_TITULOS_COBRADOS	= "qtdTitulosCobrados";
	private static final Range RANGE_QUANTIDADE_TITULOS_COBRADOS= new Range(24,29);
	
	private static final String VALOR_TOTAL_TITULO_CARTEIRA_SIMPLES	= "valorTotalTituloCarteiraSimples";
	private static final Range RANGE_VALOR_TOTAL_TITULO_CARTEIRA_SIMPLES= new Range(30,46);	

	private static final String QTD_TITULOS_COBRANCA		= "qtdTitulosCobranca";
	private static final Range RANGE_QTD_TITULOS_COBRANCA		= new Range(47,52);
	
	private static final String VALOR_TOTAL_TITULO_CARTEIRA_VINCULADA		= "valorTotalTitulosCarteiraVinculada";
	private static final Range RANGE_VALOR_TOTAL_TITULO_CARTEIRA_VINCULADA	= new Range(53,69);
	
	private static final String QTD_TITULOS_COBRANCA_CAUCI	= "qtdTitulosCobrancaCaucionada";
	private static final Range RANGE_QTD_TITULOS_COBRANCA_CAUCI	= new Range(70,75);
	
	private static final String VALOR_TITULOS_COBRANCA_CAUCI	= "valorTotalTituloCarteiraCaucionada";
	private static final Range RANGE_VALOR_TITULOS_COBRANCA_CAUCI	= new Range(76,92);	
	
	private static final String QTD_TITULOS_COBRANCA_DESCO	= "qtdTitulosCobrancaDescontada";
	private static final Range RANGE_QTD_TITULOS_COBRANCA_DESCO	= new Range(93,98);
	
	private static final String VALOR_TITULOS_COBRANCA_DESCO	= "valorTotalTituloCarteiraDescontada";
	private static final Range RANGE_VALOR_TITULOS_COBRANCA_DESCO	= new Range(99,115);
	
	private static final String NRO_AVISO	= "numeroAviso";
	private static final Range RANGE_NRO_AVISO	= new Range(116,123);
	
	private static final String USO_EXCLUSIVO_CNAB_2	= "usoExclusivoCnab2";
	private static final Range RANGE_USO_EXCLUSIVO_CNAB_2	= new Range(124,240);	

	public TrailerLoteLayout() {
		super();
		this.campos = new String[]{	CODIGO_COMPENSACAO_BANCO	,
									LOTE_SERVICO				,
									TIPO_REGISTRO				,
									USO_EXCLUSIVO_CNAB 			,
									QUANTIDADE_REGISTROS_LOTE	,
									QUANTIDADE_TITULOS_COBRADOS,
									VALOR_TOTAL_TITULO_CARTEIRA_SIMPLES,
									QTD_TITULOS_COBRANCA,
									VALOR_TOTAL_TITULO_CARTEIRA_VINCULADA,
									QTD_TITULOS_COBRANCA_CAUCI,
									VALOR_TITULOS_COBRANCA_CAUCI,
									QTD_TITULOS_COBRANCA_DESCO,
									VALOR_TITULOS_COBRANCA_DESCO,
									NRO_AVISO,
									USO_EXCLUSIVO_CNAB_2
									};

		this.tamanhos = new Range[] { RANGE_CODIGO_COMPENSACAO_BANCO		,
										RANGE_LOTE_SERVICO					,
										RANGE_TIPO_REGISTRO					,
										RANGE_USO_EXCLUSIVO_CNAB 			,
										RANGE_QUANTIDADE_REGISTROS_LOTE		,
										RANGE_QUANTIDADE_TITULOS_COBRADOS,
										RANGE_VALOR_TOTAL_TITULO_CARTEIRA_SIMPLES,
										RANGE_QTD_TITULOS_COBRANCA,
										RANGE_VALOR_TOTAL_TITULO_CARTEIRA_VINCULADA,
										RANGE_QTD_TITULOS_COBRANCA_CAUCI,
										RANGE_VALOR_TITULOS_COBRANCA_CAUCI,
										RANGE_QTD_TITULOS_COBRANCA_DESCO,
										RANGE_VALOR_TITULOS_COBRANCA_DESCO,
										RANGE_NRO_AVISO,
										RANGE_USO_EXCLUSIVO_CNAB_2	};

		configurarTiposCampos();
	}

	private void configurarTiposCampos() {

		tipos.put(CODIGO_COMPENSACAO_BANCO	, TiposCampos.NUMERICO);
		tipos.put(LOTE_SERVICO				,TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO				,TiposCampos.NUMERICO);
		tipos.put(USO_EXCLUSIVO_CNAB 			,TiposCampos.ALFA_NUMERICO);
		tipos.put(QUANTIDADE_REGISTROS_LOTE	,TiposCampos.NUMERICO);
		tipos.put(QUANTIDADE_TITULOS_COBRADOS	,TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_TOTAL_TITULO_CARTEIRA_SIMPLES	,TiposCampos.ALFA_NUMERICO);
		tipos.put(QTD_TITULOS_COBRANCA	,TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_TOTAL_TITULO_CARTEIRA_VINCULADA	,TiposCampos.ALFA_NUMERICO);
		tipos.put(QTD_TITULOS_COBRANCA_CAUCI	,TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_TITULOS_COBRANCA_CAUCI	,TiposCampos.ALFA_NUMERICO);
		tipos.put(QTD_TITULOS_COBRANCA_DESCO	,TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_TITULOS_COBRANCA_DESCO	,TiposCampos.ALFA_NUMERICO);
		tipos.put(NRO_AVISO	,TiposCampos.ALFA_NUMERICO);
		tipos.put(USO_EXCLUSIVO_CNAB_2	,TiposCampos.ALFA_NUMERICO);

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
		TrailerLoteLayout other = (TrailerLoteLayout) obj;
		if (!Arrays.equals(tamanhos, other.tamanhos))
			return false;
		if (!Arrays.equals(campos, other.campos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TrailerLoteLayout [campos=" + Arrays.toString(campos) + ", tamanhos=" + Arrays.toString(tamanhos) + "]";
	}

}
