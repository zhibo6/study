package org.study.demo.concurrent.future;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * <p>Title: ProcessTask</p>
 * <p>Description: 异步计算线程（worker），负责具体的计算任务</p>
 * @author	liuzhibo
 * @date	2016年7月29日
 */
public class TaskWorker implements Callable<Integer>{
	final Random random = new Random();  
	
	@Override
	public Integer call() throws Exception {
		 int randomInt = random.nextInt(10);  
         Thread.sleep(randomInt * 1000);  
         return randomInt; 
	}

}
