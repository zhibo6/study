package org.study.demo.aop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogInvocationHandler implements InvocationHandler {

	private IWorker worker;
	
	public LogInvocationHandler(IWorker worker){
		this.worker = worker;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("LogInvocationHandler : begin invoking the method : " + method);
		method.invoke(worker, args);
		System.out.println("LogInvocationHandler : end invoking the method :" + method);
		return null;
	}

}
