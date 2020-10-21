package com.accesstage.hikeremissaocomprovcarga.layouts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;

import com.accesstage.hikeremissaocomprovcarga.enums.TiposCampos;

public class HeaderLayout implements ILayoutArquivo{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private String[] campos;
	private Range[] tamanhos;
	private Map<String, TiposCampos> tipos = new HashMap<String, TiposCampos>();

	private static final String CODIGO_BANCO_COMPENSACAO= "codigoBancoCompensacao";
	private static final Range RANGE_CODIGO_BANCO_COMPENSACAO = new Range(1,3);

	private static final String LOTE_SERVICO = "loteServico";
	private static final Range RANGE_LOTE_SERVICO = new Range(4,7);

	private static final String TIPO_REGISTRO = "tipoRegistro";
	private static final Range RANGE_TIPO_REGISTRO = new Range(8,8);

	private static final String RESERVADO = "reservado";
	private static final Range RANGE_RESERVADO = new Range(9,16);

	private static final String TIPO_INSCRICAO_EMPRESA = "tipoInscricaoEmpresa";
	private static final Range RANGE_TIPO_INSCRICAO_EMPRESA = new Range(17,17);

	private static final String NUMERO_INSCRICAO_EMPRESA= "numeroInscricaoEmpresa";
	private static final Range RANGE_NUMERO_INSCRICAO_EMPRESA = new Range(18,32);

	private static final String CODIGO_TRANSMISSAO = "codigoTransmissao";
	private static final Range RANGE_CODIGO_TRANSMISSAO = new Range(33,47);
	
	private static final String EXCLUSIVO_CNAB_1 = "exclusivoCnab1";
	private static final Range RANGE_EXCLUSIVO_CNAB_1 = new Range(48,72);	

	private static final String NOME_EMPRESA = "nomeEmpresa";
	private static final Range RANGE_NOME_EMPRESA = new Range(73,102);	

	private static final String NOME_BANCO = "nomeBanco";
	private static final Range RANGE_NOME_BANCO = new Range(103,132);

	private static final String EXCLUSIVO_CNAB_2 = "exclusivoCnab2";
	private static final Range RANGE_EXCLUSIVO_CNAB_2 = new Range(133,142);

	private static final String CODIGO_REMESSA = "codigoRemessa";
	private static final Range RANGE_CODIGO_REMESSA = new Range(143,143);

	private static final String DATA_GERACAO_ARQUIVO = "dataGeracaoArquivo";
	private static final Range RANGE_DATA_GERACAO_ARQUIVO = new Range(144,151);

	private static final String EXCLUSIVO_CNAB_3 = "exclusivoCnab3";
	private static final Range RANGE_EXCLUSIVO_CNAB_3 = new Range(152,157);

	private static final String NUMERO_SEQUENCIAL_ARQUIVO = "numeroSequencialArquivo";
	private static final Range RANGE_NUMERO_SEQUENCIAL_ARQUIVO = new Range(158,163);

	private static final String NUMERO_VERSAO_LAYOUT_ARQUIVO = "numeroVersaoLayoutArquivo";
	private static final Range RANGE_NUMERO_VERSAO_LAYOUT_ARQUIVO = new Range(164,166);

	private static final String EXCLUSIVO_CNAB_4 = "exclusivoCnab4";
	private static final Range RANGE_EXCLUSIVO_CNAB_4 = new Range(167,240);


	public HeaderLayout() {
		super();

		this.tamanhos = new Range[] {RANGE_CODIGO_BANCO_COMPENSACAO 		,
				RANGE_LOTE_SERVICO 					,
				RANGE_TIPO_REGISTRO 				,
				RANGE_RESERVADO 					,
				RANGE_TIPO_INSCRICAO_EMPRESA 		,
				RANGE_NUMERO_INSCRICAO_EMPRESA 		,
				RANGE_CODIGO_TRANSMISSAO 			,
				RANGE_EXCLUSIVO_CNAB_1				,
				RANGE_NOME_EMPRESA 					,
				RANGE_NOME_BANCO 					,
				RANGE_EXCLUSIVO_CNAB_2 				,
				RANGE_CODIGO_REMESSA 				,
				RANGE_DATA_GERACAO_ARQUIVO 			,
				RANGE_EXCLUSIVO_CNAB_3				,
				RANGE_NUMERO_SEQUENCIAL_ARQUIVO 	,
				RANGE_NUMERO_VERSAO_LAYOUT_ARQUIVO 	,
				RANGE_EXCLUSIVO_CNAB_4};		
		
		this.campos = new String[]{CODIGO_BANCO_COMPENSACAO 		,
									LOTE_SERVICO 					,
									TIPO_REGISTRO 					,
									RESERVADO 						,
									TIPO_INSCRICAO_EMPRESA 			,
									NUMERO_INSCRICAO_EMPRESA 		,
									CODIGO_TRANSMISSAO 				,
									EXCLUSIVO_CNAB_1				,
									NOME_EMPRESA 					,
									NOME_BANCO 						,
									EXCLUSIVO_CNAB_2 				,
									CODIGO_REMESSA 					,
									DATA_GERACAO_ARQUIVO 			,
									EXCLUSIVO_CNAB_3				,
									NUMERO_SEQUENCIAL_ARQUIVO 		,
									NUMERO_VERSAO_LAYOUT_ARQUIVO 	,
									EXCLUSIVO_CNAB_4};


		configurarTiposCampos();
	}

	private void configurarTiposCampos() {

		tipos.put(CODIGO_BANCO_COMPENSACAO 		, TiposCampos.NUMERICO);
		tipos.put(LOTE_SERVICO 					, TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO 				, TiposCampos.NUMERICO);
		tipos.put(RESERVADO 				, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_INSCRICAO_EMPRESA 		, TiposCampos.NUMERICO);
		tipos.put(NUMERO_INSCRICAO_EMPRESA 		, TiposCampos.NUMERICO);
		tipos.put(CODIGO_TRANSMISSAO 		, TiposCampos.ALFA_NUMERICO);
		tipos.put(EXCLUSIVO_CNAB_1 		, TiposCampos.ALFA_NUMERICO);
		tipos.put(NOME_EMPRESA 			, TiposCampos.NUMERICO);
		tipos.put(NOME_BANCO 			, TiposCampos.ALFA_NUMERICO);
		tipos.put(EXCLUSIVO_CNAB_2 		, TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_REMESSA 		, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_GERACAO_ARQUIVO 	, TiposCampos.ALFA_NUMERICO);
		tipos.put(EXCLUSIVO_CNAB_3 		, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_SEQUENCIAL_ARQUIVO 	, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_VERSAO_LAYOUT_ARQUIVO 	, TiposCampos.ALFA_NUMERICO);
		tipos.put(EXCLUSIVO_CNAB_4 	, TiposCampos.ALFA_NUMERICO);
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
		HeaderLayout other = (HeaderLayout) obj;
		if (!Arrays.equals(tamanhos, other.tamanhos))
			return false;
		if (!Arrays.equals(campos, other.campos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HeaderLayout [campos=" + Arrays.toString(campos) + ", tamanhos=" + Arrays.toString(tamanhos) + "]";
	}


}
