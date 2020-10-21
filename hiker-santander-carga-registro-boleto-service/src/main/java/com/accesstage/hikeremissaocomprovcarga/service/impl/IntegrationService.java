package com.accesstage.hikeremissaocomprovcarga.service.impl;

import java.io.File;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.accesstage.hikeremissaocomprovcarga.enums.CaminhoArquivoEnum;
import com.accesstage.hikeremissaocomprovcarga.service.IGerenciadorArquivos;
import com.accesstage.hikeremissaocomprovcarga.service.IIntegrationService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class IntegrationService implements IIntegrationService {

	private static final String NOME_SISTEMA = "hiker-emissaocomprovcarga";

	@Autowired
	@Qualifier("jobCargaComprovantes")
	private Job jobCargaComprovantes;

	@Autowired
	private JobLauncher jobLauncher;

	private JobExecution execution;

	@Autowired
	private IGerenciadorArquivos gerenciadorArquivos;

	File diretorioExecucao = null;
	File arquivo = null;
	File diretorioSaida = null;
	private boolean arquivoValido = true;

	@Override
	public void execute() throws Exception {
		try {
			movimentaArquivoEExecutaBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * Orquestrador
	 */
	private void movimentaArquivoEExecutaBatch() {
		try {
			File arquivosDiretorioOrigem = new File(CaminhoArquivoEnum.DIRETORIO_ENTRADA.getCaminho());
			diretorioExecucao = new File(CaminhoArquivoEnum.DIRETORIO_EXECUCAO.getCaminho());
			diretorioSaida = new File(CaminhoArquivoEnum.DIRETORIO_SUCESSO.getCaminho());
			if (arquivosDiretorioOrigem.exists()) {
				File arrayArquivos[] = arquivosDiretorioOrigem.listFiles();
				int i = 0;
				/** Move os arquivos para o diretório de execução 1 por vez **/
				if (arrayArquivos.length > 0) {
					for (int j = arrayArquivos.length; i < j; i++) {
						arquivo = arrayArquivos[i];
						if (gerenciadorArquivos.validarArquivoLock(arquivo)) {
							return;
						}
						arquivo = gerenciadorArquivos.renomearArquivo(arquivo);
						gerenciadorArquivos.moveArquivoParaDiretorio(diretorioExecucao, arquivo);
						executeProcessoBatch();
						gerenciadorArquivos.moverArquivosEntreDiretorios(
								CaminhoArquivoEnum.DIRETORIO_EXECUCAO.getCaminho(),
								CaminhoArquivoEnum.DIRETORIO_SUCESSO.getCaminho());
					}
				}
			} else {
				log.info("Diretórios não existem, por favor crie os diretórios!");
			}
		} catch (Exception e) {
			setArquivoValido(false);
			String mensagemErro = "Ocorreu um erro no processamento do arquivo  -  " + e.getMessage();
			log.error(mensagemErro);
		}
	}

	/***
	 * Metodo que exucuta o batch
	 * 
	 * @throws Exception
	 */
	private void executeProcessoBatch() throws Exception {
		try {
			JobParameters param = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
					.toJobParameters();
			execution = jobLauncher.run(jobCargaComprovantes, param);
			log.info("Exit Status : " + execution.getStatus());
		} catch (Exception e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}

	public boolean isArquivoValido() {
		return arquivoValido;
	}

	public void setArquivoValido(boolean arquivoValido) {
		this.arquivoValido = arquivoValido;
	}

}
