package org.study.demo.timer;

import java.util.TimerTask;

public class CounterTask extends TimerTask {
	private int i = 0;
	@Override
	public void run() {
		i ++;
		System.out.println(i);
	}

}
