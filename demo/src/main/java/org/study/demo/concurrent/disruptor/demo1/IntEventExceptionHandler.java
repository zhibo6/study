package org.study.demo.concurrent.disruptor.demo1;

import com.lmax.disruptor.ExceptionHandler;

class IntEventExceptionHandler implements ExceptionHandler {
	public void handleEventException(Throwable ex, long sequence, Object event) {
	}

	public void handleOnStartException(Throwable ex) {
	}

	public void handleOnShutdownException(Throwable ex) {
	}
}