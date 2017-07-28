package org.study.demo.socket.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ReadCompletionHandler implements CompletionHandler<Integer, ByteBuffer> {
	private AsynchronousSocketChannel asynchronousSocketChannel;
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	
	public ReadCompletionHandler(AsynchronousSocketChannel asynchronousSocketChannel){
		if(this.asynchronousSocketChannel == null){
			this.asynchronousSocketChannel = asynchronousSocketChannel;
		}
	}
	@Override
	public void completed(Integer result, ByteBuffer attachment) {
		try {
			attachment.flip();
			byte [] body = new byte[attachment.remaining()];
			attachment.get(body);
			String request = new String(body, "UTF-8");
			System.out.println("The time server receive order : " + request);
			
			String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(request) ? sdf.format(Calendar.getInstance().getTime()) : "BAD ORDER";
			doWrite(currentTime);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void doWrite(String response) throws Exception{
		if(response != null && response.trim().length() > 0){
			byte [] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			this.asynchronousSocketChannel.write(writeBuffer, writeBuffer, new CompletionHandler<Integer, ByteBuffer>() {

				@Override
				public void completed(Integer result, ByteBuffer buffer) {
					// TODO Auto-generated method stub
					if(buffer.hasRemaining()){
						asynchronousSocketChannel.write(buffer, buffer, this);
					}
				}

				@Override
				public void failed(Throwable exc, ByteBuffer attachment) {
					try {
						exc.printStackTrace();
						asynchronousSocketChannel.close();
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
			this.asynchronousSocketChannel.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
