package com.sample.jmh;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class SpringContext {
    
	private static volatile ConfigurableApplicationContext context;
    
    public static void setContext() {
    	context = SpringApplication.run(ProductApplication.class);
    	// If you want to intialize from applicationContext.xml
    	// return new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    // autowire the Benchmark class into the application context. 
    // This lets you use all other autowired components from the benchmark class.
    // No need declaring them individually as 
    // 	testService = context.getBean("testService", TestService.class);
	//	productService = context.getBean("productRepository", ProductRepository.class);
    public static void autowireBean(Object bean) {
        AutowireCapableBeanFactory factory = context.getAutowireCapableBeanFactory();
        factory.autowireBean(bean);
    }
    
	public static void close() throws IOException {
		context.close();
	}    
    
}
