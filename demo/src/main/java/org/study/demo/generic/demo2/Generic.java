package org.study.demo.generic.demo2;

public class Generic {
	public <T> T getObject(Class<T> c){
		T t = null;
		try {
			t = c.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public static void main(String [] args){
		try {
			Generic generic = new Generic();
			Object obj = generic.getObject(Class.forName("com.ips.volatiles.demo2.Generic"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
