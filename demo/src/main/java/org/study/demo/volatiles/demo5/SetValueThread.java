package org.study.demo.volatiles.demo5;

public class SetValueThread implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for( ; ; ){
			try {
				Door.open = !Door.open;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
