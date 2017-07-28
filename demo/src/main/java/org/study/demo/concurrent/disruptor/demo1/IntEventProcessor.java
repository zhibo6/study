package org.study.demo.concurrent.disruptor.demo1;

import com.lmax.disruptor.WorkHandler;

public class IntEventProcessor implements WorkHandler<IntEvent> {

	public void onEvent(IntEvent event) throws Exception {
		System.out.println(event.getValue());
		event.setValue(1);
	}

}