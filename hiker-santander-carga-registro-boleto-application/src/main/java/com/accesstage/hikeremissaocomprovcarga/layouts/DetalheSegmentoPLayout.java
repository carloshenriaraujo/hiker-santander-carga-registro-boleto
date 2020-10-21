package com.accesstage.hikeremissaocomprovcarga.layouts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;

import com.accesstage.hikeremissaocomprovcarga.enums.TiposCampos;

public class DetalheSegmentoPLayout implements ILayoutArquivo{


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private String[] campos;
	private Range[] tamanhos;
	private Map<String, TiposCampos> tipos = new HashMap<String, TiposCampos>();

	private static final String CODIGO_COMPENSACAO_BANCO		= "codigoCompensacaoBanco";
	private static final Range RANGE_CODIGO_COMPENSACAO_BANCO	= new Range(1,3);
	
	private static final String LOTE_SERVICO					= "loteServico";
	private static final Range RANGE_LOTE_SERVICO				= new Range(4,7);
	
	private static final String TIPO_REGISTRO					= "tipoRegistro";
	private static final Range RANGE_TIPO_REGISTRO				= new Range(8,8);
	
	private static final String NUMERO_SEQUENCIAL_REGISTRO_LOTE	= "numeroSequencialRegistroLote";
	private static final Range RANGE_NUMERO_SEQUENCIAL_REGISTRO_LOTE= new Range(9,13);
	
	private static final String CODIGO_SEGMENTO_REG_DETALHE		= "codigoSegmentoRegDetalhe";
	private static final Range RANGE_CODIGO_SEGMENTO_REG_DETALHE= new Range(14,14);
	
	private static final String USO_EXCLUSIVO_CNAB				= "usoExclusivoCnab";
	private static final Range RANGE_USO_EXCLUSIVO_CNAB			= new Range(15,15);
	
	private static final String CODIGO_MOVIMENTO_REMESSA 		= "codigoMovimentoRemessa";
	private static final Range RANGE_CODIGO_MOVIMENTO_REMESSA			= new Range(16,17);
	
	private static final String AGENCIA_MANTENEDORA 			= "agenciaMantenedora";
	private static final Range RANGE_AGENCIA_MANTENEDORA		= new Range(18,21);
	
	private static final String DIGITO_VERIFICADOR_AGENCIA_M 	= "digitoVerificadorAgencia";
	private static final Range RANGE_DIGITO_VERIFICADOR_AGENCIA_M= new Range(22,22);
	
	private static final String NUMERO_CONTA_CORRENTE 			= "numeroContaCorrente";
	private static final Range RANGE_NUMERO_CONTA_CORRENTE		= new Range(23,31);
	
	private static final String DIGITO_VERIFICADOR_CONTA		= "digitoNumeroContaCorrente";
	private static final Range RANGE_DIGITO_VERIFICADOR_CONTA	= new Range(32,32);	
	
	private static final String CONTA_COBRANCA_DESTINATARIO		= "contaCobrancaDestinatariaFIDC";
	private static final Range RANGE_CONTA_COBRANCA_DESTINATARIO	= new Range(33,41);
	
	private static final String DIGITO_CONTA_COBRANCA_DESTINATARIO		= "digitoContaCobrancaDestinatariaFIDC";
	private static final Range RANGE_DIGITO_CONTA_COBRANCA_DESTINATARIO	= new Range(42,42);	
	
	private static final String RESERVADO						= "reservado";
	private static final Range RANGE_RESERVADO					= new Range(43,44);		

	private static final String IDENTIFICACAO_TITULO_BANCO		= "identificacaoTituloBanco";
	private static final Range RANGE_IDENTIFICACAO_TITULO_BANCO	= new Range(45,57);
	
	private static final String TIPO_COBRANCA					= "tipoCobranca";
	private static final Range RANGE_TIPO_COBRANCA				= new Range(58,58);
	
	private static final String FORMA_CADASTRO					= "formaCadastro";
	private static final Range RANGE_FORMA_CADASTRO				= new Range(59,59);

	private static final String TIPO_DOCUMENTO					= "tipoDocumento";
	private static final Range RANGE_TIPO_DOCUMENTO				= new Range(60,60);
	
	private static final String RESERVADO_2						= "reservado2";
	private static final Range RANGE_RESERVADO_2				= new Range(61,62);	
	
	private static final String NUMERO_DOCUMENTO_COBRANCA		= "numeroDocumentoCobranca";
	private static final Range RANGE_NUMERO_DOCUMENTO_COBRANCA	= new Range(63,77);
	
