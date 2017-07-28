package org.study.demo.aop.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class LogInterceptor implements MethodInterceptor {

	@Override
	public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("LogInterceptor : begin invoking the method : " + method);
		//注意：这里调用的是invokeSuper()
		Object ret = proxy.invokeSuper(target, args);
		System.out.println("LogInterceptor : end invoking the method :" + method);
		return ret;
	}

}
