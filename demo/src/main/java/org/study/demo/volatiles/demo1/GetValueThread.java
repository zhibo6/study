package org.study.demo.volatiles.demo1;

public class GetValueThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10000; i++){
			try {
				Thread.sleep(1000L);
				System.out.println(User.getName());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
