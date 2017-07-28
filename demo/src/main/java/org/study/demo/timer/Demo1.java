package org.study.demo.timer;

import java.util.Timer;

public class Demo1 {
	public static void main(String [] args){
		Timer timer = new Timer();
		timer.schedule(new CounterTask(), 1000L, 1000L);
	}
}
