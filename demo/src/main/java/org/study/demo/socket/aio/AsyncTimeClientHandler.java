package org.study.demo.socket.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements CompletionHandler<Void, AsyncTimeClientHandler>, Runnable {
	private AsynchronousSocketChannel asynchronousSocketChannel;
	private String host;
	private Integer port;
	private CountDownLatch countDownLatch;
	
	public AsyncTimeClientHandler(String host, Integer port){
		try {
			this.host = host;
			this.port = port;
			asynchronousSocketChannel = AsynchronousSocketChannel.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			countDownLatch = new CountDownLatch(1);
			asynchronousSocketChannel.connect(new InetSocketAddress(host, port), this, this);
			countDownLatch.await();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				asynchronousSocketChannel.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void completed(Void result, AsyncTimeClientHandler attachment) {
		byte [] bytes = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
		writeBuffer.put(bytes);
		writeBuffer.flip();
		asynchronousSocketChannel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {

			@Override
			public void completed(Integer result, ByteBuffer buffer) {
				if(buffer.hasRemaining()){
					asynchronousSocketChannel.write(buffer, buffer, this);
				} else {
					ByteBuffer readBuffer = ByteBuffer.allocate(1024);
					asynchronousSocketChannel.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {

						@Override
						public void completed(Integer result, ByteBuffer readBuffer) {
							try {
								readBuffer.flip();
								byte [] bytes = new byte[readBuffer.remaining()];
								readBuffer.get(bytes);
								String body = new String(bytes, "UTF-8");
								System.out.println("Now is :" + body);
							} catch (UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} finally {
								countDownLatch.countDown();
							}
						}

						@Override
						public void failed(Throwable exc, ByteBuffer attachment) {
							try {
								exc.printStackTrace();
								asynchronousSocketChannel.close();
								countDownLatch.countDown();
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					});
				}
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				try {
					exc.printStackTrace();
					asynchronousSocketChannel.close();
					countDownLatch.countDown();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
		try {
			exc.printStackTrace();
			asynchronousSocketChannel.close();
			countDownLatch.countDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
