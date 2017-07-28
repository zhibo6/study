package org.study.demo.aop.proxy;

public class Worker implements IWorker{

	@Override
	public void doWork() {
		System.out.println("I am working !");
	}

}
