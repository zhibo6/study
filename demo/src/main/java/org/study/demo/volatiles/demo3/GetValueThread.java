package org.study.demo.volatiles.demo3;

public class GetValueThread extends Thread {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			long beginTime = System.currentTimeMillis();
			for (;;) {
				if (Door.open == !Door.open) {
					long endTime = System.currentTimeMillis();
					System.out.println(endTime - beginTime);
					System.exit(0);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
