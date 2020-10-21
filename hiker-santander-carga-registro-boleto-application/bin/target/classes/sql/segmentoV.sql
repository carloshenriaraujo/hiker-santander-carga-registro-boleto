
CREATE SEQUENCE sch_comprov.segmento_v_id_segmento_v_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;



CREATE TABLE sch_comprov.segmento_v (
	id_segmento_v numeric(10) NOT NULL DEFAULT nextval('sch_comprov.segmento_v_id_segmento_v_seq'::regclass),
	id_header_lote numeric(10) NULL,
	cod_banco_compensacao varchar NULL,
	lote_servico numeric(4) NULL,
	tipo_registro numeric(1) NULL,
	seq_registro_lote numeric(5) NULL,
	cod_seg_registro_detalhe varchar(1) NULL,
	tipo_movimento numeric(1) NULL,
	cod_instrucao_movimento numeric(2) NULL,
	valor_multa_pmsp numeric(15) NULL,
	valor_desconto_pmsp numeric(15) NULL,
	valor_pago_pmsp numeric(15) NULL,
	auten_pcon_pmsp varchar(9) NULL,
	identificador_tributo numeric(3) NULL,
	di_dsi_aiim numeric(9) NULL,
	ident_documento_pmsp varchar(23) NULL,
	valor_tributo_pmsp numeric(15) NULL,
	brancos varchar(15) NULL,
	agencia_pmsp varchar(5) NULL,
	cnpj_contribuinte numeric(15) NULL,
	sequencia_tributo varchar(16) NULL,
	livre varchar(40) NULL,
	CONSTRAINT segmento_v_pkey PRIMARY KEY (id_segmento_v),
	CONSTRAINT fk_segmento_v_segmento_header FOREIGN KEY (id_header_lote) REFERENCES sch_comprov.header_lote(id_header_lote)
);
