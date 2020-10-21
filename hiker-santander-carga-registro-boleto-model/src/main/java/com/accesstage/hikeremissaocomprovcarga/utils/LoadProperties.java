package com.accesstage.hikeremissaocomprovcarga.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class LoadProperties {
	private static final Logger LOGGER = Logger.getLogger(LoadProperties.class.getName());

	public static Properties getProperties(String propertiesFile) throws IOException {
		File f = new File(propertiesFile);
		Properties props = null;
		if(f.exists()) {
			props = new Properties();
			props.load(new FileInputStream(f));
		}else {
			LOGGER.severe("Arquivo de propriedades " +
					propertiesFile + " não encontrado. ");
		}
		return props;
	}

	public static Properties getProperties(InputStream propertiesFile) throws IOException {
		Properties props = null;
		props = new Properties();
		props.load(propertiesFile);
		return props;
	}
}
