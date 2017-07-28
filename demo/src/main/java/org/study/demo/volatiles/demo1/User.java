package org.study.demo.volatiles.demo1;

public class User {
	private static String name;
	private static Integer age;
	public static String getName() {
		return name;
	}
	public static void setName(String name) {
		User.name = name;
	}
	public static Integer getAge() {
		return age;
	}
	public static void setAge(Integer age) {
		User.age = age;
	}
	
}
