package org.study.demo.socket.aio;

import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class AsyncTimeServerHandler implements Runnable {
	private int port;
	CountDownLatch countDownLatch;
	AsynchronousServerSocketChannel asynchronousServerSocketChannel;
	
	public AsyncTimeServerHandler(int port){
		try {
			Future<Object> future;
			FutureTask<Object> futureTask;
			ExecutorService es;
			Executors executors;
			this.port = port;
			this.asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
			this.asynchronousServerSocketChannel.bind(new InetSocketAddress(this.port));
			System.out.println("The time server is start in port : " + port);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		try {
			countDownLatch = new CountDownLatch(1);
			doAccept();
			countDownLatch.await();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doAccept(){
		this.asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());
	}

}
