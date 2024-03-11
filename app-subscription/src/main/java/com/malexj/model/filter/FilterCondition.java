package com.malexj.model.filter;

public record FilterCondition(
    FilterValueType valueType,
    String value,
    FilterOperationType operationType,
    FilterCondition link) {

  public FilterCondition(FilterValueType valueType, String value) {
    this(valueType, value, null, null);
  }
}
