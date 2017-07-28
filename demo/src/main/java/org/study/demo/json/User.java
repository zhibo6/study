package org.study.demo.json;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	@JSONField(ordinal = 1)
	private String name;
	@JSONField(ordinal = 2, name = "nianlin")
	private String age;
	@JSONField(ordinal = 3)
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
