package com.example.demo.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class ConsoleBatchConfig {
    @Autowired
    public JobBuilderFactory jobBuilderFactory;
    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job processJob(){
        return jobBuilderFactory.get("processJob").listener(consoleListener()).flow(consoleStep())
                .end().build();
    }

    @Bean
    public Step consoleStep(){
        return stepBuilderFactory.get("consoleStep")
                .<String,String>chunk(3).reader(stringReader()).processor(convertProcessor())
                .writer(consoleWriter()).build();
    }

    @Bean
    public ItemReader stringReader(){return new StringReader();}

    @Bean
    public ItemWriter consoleWriter(){return new ConsoleWriter();}

    @Bean
    public ItemProcessor convertProcessor(){return new ConsoleProcessor();}

    @Bean
    public JobExecutionListener consoleListener(){return new ConsoleJobEndListener();}
}