	private static final String DATA_VENCIMENTO_TITULO			= "dataVencimentoTitulo";
	private static final Range RANGE_DATA_VENCIMENTO_TITULO		= new Range(78,85);
	
	private static final String VALOR_NOMINAL_TITULO			= "valorNominalTitulo";
	private static final Range RANGE_VALOR_NOMINAL_TITULO		= new Range(86,100);		

	private static final String AGENCIA_ENCA_COBRANCA			= "agenciaEncarregadaCobranca";
	private static final Range RANGE_AGENCIA_ENCA_COBRANCA		= new Range(101,104);
	
	private static final String DIG_AGENCIA_ENCA_COBRANCA		= "digitoAgenciaEncarregadaCobranca";
	private static final Range RANGE_DIG_AGENCIA_ENCA_COBRANCA	= new Range(105,105);
	
	private static final String RESERVADO_3						= "reservado3";
	private static final Range RANGE_RESERVADO_3				= new Range(106,106);		
	
	private static final String ESPECIE_TITULO					= "especieTitulo";
	private static final Range RANGE_ESPECIE_TITULO				= new Range(107,108);
	
	private static final String IDENTIFICACAO_TITULO_ACEITO		= "identificacaoTituloAceito";
	private static final Range RANGE_IDENTIFICACAO_TITULO_ACEITO= new Range(109,109);
	
	private static final String DATA_EMISSAO_TITULO				= "dataEmissaoTitulo";
	private static final Range RANGE_DATA_EMISSAO_TITULO		= new Range(110,117);
	
	private static final String CODIGO_JUROS_MORA				= "codigoJurosMora";
	private static final Range RANGE_CODIGO_JUROS_MORA		= new Range(118,118);	

	private static final String DATA_JUROS_MORA				= "dataJurosMora";
	private static final Range RANGE_DATA_JUROS_MORA		= new Range(119,126);

	private static final String JUROS_MORA_TAXA				= "jurosMoraTaxa";
	private static final Range RANGE_JUROS_MORA_TAXA		= new Range(127,141);

	private static final String CODIGO_DESCONTO				= "codigoDesconto";
	private static final Range RANGE_CODIGO_DESCONTO		= new Range(142,142);

	private static final String DATA_DESCONTO				= "dataDesconto";
	private static final Range RANGE_DATA_DESCONTO			= new Range(143,150);

	private static final String VALOR_PERCEN_CONCE			= "valorPercentualConcebido";
	private static final Range RANGE_VALOR_PERCEN_CONCE		= new Range(151,165);
	
	private static final String VALOR_IOF					= "valorIof";
	private static final Range RANGE_VALOR_IOF				= new Range(166,180);
	
	private static final String VALOR_ABATIMENTO			= "valorAbatimento";
	private static final Range RANGE_VALOR_ABATIMENTO		= new Range(181,195);

	private static final String IDENTIFICACAO_TITULO_EMPRESA= "identificacaoTituloEmpresa";
	private static final Range RANGE_IDENTIFICACAO_TITULO_EMPRESA= new Range(196,220);
	
	private static final String CODIGO_PRTOTESTO			= "codigoProtesto";
	private static final Range RANGE_CODIGO_PRTOTESTO		= new Range(221,221);	

	private static final String NUMERO_DIAS_PROTESTO		= "numeroDiasProtesto";
	private static final Range RANGE_NUMERO_DIAS_PROTESTO	= new Range(222,223);
	
	private static final String CODIGO_BAIXA_DEVOLUCAO		= "codigoBaixaDevolucao";
	private static final Range RANGE_CODIGO_BAIXA_DEVOLUCAO	= new Range(224,224);
	
	private static final String RESERVADO_4					= "reservado4";
	private static final Range RANGE_RESERVADO_4			= new Range(225,225);	
	
	private static final String NRO_DIAS_BAIXA_DEVOLUCAO	= "numeroDiasBaixaDevolucao";
	private static final Range RANGE_NRO_DIAS_BAIXA_DEVOLUCAO= new Range(226,227);	

	private static final String CODIGO_MOEDA				= "codigoMoeda";
	private static final Range RANGE_CODIGO_MOEDA			= new Range(228,229);	
	
	private static final String USO_EXCLUSIVO_FEBRA			= "usoExclusivoFebraban";
	private static final Range RANGE_USO_EXCLUSIVO_FEBRA	= new Range(230,240);	
	
