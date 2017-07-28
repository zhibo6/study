package org.study.demo.io.keyboard;

import java.util.Scanner;

public class Demo3 {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
	         sc = new Scanner(System.in); 
	         System.out.println("请输入您的姓名："); 
	         String name = sc.nextLine(); 
	         System.out.println("请输入您的年龄："); 
	         int age = sc.nextInt(); 
	         System.out.println("请输入您的体重（kg）："); 
	         float salary = sc.nextFloat(); 
	         System.out.println("您的个人信息如下："); 
	         System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"体重："+salary); 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sc != null){
				sc.close();
				sc = null;
			}
		}
	}
}
