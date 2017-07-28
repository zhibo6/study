package org.study.demo.socket.bio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerHandlerExecutePool {
	private ExecutorService executor = null;
	
	public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize){
//		Runtime.getRuntime().availableProcessors()
		executor = new ThreadPoolExecutor(1, 
				maxPoolSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
	}
	
	public void execute(Runnable task){
		executor.execute(task);
	}
	
	public void shutdown(){
		executor.shutdown();
	}
}
