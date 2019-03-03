package com.sample.jmh.web.controller;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.TearDown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sample.jmh.ProductApplication;
import com.sample.jmh.SpringContext;
import com.sample.jmh.dto.ProductDto;
import com.sample.jmh.repository.ProductRepository;
@State(Scope.Thread)
public class ProductControllerBenchmark {
	@Autowired
	private ConfigurableApplicationContext context;
	
	@Autowired
	private ProductRepository productService;
	
	@Autowired
	private TestService testService;
	
    @Setup
    public void init() {
    	SpringContext.setContext();
    	SpringContext.autowireBean(this);
    }	

	@Benchmark
    public Long checkCacheableAnnotationPerformance() {
		return testService.annotatedService();
    }

	@Benchmark
    public Long checkManualCachePerformance() {
		return testService.manualProducts("key");
    }
	
	@Benchmark
    public List<ProductDto> productH2call() {
    	return productService.findProducts("A");
    }
	
	@TearDown
	public void close() throws IOException {
		SpringContext.close();
	}
}
