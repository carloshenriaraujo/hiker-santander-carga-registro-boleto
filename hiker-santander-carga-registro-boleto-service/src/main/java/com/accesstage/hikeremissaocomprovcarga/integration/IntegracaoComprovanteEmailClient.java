package com.accesstage.hikeremissaocomprovcarga.integration;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.accesstage.hikeremissaocomprovcarga.integration.dto.ComprovanteIndividualEmailRequestDTO;
import com.accesstage.hikeremissaocomprovcarga.integration.dto.StatusEnvioEmailDTO;

//@FeignClient(value="accessdoc-email-individual-endpoint", url="${endpoints.doc.url}")
public interface IntegracaoComprovanteEmailClient {

    @GetMapping(path="/public/v1/emailAutomatico/individual")
    List<StatusEnvioEmailDTO> enviarEmailIndividual(@RequestBody ComprovanteIndividualEmailRequestDTO request);

}
