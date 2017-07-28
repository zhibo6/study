package org.study.demo.aop.javassist;

import java.net.URL;
import java.net.URLClassLoader;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class Main {

	public static void main(String[] args) {
		try {
	        ClassPool pool = ClassPool.getDefault();  
	        //创建Programmer类       
	        CtClass cc= pool.makeClass("com.samples.Programmer");  
	        //定义code方法  
	        CtMethod method = CtNewMethod.make("public void code(){}", cc);  
	        //插入方法代码  
	        method.insertBefore("System.out.println(\"I'm a Programmer,Just begin Coding.....\");");  
	        method.insertAfter("System.out.println(\"I'm a Programmer,Just end Coding.....\");");  
	        cc.addMethod(method);  
	        //保存生成的字节码  
	        cc.writeFile("D:/temp/");  
	        
//	        ClassLoader classLoader = Main.class.getClassLoader();
	        URL[] urls = new URL [] {new URL("file:/" + "D:/temp/")};
	        ClassLoader classLoader = new URLClassLoader(urls);
//	        Class clazz = cc.toClass();
	        Class clazz = classLoader.loadClass("com.samples.Programmer");
	        System.out.println(clazz.getCanonicalName());
	        Object programmer = clazz.newInstance();
	        
	        clazz.getMethod("code", null).invoke(programmer, null);
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
