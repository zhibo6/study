package org.study.demo.concurrent.forkjoin;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * <p>Title: CountingTask</p>
 * <p>Description: 统计指定目录（含子目录）的文件数量</p>
 * @author	liuzhibo
 * @date	2016年8月17日
 */
public class CountingTask extends RecursiveTask<Integer> {
	private Path dir;

	public CountingTask(Path dir) {
		this.dir = dir;
	}

	@Override
	protected Integer compute() {
		int count = 0;
		List<CountingTask> subTasks = new ArrayList<>();

		// Opens a directory, returning a DirectoryStream to iterate over all entries in the directory. 
		// 打开目录，返回一个DirectoryStream对象，用来遍历这个目录下的所有实体。
		try (DirectoryStream<Path> ds = Files.newDirectoryStream(dir)) {
			for (Path subPath : ds) {
				if (Files.isDirectory(subPath, LinkOption.NOFOLLOW_LINKS)) {
					// 对每个子目录都新建一个子任务。
					subTasks.add(new CountingTask(subPath));
				} else {
					// 遇到文件，则计数器增加 1。
					count++;
				}
			}

			if (!subTasks.isEmpty()) {
				// 在当前的 ForkJoinPool 上调度所有的子任务。
				for (CountingTask subTask : invokeAll(subTasks)) {
					count += subTask.join();
				}
			}
		} catch (IOException ex) {
			return 0;
		}
		return count;
	}
	
	public static void main(String [] args){
		try {
			// 用一个 ForkJoinPool 实例调度“总任务”
			System.out.println("task start");
			
			ForkJoinPool pool = new ForkJoinPool();
			CountingTask task = new CountingTask(Paths.get("D:/"));
			Integer count = 0;
//			count = pool.invoke(task);
//			System.out.println("文件数量：" + count);
			
			Future<Integer> result = pool.submit(task);
			count = result.get();
			System.out.println("文件数量：" + count);
			
			System.out.println("task end");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}