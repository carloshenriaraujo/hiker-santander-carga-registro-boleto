package com.accesstage.hikeremissaocomprovcarga.integration.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class ComprovanteIndividualEmailRequestDTO {

	@NotNull
	private String tipoPagto;
	
	@NotNull
	private Long idArquivo;
	
}

