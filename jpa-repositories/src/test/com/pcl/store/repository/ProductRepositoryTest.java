package com.pcl.store.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.pcl.core.util.UserThreadLocal;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductRepositoryTest implements InitializingBean {
    
	public void afterPropertiesSet() {
		UserThreadLocal.set("PC");
	}
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void test_find_Products() throws Exception {
    	assertNotNull(productRepository.findProducts("A"));
    }
 	
}
