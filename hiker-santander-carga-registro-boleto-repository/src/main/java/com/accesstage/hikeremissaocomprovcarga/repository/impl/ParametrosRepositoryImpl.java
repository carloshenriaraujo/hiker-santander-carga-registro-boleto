package com.accesstage.hikeremissaocomprovcarga.repository.impl;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.accesstage.hikeremissaocomprovcarga.mappers.ParametrosMapper;
import com.accesstage.hikeremissaocomprovcarga.md.Parametros;
import com.accesstage.hikeremissaocomprovcarga.repository.ParametrosRepository;
import com.accesstage.hikeremissaocomprovcarga.vo.ControleRegistroBoletoVO;
import com.accesstage.hikeremissaocomprovcarga.vo.RetornoRegistroVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class ParametrosRepositoryImpl implements ParametrosRepository{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Parametros consultaParametros(String cnpj) {
		final String sql = "SELECT id_empresa, cod_banco, sender, receiver, doctype"
				+ ", ambiente_registro, api, edi, convenio, estacao, cnpj"  
				+ " FROM sch_regbol.parametros_santander "
				+ " WHERE cnpj =  :cnpj" ;

		final MapSqlParameterSource params = new MapSqlParameterSource()
				.addValue("cnpj", cnpj);
		
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), params, new ParametrosMapper());

		}catch (EmptyResultDataAccessException e) {
			log.info(e.getMessage());
			return null;
		}
	}

	@Override
	public Long insereRegistroRemessa(ControleRegistroBoletoVO boletoVO) {
		final String sql = " INSERT INTO sch_regbol.controle_registro_boleto" 
				+ "(cod_arquivo, status, cnpj, layout, tracking, dt_processamento, sentido_transacao, ambiente)"  
				+ " values "
				+ " (nextval('sch_regbol.cod_arquivo_seq'), :status, :cnpj, :layout, :tracking, :dtProcessamento, :sentidoTransacao, :ambiente)";

		final MapSqlParameterSource map = new MapSqlParameterSource()
				.addValue("status", boletoVO.getStatus())
				.addValue("cnpj", boletoVO.getCnpj())
				.addValue("layout", boletoVO.getLayout())
				.addValue("dtProcessamento", new Timestamp(new Date().getTime()))
				.addValue("sentidoTransacao", boletoVO.getSentidoTransacao())
				.addValue("ambiente", boletoVO.getAmbiente())
				.addValue("tracking", boletoVO.getTracking());

		log.info(sql);
		KeyHolder holder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, map, holder);
		 boletoVO.setCodigoArquivo((Long) holder.getKeys().get("cod_arquivo"));
		 return boletoVO.getCodigoArquivo();
	}

	@Override
	public void insereRetorno(RetornoRegistroVO boletoVO) {
		final String sql = " INSERT INTO sch_regbol.retorno_registro_boleto " 
				+ "( cod_arquivo, codigo_barras, linha_digitavel, nosso_numero, codigo_erro, numero_titulo, pagador, convenio, valor_titulo) " 
				+ " VALUES "
				+ " (:codArquivo, :codBarra, :linhaDigitavel, :nossoNumero, :codigoErro, :numeroTitulo, :pagador, :convenio, :valorTitulo)";

		final MapSqlParameterSource map = new MapSqlParameterSource()
				.addValue("codArquivo", boletoVO.getCodArquivo())
				.addValue("codBarra", boletoVO.getCodigoBarras())
				.addValue("linhaDigitavel", boletoVO.getLinhaDigitavel())
				.addValue("nossoNumero", boletoVO.getNossoNumero())
				.addValue("codigoErro", boletoVO.getErro())
				.addValue("numeroTitulo", boletoVO.getNumeroTitulo())
				.addValue("pagador", boletoVO.getPagador())
				.addValue("convenio", boletoVO.getConvenio())
				.addValue("valorTitulo", boletoVO.getValorTitulo());

		log.info(sql);
		KeyHolder holder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, map, holder);		
	}

	@Override
	public void updateRegistro(String status, Long codigoArquivo) {
		final String sql = " UPDATE sch_regbol.controle_registro_boleto " 
				+ "SET status= :status WHERE cod_arquivo = :codigoArquivo";

		final MapSqlParameterSource map = new MapSqlParameterSource()
				.addValue("codigoArquivo", codigoArquivo)
				.addValue("status", status);

		log.info(sql);
		KeyHolder holder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, map, holder);		
	}

}
