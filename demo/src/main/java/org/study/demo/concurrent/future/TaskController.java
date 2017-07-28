package org.study.demo.concurrent.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * <p>
 * Title: TaskController
 * </p>
 * <p>
 * Description: 异步计算的控制线程（controller）：负责异步计算任务的分解和发起，把分解好的任务交给异步计算的worker线程去执行，发起异步计算后，
 * controller可以获得Futrue的集合，将集合数据传递给collector，collector根据Future的状态来处理异步计算的结果。
 * </p>
 * 
 * @author liuzhibo
 * @date 2016年7月29日
 */
public class TaskController {
	ExecutorService executor = null;
	List<Future<Integer>> list = null;

	public TaskController() {
		executor = Executors.newFixedThreadPool(100);
		list = new ArrayList<Future<Integer>>();
	}

	public void work() {
		System.out.println("Start processing : ");
		TaskWorker task = null;
		Future<Integer> future = null;
		for (int i = 0; i < 100; i++) {
			task = new TaskWorker();
			future = this.executor.submit(task);
			list.add(future);
		}

		/**
		 * 当线程池调用该方法时,线程池的状态则立刻变成SHUTDOWN状态,以后不能再往线程池中添加任何任务，
		 * 否则将会抛出RejectedExecutionException异常。但是，此时线程池不会立刻退出，直到添加到线程池中的任务都已经处理完成
		 * ，才会退出。 与它相似的还有一个shutdownNow()，它通过调用Thread.interrupt来实现线程的立即退出。
		 **/
		this.executor.shutdown();
		System.out.println("Finish processing. ");
	}

	public void collect() {
		TaskCollector<Integer> task = new TaskCollector<Integer>(list);
		Thread thread = new Thread(task);
		thread.start();
	}

	public static void main(String[] args) {
		// 定义异步计算的控制对象
		TaskController controller = new TaskController();
		// 启动异步计算任务
		controller.work();
		// 对异步计算结果进行收集
		controller.collect();
	}
}
