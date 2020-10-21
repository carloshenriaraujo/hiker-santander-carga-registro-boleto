
CREATE SEQUENCE sch_comprov.segmento_d_id_segmento_d_seq
INCREMENT BY 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1;



CREATE TABLE sch_comprov.segmento_d (
	id_segmento_d numeric(10) NOT NULL DEFAULT nextval('sch_comprov.segmento_d_id_segmento_d_seq'::regclass),
	id_segmento_a numeric(10) NULL,
	id_segmento_j numeric(10) NULL,
	cod_banco_compensacao varchar NULL,
	lote_servico numeric(4) NULL,
	tipo_registro numeric(1) NULL,
	seq_registro_lote numeric(5) NULL,
	cod_seg_registro_detalhe varchar(1) NULL,
	tipo_movimento numeric(1) NULL,
	cod_instrucao_movimento numeric(2) NULL,
	uso_exclusivo_febraban varchar NULL,
	nro_nota_fiscal numeric (10) null,
	carteira numeric(3) null,
	livre varchar null,
	tipo_documento numeric (3),
	data_emissao_documento numeric (8),
	uso_empresa varchar(20),
	carteira_segmento_j numeric(3),
	numero_pagamento varchar,
	codigo_banco_fornecedor numeric(3),
	codigo_lancamento numeric(6),
	tipo_conta_fornecedor numeric(3),
	codigo_ocorrencia varchar,
	CONSTRAINT segmento_d_pkey PRIMARY KEY (id_segmento_d),
	CONSTRAINT fk_segmento_d_segmento_a1 FOREIGN KEY (id_segmento_a) REFERENCES sch_comprov.segmento_a(id_segmento_a),
	CONSTRAINT fk_segmento_d_segmento_j1 FOREIGN KEY (id_segmento_j) REFERENCES sch_comprov.segmento_j(id_segmento_j)
);
