package org.study.demo.fastjson;

import com.alibaba.fastjson.JSONObject;

public class User {
	private String name;
	private Integer age;
	private String sex;
	

	public static void main(String[] args) {
		User user = new User();
		user.setName("xiaoli");
		user.setAge(20);
		user.setSex("女");
		
		String str = "{\"age\":20,\"name\":\"xiaoli\",\"sex\":\"女\"}";
		/** 将JSON字符串转换为JSON对象 **/ 
		JSONObject json = JSONObject.parseObject(str);
		System.out.println(json.get("name"));
		
		/** 将JSON字符串转换为JavaBean对象 **/
		user = JSONObject.parseObject(str, User.class);
		System.out.println(user);
		
		/** 将JavaBean对象转换为JSON字符串 **/
		String content = JSONObject.toJSONString(user);
		System.out.println(content);
		
		/** 将JavaBean对象转换为JSONObject **/
		json = (JSONObject)JSONObject.toJSON(user);
		System.out.println(json.get("name"));
	}

	public String toString(){
		return "name:" + this.name + ", age:" + this.age + ", sex:" + this.sex;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}

}
