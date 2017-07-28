package org.study.demo.volatiles.demo2;

public class TestVolatile {
	public static void main(String [] args){
		User user = new User();
		user.setName("volatile");
		SetValueThread st = new SetValueThread(user);
		GetValueThread gt = new GetValueThread(user);
		new Thread(st).start();
		gt.start();
		
		
		System.out.println("end");
	}
}
