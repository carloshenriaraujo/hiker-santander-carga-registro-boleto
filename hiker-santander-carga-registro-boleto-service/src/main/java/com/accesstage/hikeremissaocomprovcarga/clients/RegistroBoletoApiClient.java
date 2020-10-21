package com.accesstage.hikeremissaocomprovcarga.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.accesstage.hikeremissaocomprovcarga.dto.BoletoResponseDTO;
import com.accesstage.hikeremissaocomprovcarga.md.EntradaRequest;

@FeignClient(name="santanter-api", url="${endpoints.registrar.url}")
public interface RegistroBoletoApiClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/registraBoleto")
	BoletoResponseDTO registraBoleto(EntradaRequest parametros);

}
