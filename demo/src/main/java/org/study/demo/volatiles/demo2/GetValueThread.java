package org.study.demo.volatiles.demo2;

public class GetValueThread extends Thread {
	private User user = null;
	public GetValueThread(User user){
		this.user = user;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10000; i++){
			try {
				Thread.sleep(1000L);
				System.out.println(user.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
