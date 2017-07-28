package org.study.demo.volatiles.demo2;

public class SetValueThread implements Runnable {
	private User user = null;
	public SetValueThread(User user){
		this.user = user;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 10000; i++){
			try {
				Thread.sleep(1000L);
				user.setName(i + "");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
