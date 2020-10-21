package com.accesstage.hikeremissaocomprovcarga.layouts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;

import com.accesstage.hikeremissaocomprovcarga.enums.TiposCampos;

public class DetalheSegmentoRLayout implements ILayoutArquivo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String[] campos;
	private Range[] tamanhos;
	private Map<String, TiposCampos> tipos = new HashMap<String, TiposCampos>();

	private static final String CODIGO_COMPENSACAO_BANCO = "codigoCompensacaoBanco";
	private static final Range RANGE_CODIGO_COMPENSACAO_BANCO = new Range(1,3);
	
	private static final String LOTE_SERVICO = "loteServico";
	private static final Range RANGE_LOTE_SERVICO = new Range(4,7);
	
	private static final String TIPO_REGISTRO = "tipoRegistro";
	private static final Range RANGE_TIPO_REGISTRO = new Range(8,8);
	
	private static final String NUMERO_SEQUENCIAL_REGISTRO_LOTE = "numeroSequencialRegistroLote";
	private static final Range RANGE_NUMERO_SEQUENCIAL_REGISTRO_LOTE = new Range(9,13);
	
	private static final String CODIGO_SEGMENTO_REG_DETALHE = "codigoSegmentoRegDetalhe";
	private static final Range RANGE_CODIGO_SEGMENTO_REG_DETALHE = new Range(14,14);
	
	private static final String USO_EXCLUSIVO_CNAB = "usoExclusivoCnab";
	private static final Range RANGE_USO_EXCLUSIVO_CNAB = new Range(15,15);
	
	private static final String CODIGO_MOVIMENTO_REMESSA = "codigoMovimentacaoRemessa";
	private static final Range RANGE_CODIGO_MOVIMENTO_REMESSA = new Range(16,17);
	
	private static final String CODIGO_DESCONTO = "codigoDesconto";
	private static final Range RANGE_CODIGO_DESCONTO = new Range(18,18);
	
	private static final String DATA_DESCONTO = "dataDesconto";
	private static final Range RANGE_DATA_DESCONTO = new Range(19,26);
	
	private static final String VALOR_PERCENTUAL_CONCEDIDO = "valorPercentualConcedido";
	private static final Range RANGE_VALOR_PERCENTUAL_CONCEDIDO = new Range(27,41);
	
	private static final String RESERVADO_2 = "reservado2";
	private static final Range RANGE_RESERVADO_2 = new Range(42,65);
	
	private static final String CODIGO_MULTA = "codigoMulta";
	private static final Range RANGE_CODIGO_MULTA = new Range(66,66);
	
	private static final String DATA_MULTA = "dataMulta";
	private static final Range RANGE_DATA_MULTA = new Range(67,74);
	
	private static final String VALOR_PERCENTUAL_APLICADO = "valorPercentualAplicado";
	private static final Range RANGE_VALOR_PERCENTUAL_APLICADO = new Range(75,89);
	
	private static final String RESERVADO_3 = "reservado3";
	private static final Range RANGE_RESERVADO_3 = new Range(90,99);

	private static final String MENSAGEM = "mensagem";
	private static final Range RANGE_MENSAGEM = new Range(100,179);
	
	private static final String RESERVADO_4 = "reservado4";
	private static final Range RANGE_RESERVADO_4 = new Range(180,240);
	
	public DetalheSegmentoRLayout() {
		super();
		this.campos = new String[]{CODIGO_COMPENSACAO_BANCO,
									LOTE_SERVICO,
									TIPO_REGISTRO,
									NUMERO_SEQUENCIAL_REGISTRO_LOTE,
									CODIGO_SEGMENTO_REG_DETALHE,
									USO_EXCLUSIVO_CNAB,
									CODIGO_MOVIMENTO_REMESSA,
									CODIGO_DESCONTO,
									DATA_DESCONTO,
									VALOR_PERCENTUAL_CONCEDIDO,
									RESERVADO_2,
									CODIGO_MULTA,
									DATA_MULTA,
									VALOR_PERCENTUAL_APLICADO,
									RESERVADO_3,
									MENSAGEM,
									RESERVADO_4};

		this.tamanhos = new Range[] {RANGE_CODIGO_COMPENSACAO_BANCO,
										RANGE_LOTE_SERVICO,
										RANGE_TIPO_REGISTRO,
										RANGE_NUMERO_SEQUENCIAL_REGISTRO_LOTE,
										RANGE_CODIGO_SEGMENTO_REG_DETALHE,
										RANGE_USO_EXCLUSIVO_CNAB,
										RANGE_CODIGO_MOVIMENTO_REMESSA,
										RANGE_CODIGO_DESCONTO,
										RANGE_DATA_DESCONTO,
										RANGE_VALOR_PERCENTUAL_CONCEDIDO,
										RANGE_RESERVADO_2,
										RANGE_CODIGO_MULTA,
										RANGE_DATA_MULTA,
										RANGE_VALOR_PERCENTUAL_APLICADO,
										RANGE_RESERVADO_3,
										RANGE_MENSAGEM,
										RANGE_RESERVADO_4};

		configurarTiposCampos();
	}

	private void configurarTiposCampos() {

		tipos.put(CODIGO_COMPENSACAO_BANCO,	TiposCampos.NUMERICO);
		tipos.put(LOTE_SERVICO, TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO, TiposCampos.NUMERICO);
		tipos.put(NUMERO_SEQUENCIAL_REGISTRO_LOTE, TiposCampos.NUMERICO);
		tipos.put(CODIGO_SEGMENTO_REG_DETALHE, TiposCampos.ALFA_NUMERICO);
		tipos.put(USO_EXCLUSIVO_CNAB, TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_MOVIMENTO_REMESSA , TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_DESCONTO , TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_DESCONTO , TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_PERCENTUAL_CONCEDIDO , TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO_2 , TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_MULTA , TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_MULTA , TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_PERCENTUAL_APLICADO , TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO_3 , TiposCampos.ALFA_NUMERICO);
		tipos.put(MENSAGEM , TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO_4 , TiposCampos.ALFA_NUMERICO);
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
		DetalheSegmentoRLayout other = (DetalheSegmentoRLayout) obj;
		if (!Arrays.equals(tamanhos, other.tamanhos))
			return false;
		if (!Arrays.equals(campos, other.campos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetalheSegmentoRLayout [campos=" + Arrays.toString(campos) + ", tamanhos=" + Arrays.toString(tamanhos) + "]";
	}	

}
