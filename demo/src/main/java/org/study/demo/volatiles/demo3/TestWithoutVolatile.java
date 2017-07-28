package org.study.demo.volatiles.demo3;

public class TestWithoutVolatile {
	public static void main(String [] args){
		try {
			SetValueThread st = new SetValueThread();
			new Thread(st).start();
			
			for(int i = 0; i < 100; i ++){
				GetValueThread gt = new GetValueThread();
				gt.start();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
