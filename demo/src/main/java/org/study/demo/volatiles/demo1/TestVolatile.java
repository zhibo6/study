package org.study.demo.volatiles.demo1;

public class TestVolatile {
	public static void main(String [] args){
		SetValueThread st = new SetValueThread();
		GetValueThread gt = new GetValueThread();
		new Thread(st).start();
		gt.start();
		
		
		System.out.println("end");
	}
}
