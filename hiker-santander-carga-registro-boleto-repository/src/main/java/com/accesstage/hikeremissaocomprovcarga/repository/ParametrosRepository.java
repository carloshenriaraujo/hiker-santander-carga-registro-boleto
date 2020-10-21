package com.accesstage.hikeremissaocomprovcarga.repository;

import com.accesstage.hikeremissaocomprovcarga.md.Parametros;
import com.accesstage.hikeremissaocomprovcarga.vo.ControleRegistroBoletoVO;
import com.accesstage.hikeremissaocomprovcarga.vo.RetornoRegistroVO;

public interface ParametrosRepository {
	
	Parametros consultaParametros(String cnpj);
	Long insereRegistroRemessa(ControleRegistroBoletoVO boletoVO);
	void insereRetorno(RetornoRegistroVO boletoVO);
	void updateRegistro(String status, Long codigoArquivo);

}
