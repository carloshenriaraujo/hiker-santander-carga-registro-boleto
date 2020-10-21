package com.accesstage.hikeremissaocomprovcarga.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.skip.SkipPolicy;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.accesstage.hikeremissaocomprovcarga.dto.SantanderDTO;
import com.accesstage.hikeremissaocomprovcarga.processor.ComprovanteProcessor;
import com.accesstage.hikeremissaocomprovcarga.read.SantanderReader;
import com.accesstage.hikeremissaocomprovcarga.validator.VerificadorArquivoSkipper;
import com.accesstage.hikeremissaocomprovcarga.writer.ComprovanteWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

    @Bean
	@StepScope
	public MultiResourceItemReader<FieldSet> reader() throws Exception {
		return new SantanderReader().read();
	}

	@Bean
	public ComprovanteProcessor processor() {
		return new ComprovanteProcessor();
	}

	@Bean
	public Job jobCargaComprovantes() throws Exception {
		return jobBuilderFactory
				.get("jobCargaComprovantes")
				.incrementer(new RunIdIncrementer())
				.flow(step1())
				.end()
				.build();
	}

	@Bean
	public Step step1() throws Exception {
		return stepBuilderFactory.get("step1")
				.<FieldSet, SantanderDTO>chunk(Integer.MAX_VALUE)
				.reader(reader())
				.faultTolerant()
				.skipPolicy(verificadorArquivoSkipper())
				.processor(processor())
				.writer(writer())
				.build();
	}

	@Bean
	public SkipPolicy verificadorArquivoSkipper() {
		return new VerificadorArquivoSkipper();
	}

	@Bean
	public ComprovanteWriter writer() {
		return new ComprovanteWriter();
	}

}
