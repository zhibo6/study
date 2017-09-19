package org.study.demo.csdn;

import java.util.Timer;

public class CSDNMain {
	public static void main(String [] args){
		Timer timer = new Timer();
		timer.schedule(new RequestTask(), 1000L, 15000L);
	}
}
