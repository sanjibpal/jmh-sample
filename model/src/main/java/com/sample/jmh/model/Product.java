package com.sample.jmh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TITNDESC")
public class Product implements Serializable {
  private static final long serialVersionUID = 5055630910828730544L;
  @EmbeddedId
  private ProductPK productPK;
  @Column(name = "RES_TYPE")
  private String resType;
  @Column(name = "ITIN_DESC")
  private String value;

  public ProductPK getProductPK() {
    return productPK;
  }

  public void setProductPK(ProductPK productPK) {
    this.productPK = productPK;
  }

  public String getResType() {
    return resType;
  }

  public void setResType(String resType) {
    this.resType = resType;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