	public DetalheSegmentoPLayout() {
		super();

		this.tamanhos = new Range[] {RANGE_CODIGO_COMPENSACAO_BANCO		,
									RANGE_LOTE_SERVICO					,
									RANGE_TIPO_REGISTRO					,
									RANGE_NUMERO_SEQUENCIAL_REGISTRO_LOTE,
									RANGE_CODIGO_SEGMENTO_REG_DETALHE,
									RANGE_USO_EXCLUSIVO_CNAB,
									RANGE_CODIGO_MOVIMENTO_REMESSA,
									RANGE_AGENCIA_MANTENEDORA,
									RANGE_DIGITO_VERIFICADOR_AGENCIA_M,
									RANGE_NUMERO_CONTA_CORRENTE,
									RANGE_DIGITO_VERIFICADOR_CONTA,
									RANGE_CONTA_COBRANCA_DESTINATARIO,
									RANGE_DIGITO_CONTA_COBRANCA_DESTINATARIO,
									RANGE_RESERVADO,
									RANGE_IDENTIFICACAO_TITULO_BANCO,
									RANGE_TIPO_COBRANCA,
									RANGE_FORMA_CADASTRO,
									RANGE_TIPO_DOCUMENTO,
									RANGE_RESERVADO_2,
									RANGE_NUMERO_DOCUMENTO_COBRANCA,
									RANGE_DATA_VENCIMENTO_TITULO,
									RANGE_VALOR_NOMINAL_TITULO,
									RANGE_AGENCIA_ENCA_COBRANCA,
									RANGE_DIG_AGENCIA_ENCA_COBRANCA,
									RANGE_RESERVADO_3,
									RANGE_ESPECIE_TITULO,
									RANGE_IDENTIFICACAO_TITULO_ACEITO,
									RANGE_DATA_EMISSAO_TITULO,
									RANGE_CODIGO_JUROS_MORA,
									RANGE_DATA_JUROS_MORA,
									RANGE_JUROS_MORA_TAXA,
									RANGE_CODIGO_DESCONTO,
									RANGE_DATA_DESCONTO,
									RANGE_VALOR_PERCEN_CONCE,
									RANGE_VALOR_IOF,
									RANGE_VALOR_ABATIMENTO,
									RANGE_IDENTIFICACAO_TITULO_EMPRESA,
									RANGE_CODIGO_PRTOTESTO,
									RANGE_NUMERO_DIAS_PROTESTO,
									RANGE_CODIGO_BAIXA_DEVOLUCAO,
									RANGE_RESERVADO_4,
									RANGE_NRO_DIAS_BAIXA_DEVOLUCAO,
									RANGE_CODIGO_MOEDA,
									RANGE_USO_EXCLUSIVO_FEBRA									
									};
		
		this.campos = new String[]{CODIGO_COMPENSACAO_BANCO		,
				LOTE_SERVICO					,
				TIPO_REGISTRO					,
				NUMERO_SEQUENCIAL_REGISTRO_LOTE	,
				CODIGO_SEGMENTO_REG_DETALHE		,
				USO_EXCLUSIVO_CNAB,
				CODIGO_MOVIMENTO_REMESSA,
				AGENCIA_MANTENEDORA,
				DIGITO_VERIFICADOR_AGENCIA_M,
				NUMERO_CONTA_CORRENTE,
				DIGITO_VERIFICADOR_CONTA,
				CONTA_COBRANCA_DESTINATARIO,
				DIGITO_CONTA_COBRANCA_DESTINATARIO,
				RESERVADO,
				IDENTIFICACAO_TITULO_BANCO,
				TIPO_COBRANCA,
				FORMA_CADASTRO,
				TIPO_DOCUMENTO,
				RESERVADO_2,
				NUMERO_DOCUMENTO_COBRANCA,
				DATA_VENCIMENTO_TITULO,
				VALOR_NOMINAL_TITULO,
				AGENCIA_ENCA_COBRANCA,
				DIG_AGENCIA_ENCA_COBRANCA,
				RESERVADO_3,
				ESPECIE_TITULO,
				IDENTIFICACAO_TITULO_ACEITO,
				DATA_EMISSAO_TITULO,
				CODIGO_JUROS_MORA,
				DATA_JUROS_MORA,
				JUROS_MORA_TAXA,
				CODIGO_DESCONTO,
				DATA_DESCONTO,
				VALOR_PERCEN_CONCE,
				VALOR_IOF,
				VALOR_ABATIMENTO,
				IDENTIFICACAO_TITULO_EMPRESA,
				CODIGO_PRTOTESTO,
				NUMERO_DIAS_PROTESTO,
				CODIGO_BAIXA_DEVOLUCAO,
				RESERVADO_4,
				NRO_DIAS_BAIXA_DEVOLUCAO,
				CODIGO_MOEDA,
				USO_EXCLUSIVO_FEBRA
				};		

		configurarTiposCampos();
	}

