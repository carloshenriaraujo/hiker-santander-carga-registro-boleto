package com.accesstage.hikeremissaocomprovcarga.integration.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusEnvioEmailDTO {

	private DadosExportacaoDTO dadosComprovante;
	private String from;
	private List<String> destinatariosEmail;
	private String assunto;
	private boolean enviado;
	private String msgErro;
	
	public StatusEnvioEmailDTO(DadosExportacaoDTO dadosComprovante) {
		super();
		this.dadosComprovante = dadosComprovante;
	}
	
	
}
