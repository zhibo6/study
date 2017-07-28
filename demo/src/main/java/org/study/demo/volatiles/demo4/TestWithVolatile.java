package org.study.demo.volatiles.demo4;

public class TestWithVolatile {
	private static volatile boolean bChanged;

	public static void main(String[] args) throws InterruptedException {
		for(int i = 0; i < 100; i ++){
			new Thread() {

				@Override
				public void run() {
					long beginTime = System.currentTimeMillis();
					for (;;) {
						if (bChanged == !bChanged) {
							long endTime = System.currentTimeMillis();
							System.out.println(endTime - beginTime);
							System.exit(0);
						}
					}
				}
			}.start();
		}
		
		new Thread() {

			@Override
			public void run() {
				for (;;) {
					bChanged = !bChanged;
				}
			}
		}.start();
	}

}
