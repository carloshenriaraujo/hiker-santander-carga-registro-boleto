package com.accesstage.hikeremissaocomprovcarga.error;

import org.springframework.stereotype.Component;

import com.accesstage.hikeremissaocomprovcarga.dto.ErroDTO;

@Component
public class FileException {

	/***
	 * Metodo responsavel por guardar as mensagens de erro.
	 * @param mensagem
	 */
	public void error(String mensagem)	{

		ErroDTO erroDTO = new ErroDTO();

		erroDTO.setDescricaoErro(mensagem);
	}

}
