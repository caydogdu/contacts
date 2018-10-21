package com.contacts.search;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Filter {

    private String key;

    private Operator operator;

    private String value;

    public Filter() {
        // default cons
    }

    public Filter(String key, Operator operator, String value) {
        this.key = key;
        this.operator = operator;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Operator getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
