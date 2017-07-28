package org.study.demo.volatiles.demo1;

public class SetValueThread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10000; i++){
			try {
				Thread.sleep(1000L);
				User.setName(i + "");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
