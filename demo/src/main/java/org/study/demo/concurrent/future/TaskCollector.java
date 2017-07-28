package org.study.demo.concurrent.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * <p>
 * Title: CollectTask
 * </p>
 * <p>
 * Description: 异步计算结果收集线程（collector），从发起线程那里获得Future的集合，并负责监控Future的状态，
 * 根据Future的状态来处理异步计算的结果。
 * </p>
 * 
 * @author liuzhibo
 * @date 2016年7月29日
 */
public class TaskCollector<T> implements Runnable {
	private List<Future<T>> list = new ArrayList<Future<T>>();

	public TaskCollector(List<Future<T>> list) {
		this.list = list;
	}

	@Override
	public void run() {
		System.out.println("Start collecting : ");
		//由于Future的计算结果并不是按照list中的顺序进行返回的，以下代码存在性能问题，因此此处可以进行优化
		for (Future<T> future : list) {
			try {
				while (true) {
					if (future.isDone() && !future.isCancelled()) {
						System.out.println("Future : " + future + ", Result : " + future.get());
						break;
					} else {
						Thread.sleep(1000);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("Finish collecting.");
	}

}
