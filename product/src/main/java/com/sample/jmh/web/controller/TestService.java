package com.sample.jmh.web.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class TestService {
	private final Cache products;
	
	public TestService(CacheManager cacheManager) {
		products = cacheManager.getCache("products");
	}
	@Cacheable("products")
	public Long annotatedService() {
		return products();
	}
	
	public Long products() {
		try {
			TimeUnit.MILLISECONDS.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return System.currentTimeMillis();
	}
	
    public Long manualProducts(String key) {
        Cache.ValueWrapper valueWrapper = products.get(key);
        Long result;
        if (valueWrapper == null) {
        	result = products();
        	products.put(key, result);
        } else {
        	result = (Long) valueWrapper.get();
        }
        return result;
      }
}
