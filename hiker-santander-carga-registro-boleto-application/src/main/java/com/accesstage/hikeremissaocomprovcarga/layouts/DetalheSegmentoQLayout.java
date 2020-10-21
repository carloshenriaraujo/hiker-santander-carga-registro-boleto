 package com.accesstage.hikeremissaocomprovcarga.layouts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;

import com.accesstage.hikeremissaocomprovcarga.enums.TiposCampos;

public class DetalheSegmentoQLayout implements ILayoutArquivo{

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
	
	private static final String TIPO_INSCRICAO = "tipoInscricao";
	private static final Range RANGE_TIPO_INSCRICAO = new Range(18,18);
	
	private static final String NRO_INSCRICAO = "numeroInscricao";
	private static final Range RANGE_NRO_INSCRICAO = new Range(19,33);
	
	private static final String NOME = "nome";
	private static final Range RANGE_NOME = new Range(34,73);
	
	private static final String ENDERECO = "endereco";
	private static final Range RANGE_ENDERECO = new Range(74,113);
	
	private static final String BAIRRO = "bairro";
	private static final Range RANGE_BAIRRO = new Range(114,128);
	
	private static final String CEP = "cep";
	private static final Range RANGE_CEP = new Range(129,133);
	
	private static final String SUFIXO_CEP = "sufixoCep";
	private static final Range RANGE_SUFIXO_CEP = new Range(134,136);
	
	private static final String CIDADE = "cidade";
	private static final Range RANGE_CIDADE = new Range(137,151);

	private static final String UNIDADE_FEDERACAO = "unidadeFederacao";
	private static final Range RANGE_UNIDADE_FEDERACAO = new Range(152,153);
	
	private static final String TIPO_INSCRICAO_SACADO = "tipoInscricaoSacado";
	private static final Range RANGE_TIPO_INSCRICAO_SACADO = new Range(154,154);
	
	private static final String NRO_INSCRICAO_SACADO = "numeroInscricaoSacado";
	private static final Range RANGE_NRO_INSCRICAO_SACADO = new Range(155,169);
	
	private static final String NOME_SACADO = "nomeSacado";
	private static final Range RANGE_NOME_SACADO = new Range(170,209);
	
	private static final String IDENTIFICADOR_CARNE = "identificadorCarne";
	private static final Range RANGE_IDENTIFICADOR_CARNE = new Range(210,212);
	
	private static final String SEQUENCIAL_PARCELA = "sequencialParcela";
	private static final Range RANGE_SEQUENCIAL_PARCELA = new Range(213,215);
	
	private static final String QUANTIDADE_PARCELA = "quantidadeParcela";	
	private static final Range RANGE_QUANTIDADE_PARCELA = new Range(216,218);	
	
	private static final String NUMERO_PLANO = "numeroPlano";	
	private static final Range RANGE_NUMERO_PLANO = new Range(219,221);	

	private static final String RESERVADO = "reservado";	
	private static final Range RANGE_RESERVADO = new Range(222,240);	
	
	public DetalheSegmentoQLayout() {
		super();
		this.campos = new String[]{CODIGO_COMPENSACAO_BANCO,
									LOTE_SERVICO,
									TIPO_REGISTRO,
									NUMERO_SEQUENCIAL_REGISTRO_LOTE,
									CODIGO_SEGMENTO_REG_DETALHE,
									USO_EXCLUSIVO_CNAB,
									CODIGO_MOVIMENTO_REMESSA,
									TIPO_INSCRICAO,
									NRO_INSCRICAO,
									NOME,
									ENDERECO,
									BAIRRO,
									CIDADE,
									CEP,
									SUFIXO_CEP,
									UNIDADE_FEDERACAO,
									TIPO_INSCRICAO_SACADO,
									NRO_INSCRICAO_SACADO,
									NOME_SACADO,
									IDENTIFICADOR_CARNE,
									SEQUENCIAL_PARCELA,
									QUANTIDADE_PARCELA,
									NUMERO_PLANO,
									RESERVADO};

		this.tamanhos = new Range[] {RANGE_CODIGO_COMPENSACAO_BANCO,
										RANGE_LOTE_SERVICO,
										RANGE_TIPO_REGISTRO,
										RANGE_NUMERO_SEQUENCIAL_REGISTRO_LOTE,
										RANGE_CODIGO_SEGMENTO_REG_DETALHE,
										RANGE_USO_EXCLUSIVO_CNAB,
										RANGE_CODIGO_MOVIMENTO_REMESSA,
										RANGE_TIPO_INSCRICAO,
										RANGE_NRO_INSCRICAO,
										RANGE_NOME,
										RANGE_ENDERECO,
										RANGE_BAIRRO,
										RANGE_CIDADE,
										RANGE_CEP,
										RANGE_SUFIXO_CEP,
										RANGE_UNIDADE_FEDERACAO,
										RANGE_TIPO_INSCRICAO_SACADO,
										RANGE_NRO_INSCRICAO_SACADO,
										RANGE_NOME_SACADO,
										RANGE_IDENTIFICADOR_CARNE,
										RANGE_SEQUENCIAL_PARCELA,
										RANGE_QUANTIDADE_PARCELA,
										RANGE_NUMERO_PLANO,
										RANGE_RESERVADO};

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
		tipos.put(TIPO_INSCRICAO , TiposCampos.ALFA_NUMERICO);
		tipos.put(NRO_INSCRICAO , TiposCampos.ALFA_NUMERICO);
		tipos.put(NOME , TiposCampos.ALFA_NUMERICO);
		tipos.put(ENDERECO , TiposCampos.ALFA_NUMERICO);
		tipos.put(BAIRRO , TiposCampos.ALFA_NUMERICO);
		tipos.put(CIDADE , TiposCampos.ALFA_NUMERICO);
		tipos.put(CEP , TiposCampos.ALFA_NUMERICO);
		tipos.put(SUFIXO_CEP , TiposCampos.ALFA_NUMERICO);
		tipos.put(UNIDADE_FEDERACAO , TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_INSCRICAO_SACADO , TiposCampos.ALFA_NUMERICO);
		tipos.put(NRO_INSCRICAO_SACADO , TiposCampos.ALFA_NUMERICO);
		tipos.put(NOME_SACADO , TiposCampos.ALFA_NUMERICO);
		tipos.put(IDENTIFICADOR_CARNE , TiposCampos.ALFA_NUMERICO);
		tipos.put(SEQUENCIAL_PARCELA , TiposCampos.ALFA_NUMERICO);
		tipos.put(QUANTIDADE_PARCELA , TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_PLANO , TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO , TiposCampos.ALFA_NUMERICO);
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
		DetalheSegmentoQLayout other = (DetalheSegmentoQLayout) obj;
		if (!Arrays.equals(tamanhos, other.tamanhos))
			return false;
		if (!Arrays.equals(campos, other.campos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetalheSegmentoQLayout [campos=" + Arrays.toString(campos) + ", tamanhos=" + Arrays.toString(tamanhos) + "]";
	}

}
