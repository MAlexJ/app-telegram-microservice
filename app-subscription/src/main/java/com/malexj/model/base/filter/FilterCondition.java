package com.malexj.model.base.filter;

public record FilterCondition(
    FilterValueType valueType,
    String value,
    FilterOperationType operationType,
    FilterCondition link) {

  public FilterCondition(FilterValueType valueType, String value) {
    this(valueType, value, null, null);
  }
}
