package com.accesstage.hikeremissaocomprovcarga.layouts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;

import com.accesstage.hikeremissaocomprovcarga.enums.TiposCampos;

public class HeaderLoteLayout implements ILayoutArquivo{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private String[] campos;
	private Range[] tamanhos;
	private Map<String, TiposCampos> tipos = new HashMap<String, TiposCampos>();

	private static final String CODIGO_BANCO_COMPENSACAO	= "codigoBancoCompensacao";
	private static final Range RANGE_CODIGO_BANCO_COMPENSACAO	= new Range(1,3);
	
	private static final String LOTE_SERVICO				= "loteServico";
	private static final Range RANGE_LOTE_SERVICO				= new Range(4,7);
	
	private static final String TIPO_REGISTRO				= "tipoRegistro";
	private static final Range RANGE_TIPO_REGISTRO				= new Range(8,8);
	
	private static final String TIPO_OPERACAO				= "tipoOperacao";
	private static final Range RANGE_TIPO_OPERACAO				= new Range(9,9);
	
	private static final String TIPO_SERVICO				= "tipoServico";
	private static final Range RANGE_TIPO_SERVICO				= new Range(10,11);
	
	private static final String RESERVADO			= "reservado";
	private static final Range RANGE_RESERVADO	= new Range(12,13);
	
	private static final String NUMERO_VERSAO_LAYOUT_LOTE	= "numeroVersaoLayoutLote";
	private static final Range RANGE_NUMERO_VERSAO_LAYOUT_LOTE	= new Range(14,16);
	
	private static final String USO_ESCLUSIVO_CNAB			= "usoExclusiveCnab";
	private static final Range RANGE_USO_ESCLUSIVO_CNAB			= new Range(17,17);
	
	private static final String TIPO_INSCRICAO_EMPRESA 		= "tipoInscricaoEmpresa";
	private static final Range RANGE_TIPO_INSCRICAO_EMPRESA 	= new Range(18,18);
	
	private static final String NUMERO_INSCRICAO_EMPRESA	= "numeroInscricaoEmpresa";
	private static final Range RANGE_NUMERO_INSCRICAO_EMPRESA	= new Range(19,33);
	
	private static final String RESERVADO_2		= "reservado2";
	private static final Range RANGE_RESERVADO_2		= new Range(34,53);
	
	private static final String NOME_BENEFICIARIO				= "nomeBeneficiario";
	private static final Range RANGE_NOME_BENEFICIARIO				= new Range(74,103);
	
	private static final String MENSAGEM					= "mensagem";
	private static final Range RANGE_MENSAGEM					= new Range(104,183);
		
	private static final String NRO_SEQ_REMESSA_RETORNO		= "numeroSequencialRemessaRetorno";
	private static final Range RANGE_NRO_SEQ_REMESSA_RETORNO 	= new Range(184,191);
	
	private static final String DATA_GRAVACAO_REMESSA_RETORNO= "numerodataGravacaoRemessaRetorno";
	private static final Range RANGE_DATA_GRAVACAO_REMESSA_RETORNO = new Range(192,199);

	private static final String USO_EXCLUSIVO_CNAB2			= "usoExclusivoCnab2";
	private static final Range RANGE_USO_EXCLUSIVO_CNAB2		= new Range(200,240);


	public HeaderLoteLayout() {
		super();
		this.campos = new String[]{CODIGO_BANCO_COMPENSACAO	,
									LOTE_SERVICO				,
									TIPO_REGISTRO				,
									TIPO_OPERACAO				,
									TIPO_SERVICO				,
									RESERVADO			,
									NUMERO_VERSAO_LAYOUT_LOTE	,
									USO_ESCLUSIVO_CNAB			,
									TIPO_INSCRICAO_EMPRESA		,
									NUMERO_INSCRICAO_EMPRESA	,
									RESERVADO_2					,
									NOME_BENEFICIARIO			,
									MENSAGEM					,
									NRO_SEQ_REMESSA_RETORNO		,
									DATA_GRAVACAO_REMESSA_RETORNO,
									USO_EXCLUSIVO_CNAB2			};

		this.tamanhos = new Range[] {RANGE_CODIGO_BANCO_COMPENSACAO	,
									RANGE_LOTE_SERVICO				,
									RANGE_TIPO_REGISTRO				,
									RANGE_TIPO_OPERACAO				,
									RANGE_TIPO_SERVICO				,
									RANGE_RESERVADO					,
									RANGE_NUMERO_VERSAO_LAYOUT_LOTE	,
									RANGE_USO_ESCLUSIVO_CNAB		,
									RANGE_TIPO_INSCRICAO_EMPRESA	,
									RANGE_NUMERO_INSCRICAO_EMPRESA	,
									RANGE_RESERVADO_2				,
									RANGE_NOME_BENEFICIARIO			,
									RANGE_MENSAGEM					,
									RANGE_NRO_SEQ_REMESSA_RETORNO	,
									RANGE_DATA_GRAVACAO_REMESSA_RETORNO,
									RANGE_USO_EXCLUSIVO_CNAB2		};

		configurarTiposCampos();
	}

	private void configurarTiposCampos() {

		tipos.put(CODIGO_BANCO_COMPENSACAO			, TiposCampos.NUMERICO);
		tipos.put(LOTE_SERVICO						, TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO						, TiposCampos.NUMERICO);
		tipos.put(TIPO_OPERACAO						, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_SERVICO						, TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO							, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_VERSAO_LAYOUT_LOTE			, TiposCampos.ALFA_NUMERICO);
		tipos.put(USO_ESCLUSIVO_CNAB				, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_INSCRICAO_EMPRESA			, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_INSCRICAO_EMPRESA			, TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO_2						, TiposCampos.ALFA_NUMERICO);
		tipos.put(NOME_BENEFICIARIO					, TiposCampos.ALFA_NUMERICO);
		tipos.put(MENSAGEM							, TiposCampos.ALFA_NUMERICO);
		tipos.put(NRO_SEQ_REMESSA_RETORNO			, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_GRAVACAO_REMESSA_RETORNO		, TiposCampos.ALFA_NUMERICO);
		tipos.put(USO_EXCLUSIVO_CNAB2			 	, TiposCampos.ALFA_NUMERICO);
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
		HeaderLoteLayout other = (HeaderLoteLayout) obj;
		if (!Arrays.equals(tamanhos, other.tamanhos))
			return false;
		if (!Arrays.equals(campos, other.campos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HeaderLoteLayout [campos=" + Arrays.toString(campos) + ", tamanhos=" + Arrays.toString(tamanhos) + "]";
	}


}
