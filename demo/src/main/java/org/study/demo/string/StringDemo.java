package org.study.demo.string;

import java.util.HashMap;

public class StringDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strVal = "";
		Integer intVal = 1;
		char charVal = 1;
		HashMap map = new HashMap<>();
		Object obj = new Object();
		System.out.println(strVal.hashCode());
		char [] b = {'a',' ','s','t','u','d','e','n','t'};		
		System.out.println("字符串与 Integer 进行 equals 比较：" + strVal.equals(intVal));
		System.out.println("字符串与 char 进行equals比较：" + strVal.equals(charVal));
		System.out.println("字符串与 String 进行equals比较：" + strVal.equals("1"));
	}

}
