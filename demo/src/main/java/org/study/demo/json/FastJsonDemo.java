package org.study.demo.json;

import com.alibaba.fastjson.JSON;

public class FastJsonDemo {

	public static void main(String[] args) {
		User user = new User();
		user.setName("json");
		user.setAge("18");
		user.setSex("女");
		
		String str1 = JSON.toJSONString(user);
		System.out.println(str1);
	}
}
