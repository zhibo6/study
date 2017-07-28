package org.study.demo.aop.cglib;

import org.study.demo.aop.proxy.IWorker;
import org.study.demo.aop.proxy.Worker;

import net.sf.cglib.proxy.Enhancer;

public class Main {

	public static void main(String[] args) {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(Worker.class);
		enhancer.setCallback(new LogInterceptor());
		IWorker worker = (IWorker)enhancer.create();
		worker.doWork();
	}

}
