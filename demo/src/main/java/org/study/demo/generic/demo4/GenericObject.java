package org.study.demo.generic.demo4;

public class GenericObject extends Container<String, String> {

	public GenericObject(String k, String v) {
		super(k, v);
	}
    public String getKey() {
        return super.getKey();
    }

    public void setKey(String key) {
    	super.setKey(key);
    }

    public String getValue() {
        return super.getValue();
    }

    public void setValue(String value) {
        super.setValue(value);
    }
}
