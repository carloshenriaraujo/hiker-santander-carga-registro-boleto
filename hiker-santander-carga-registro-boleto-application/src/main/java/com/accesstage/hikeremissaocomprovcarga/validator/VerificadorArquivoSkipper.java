package com.accesstage.hikeremissaocomprovcarga.validator;

import org.springframework.batch.core.step.skip.SkipLimitExceededException;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.beans.factory.annotation.Autowired;

import com.accesstage.hikeremissaocomprovcarga.error.FileException;

import lombok.extern.slf4j.Slf4j;

/***
 *
 * @author carlos
 * Responsável por informar as linhas do arquivo que estao com problema.
 */
@Slf4j
public class VerificadorArquivoSkipper implements SkipPolicy {

	@Autowired
	private FileException file;

	@Override
    public boolean shouldSkip(Throwable exception, int skipCount) throws SkipLimitExceededException {

		try {

			FlatFileParseException flatFileParseException = (FlatFileParseException) exception;

			file.error("Linha - " + Long.valueOf(flatFileParseException.getLineNumber()) + " Mensagem - " + flatFileParseException.getMessage().toString());

			log.info("ARQUIVO INVALIDO - shouldSkip " + flatFileParseException.getMessage().toString() + "LINHA - " + String.valueOf(flatFileParseException.getLineNumber()));

		} catch (Exception e) {
			log.error("Ocorreu um erro no metodo VerificadorArquivoSkipper.shouldSkip " + e.getMessage());
		}

        return false;
    }
}