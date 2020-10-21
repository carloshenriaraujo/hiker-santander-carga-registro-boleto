package com.accesstage.hikeremissaocomprovcarga.md;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaRequest {
	
	private String codigoBanco;
	private  String codigoConvenio;
	private String pagadorTpDoc;
	private  String pagadorNumDoc;
	private  String pagadorNome;
	private  String pagadorEnder;
	private String pagadorBairro;
	private String pagadorCidade;
	private String pagadorUf;
	private String pagadorCep;
	private String tituloNossoNumero;
	private String tituloSeuNumero;
	private String tituloDtVencto;
	private String tituloDtEmissao;
	private String tituloEspecie;
	private String tituloVlNominal;
	private String tituloPcMulta;
	private String tituloQtDiasMulta;
	private String tituloPcJuro;
	private String tituloPcDesc;
	private String tituloVlDesc;
	private String tituloDtLimiDesc;
	private String tituloVlAbatimento;
	private String tituloTpProtesto;
	private String tituloQtDiasProtesto;
	private String tituloQtDiasBaixa;
	private String mensagem;
	private String estacao;
	private String ambiente;
	private String sistema;
	
	
}
