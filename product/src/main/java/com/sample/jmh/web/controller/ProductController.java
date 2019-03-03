package com.sample.jmh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.jmh.dto.ProductDto;
import com.sample.jmh.repository.ProductRepository;

@RestController
@RequestMapping({ "/v1/" })
public class ProductController {
	@Autowired
	private ProductRepository productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<ProductDto> getProducts() {
		return productService.findProducts("A");
	}	
}