	private void configurarTiposCampos() {

		tipos.put(CODIGO_COMPENSACAO_BANCO			, TiposCampos.NUMERICO);
		tipos.put(LOTE_SERVICO						, TiposCampos.NUMERICO);
		tipos.put(TIPO_REGISTRO						, TiposCampos.NUMERICO);
		tipos.put(NUMERO_SEQUENCIAL_REGISTRO_LOTE	, TiposCampos.NUMERICO);
		tipos.put(CODIGO_SEGMENTO_REG_DETALHE		, TiposCampos.ALFA_NUMERICO);
		tipos.put(USO_EXCLUSIVO_CNAB				, TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_MOVIMENTO_REMESSA			, TiposCampos.ALFA_NUMERICO);
		tipos.put(AGENCIA_MANTENEDORA				, TiposCampos.ALFA_NUMERICO);
		tipos.put(DIGITO_VERIFICADOR_AGENCIA_M		, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_CONTA_CORRENTE				, TiposCampos.NUMERICO);
		tipos.put(DIGITO_VERIFICADOR_CONTA			, TiposCampos.ALFA_NUMERICO);
		tipos.put(CONTA_COBRANCA_DESTINATARIO		, TiposCampos.ALFA_NUMERICO);
		tipos.put(DIGITO_CONTA_COBRANCA_DESTINATARIO, TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO			, TiposCampos.ALFA_NUMERICO);
		tipos.put(IDENTIFICACAO_TITULO_BANCO		, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_COBRANCA						, TiposCampos.ALFA_NUMERICO);
		tipos.put(FORMA_CADASTRO		, TiposCampos.ALFA_NUMERICO);
		tipos.put(TIPO_DOCUMENTO		, TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO_2			, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_DOCUMENTO_COBRANCA	, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_VENCIMENTO_TITULO	, TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_NOMINAL_TITULO		, TiposCampos.ALFA_NUMERICO);
		tipos.put(AGENCIA_ENCA_COBRANCA		, TiposCampos.ALFA_NUMERICO);
		tipos.put(DIG_AGENCIA_ENCA_COBRANCA	, TiposCampos.ALFA_NUMERICO);
		tipos.put(ESPECIE_TITULO			, TiposCampos.ALFA_NUMERICO);
		tipos.put(IDENTIFICACAO_TITULO_ACEITO, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_EMISSAO_TITULO		, TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_JUROS_MORA			, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_JUROS_MORA			, TiposCampos.ALFA_NUMERICO);
		tipos.put(JUROS_MORA_TAXA			, TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_DESCONTO			, TiposCampos.ALFA_NUMERICO);
		tipos.put(DATA_DESCONTO			, TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_PERCEN_CONCE			, TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_IOF			, TiposCampos.ALFA_NUMERICO);
		tipos.put(VALOR_ABATIMENTO			, TiposCampos.ALFA_NUMERICO);
		tipos.put(IDENTIFICACAO_TITULO_EMPRESA			, TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_PRTOTESTO			, TiposCampos.ALFA_NUMERICO);
		tipos.put(NUMERO_DIAS_PROTESTO		, TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_BAIXA_DEVOLUCAO	, TiposCampos.ALFA_NUMERICO);
		tipos.put(RESERVADO_4				, TiposCampos.ALFA_NUMERICO);		
		tipos.put(NRO_DIAS_BAIXA_DEVOLUCAO	, TiposCampos.ALFA_NUMERICO);
		tipos.put(CODIGO_MOEDA			, TiposCampos.ALFA_NUMERICO);
		tipos.put(USO_EXCLUSIVO_FEBRA		, TiposCampos.ALFA_NUMERICO);
		
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
		DetalheSegmentoPLayout other = (DetalheSegmentoPLayout) obj;
		if (!Arrays.equals(tamanhos, other.tamanhos))
			return false;
		if (!Arrays.equals(campos, other.campos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetalheSegmentoPLayout [campos=" + Arrays.toString(campos) + ", tamanhos=" + Arrays.toString(tamanhos) + "]";
	}

}
