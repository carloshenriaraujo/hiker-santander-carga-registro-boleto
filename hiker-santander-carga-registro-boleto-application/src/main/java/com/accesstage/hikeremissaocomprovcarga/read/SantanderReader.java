package com.accesstage.hikeremissaocomprovcarga.read;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.mapping.PassThroughFieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.PatternMatchingCompositeLineTokenizer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourceArrayPropertyEditor;

import com.accesstage.hikeremissaocomprovcarga.enums.CaminhoArquivoEnum;
import com.accesstage.hikeremissaocomprovcarga.layouts.DetalheSegmentoPLayout;
import com.accesstage.hikeremissaocomprovcarga.layouts.DetalheSegmentoQLayout;
import com.accesstage.hikeremissaocomprovcarga.layouts.DetalheSegmentoRLayout;
import com.accesstage.hikeremissaocomprovcarga.layouts.HeaderLayout;
import com.accesstage.hikeremissaocomprovcarga.layouts.HeaderLoteLayout;
import com.accesstage.hikeremissaocomprovcarga.layouts.TrailerLayout;
import com.accesstage.hikeremissaocomprovcarga.layouts.TrailerLoteLayout;

/**
 *
 * @author
 *
 */
public class SantanderReader implements ItemReader<MultiResourceItemReader<FieldSet>>, ItemStream, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private final static String HEADER = "???????0*";
	private final static String HEADER_LOTE = "???????1R*";
	private final static String DETALHE_SEGMENTO_P = "???????3?????P*";
	private final static String DETALHE_SEGMENTO_Q = "???????3?????Q*";
	private final static String DETALHE_SEGMENTO_R = "???????3?????R*";
	private final static String TRAILER_LOTE = "???????5*";
	private final static String TRAILER = "???????9*";

	private FlatFileItemReader<FieldSet> flatFileItemReader;
	private MultiResourceItemReader<FieldSet> multiResourceItemReader;

	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		flatFileItemReader = new FlatFileItemReader<>();
	}

	@AfterStep
	public void afterStep(StepExecution stepExecution) {
		flatFileItemReader.close();
		multiResourceItemReader.close();
	}

	@Override
	public void open(ExecutionContext arg0) throws ItemStreamException {

		multiResourceItemReader = new MultiResourceItemReader<>();
		multiResourceItemReader.setResources(getArquivos());
		multiResourceItemReader.setStrict(false);
		multiResourceItemReader.open(arg0);
	}

	@Override
	public MultiResourceItemReader<FieldSet> read()
			throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

			flatFileItemReader = new FlatFileItemReader<FieldSet>();
			multiResourceItemReader = new MultiResourceItemReader<>();
			multiResourceItemReader.setResources(getArquivos());
			multiResourceItemReader.setStrict(false);
			final DefaultLineMapper<FieldSet> defaultLineMapper = new DefaultLineMapper<FieldSet>();
			final PatternMatchingCompositeLineTokenizer orderFileTokenizer = new PatternMatchingCompositeLineTokenizer();
			orderFileTokenizer.setTokenizers(setTokenizers());
			defaultLineMapper.setLineTokenizer(orderFileTokenizer);

			defaultLineMapper.setFieldSetMapper(new PassThroughFieldSetMapper());

			flatFileItemReader.setLineMapper(defaultLineMapper);
			flatFileItemReader.afterPropertiesSet();
			defaultLineMapper.afterPropertiesSet();
			multiResourceItemReader.setDelegate(flatFileItemReader);

		return multiResourceItemReader;
	}

	private Map<String, LineTokenizer> setTokenizers() {
		final Map<String, LineTokenizer> tokenizers = new HashMap<>();

		HeaderLayout headerLayout = new HeaderLayout();
		tokenizers.put(HEADER, headerLayout.configurarParser());

		HeaderLoteLayout headerLoteLayout = new HeaderLoteLayout();
		tokenizers.put(HEADER_LOTE, headerLoteLayout.configurarParser());

		DetalheSegmentoPLayout detalheSegmentoPLayout = new DetalheSegmentoPLayout();
		tokenizers.put(DETALHE_SEGMENTO_P, detalheSegmentoPLayout.configurarParser());

		DetalheSegmentoQLayout detalheSegmentoQLayout = new DetalheSegmentoQLayout();
		tokenizers.put(DETALHE_SEGMENTO_Q, detalheSegmentoQLayout.configurarParser());
		
		DetalheSegmentoRLayout detalheSegmentoRLayout = new DetalheSegmentoRLayout();
		tokenizers.put(DETALHE_SEGMENTO_R, detalheSegmentoRLayout.configurarParser());		

		TrailerLoteLayout trailerLoteLayout = new TrailerLoteLayout();
		tokenizers.put(TRAILER_LOTE, trailerLoteLayout.configurarParser());

		TrailerLayout trailerLayout = new TrailerLayout();
		tokenizers.put(TRAILER, trailerLayout.configurarParser());

		return tokenizers;
	}

	private Resource[] getArquivos() {
			ResourceArrayPropertyEditor resourceLoader = new ResourceArrayPropertyEditor();
			resourceLoader.setAsText(CaminhoArquivoEnum.ARQUIVO_EXECUCAO.getCaminho());
			Resource[] resources = (Resource[]) resourceLoader.getValue();
		return resources;
	}

	@Override
	public void close() throws ItemStreamException {

	}

	@Override
	public void update(ExecutionContext arg0) throws ItemStreamException {

	}
}
