package com.sample.jmh.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
  private static final long serialVersionUID = 5055630910828730544L;
  private String id;
  private String tradeCode;
  private String resType;
  private String value;

  public ProductDto(String id, String trade, String resType, String value) {
    this.id = id;
    this.tradeCode = trade;
    this.resType = resType;
    this.value = value;
  }

  public String getId() {
    return id;
  }

  public String getTradeCode() {
    return tradeCode;
  }

  public String getResType() {
    return resType;
  }

  public String getValue() {
    return value;
  }
}
