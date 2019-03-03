package com.sample.jmh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductPK implements Serializable {
  private static final long serialVersionUID = 5055630910828730544L;
  @Column(name = "WEB_ITIN_CODE")
  private String id;
  @Column(name = "TRADE_CODE")
  private String tradeCode;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTradeCode() {
    return tradeCode;
  }

  public void setTradeCode(String tradeCode) {
    this.tradeCode = tradeCode;
  }
}
