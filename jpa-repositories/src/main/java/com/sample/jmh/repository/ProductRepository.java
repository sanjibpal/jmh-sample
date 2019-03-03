package com.sample.jmh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sample.jmh.dto.ProductDto;
import com.sample.jmh.model.Product;
import com.sample.jmh.model.ProductPK;

public interface ProductRepository extends JpaRepository<Product, ProductPK> {
  @Query("select new com.sample.jmh.dto.ProductDto(" + "p.productPK.id, p.productPK.tradeCode," + "p.resType, p.value) "
      + "from com.sample.jmh.model.Product p where p.productPK.tradeCode = ?1")
  List<ProductDto> findProducts(String tradeCode);
}
