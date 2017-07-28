package org.study.demo.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {
	public static void main(String [] args){
		InvocationHandler handler = new LogInvocationHandler(new Worker());
		IWorker worker = (IWorker)Proxy.newProxyInstance(Worker.class.getClassLoader(), Worker.class.getInterfaces(), handler);
		worker.doWork();
	}
}
