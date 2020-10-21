package com.accesstage.hikeremissaocomprovcarga.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.accesstage.hikeremissaocomprovcarga.md.Parametros;

public class ParametrosMapper implements RowMapper<Parametros> {

	@Override
	public Parametros mapRow(ResultSet rs, int row) throws SQLException {
		return Parametros.builder()
				.ambiente(rs.getInt("ambiente_registro"))
				.convenio(rs.getString("convenio"))
				.estacao(rs.getString("estacao"))
				.idEmpresa(rs.getLong("id_empresa"))
				.cnpj(rs.getString("cnpj"))
				.sender(rs.getString("sender"))
				.receiver(rs.getString("receiver"))
				.doctype(rs.getString("doctype"))
				.api(rs.getBoolean("api"))
				.edi(rs.getBoolean("edi"))
				.codigoBanco(rs.getLong("cod_banco"))
				.build();
	}

}
