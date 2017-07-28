package org.study.demo.concurrent.disruptor.demo2;

import com.lmax.disruptor.EventFactory;

public class ValueEvent {
	private int value = -1;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String toString() {
		return String.valueOf(value);
	}

	public static EventFactory<ValueEvent> EVENT_FACTORY = new EventFactory<ValueEvent>() {
		public ValueEvent newInstance() {
			return new ValueEvent();
		}
	};
}
