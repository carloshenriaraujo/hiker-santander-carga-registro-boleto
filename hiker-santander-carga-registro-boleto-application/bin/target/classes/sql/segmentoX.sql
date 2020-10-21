
CREATE SEQUENCE sch_comprov.segmento_x_id_segmento_x_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;



CREATE TABLE sch_comprov.segmento_x (
	id_segmento_x numeric(10) NOT NULL DEFAULT nextval('sch_comprov.segmento_x_id_segmento_x_seq'::regclass),
	id_header_lote numeric(10) NULL,
	cod_banco_compensacao varchar NULL,
	lote_servico numeric(4) NULL,
	tipo_registro numeric(1) NULL,
	seq_registro_lote numeric(5) NULL,
	cod_seg_registro_detalhe varchar(1) NULL,
	tipo_movimento numeric(1) NULL,
	cod_instrucao_movimento numeric(2) NULL,
	nome_contribuinte varchar(10) NULL,
	endereco_contribuinte varchar(40) NULL,
	cep_contribuinte numeric(5) NULL,
	cep_complemento numeric(3) NULL,
	codigo_pagamento numeric(4) NULL,
	identificador_documento varchar(26) NULL,
	valor_honorario_advo numeric(15)NULL,
	ufde varchar(2) NULL,
	valor_acrescimento_financeiro numeric (15) NULL,
	codigo_receita numeric(6) NULL,
	campos_brancos varchar(15) NULL,
	numero_identificacao_pmsp varchar(15) NULL,
	identificacao_pagamento_pmsp varchar(40) NULL,
	valor_documento numeric(15) NULL,
	valor_juros_pmsp numeric(15) NULL,
	CONSTRAINT segmento_x_pkey PRIMARY KEY (id_segmento_x),
	CONSTRAINT fk_segmento_x_segmento_header FOREIGN KEY (id_header_lote) REFERENCES sch_comprov.header_lote(id_header_lote)
);
