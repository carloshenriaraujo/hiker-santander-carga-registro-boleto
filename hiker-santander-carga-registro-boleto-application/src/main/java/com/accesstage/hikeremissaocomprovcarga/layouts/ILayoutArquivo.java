package com.accesstage.hikeremissaocomprovcarga.layouts;

import java.io.Serializable;

import org.springframework.batch.item.file.transform.LineTokenizer;

public interface ILayoutArquivo extends Serializable{

	public LineTokenizer configurarParser();

}
