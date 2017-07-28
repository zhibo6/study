package org.study.demo.generic.demo2;

public class Container2 {
    private Integer key;
    private String value;

    public Container2(Integer k, String v) {
        key = k;
        value = v;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}