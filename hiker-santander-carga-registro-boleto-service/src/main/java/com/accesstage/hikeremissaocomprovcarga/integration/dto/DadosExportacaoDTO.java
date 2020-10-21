package com.accesstage.hikeremissaocomprovcarga.integration.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
public class DadosExportacaoDTO {

	@NotNull
	private String tipoPagto;
	
	@NotNull
	private String modPagto;
	
	@NotNull
	private Long idArquivo;
	
	@NotNull
	private Long idLote;
	
	@NotNull
	private Long idSeqLote;
	
	@JsonIgnore
	private String cnpjEmpresa;

	
}
