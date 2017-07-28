package org.study.demo.concurrent.disruptor.demo1;

import com.lmax.disruptor.WorkHandler;

/**
 * <p>Title: IntEventProducer</p>
 * <p>Description: 生产者</p>
 * @author	liuzhibo
 * @date	2016年8月19日
 */
public class IntEventProducer implements WorkHandler<IntEvent> {

	private int seq = 0;

	public void onEvent(IntEvent event) throws Exception {
		System.out.println("produced " + seq);
		event.setValue(++seq);
	}

}