package org.study.demo.volatiles.demo5;

public class TestWithVolatile {
	public static void main(String [] args){
		try {
			for(int i = 0; i < 100; i ++){
				GetValueThread gt = new GetValueThread();
				gt.start();
			}

			SetValueThread st = new SetValueThread();
			new Thread(st).start();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
