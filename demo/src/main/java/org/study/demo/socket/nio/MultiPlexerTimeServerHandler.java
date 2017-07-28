package org.study.demo.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

public class MultiPlexerTimeServerHandler implements Runnable{
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	private Selector selector = null;
	private ServerSocketChannel serverSocketChannel = null;
	private volatile boolean stop = false;
	
	public MultiPlexerTimeServerHandler(int port){
		try {
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(port));
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			System.out.println("The time server is start in port :" + port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop(){
		this.stop = true;
	}
	public void run(){
		try {
			while(!stop){
				selector.select(1000);
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iter = selectedKeys.iterator();
				SelectionKey key = null;
				while(iter.hasNext()){
					key = iter.next();
					iter.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
//						e.printStackTrace();
						if(key != null){
							key.cancel();
							if(key.channel() != null){
								key.channel().close();
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(selector != null){
				try {
					selector.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					selector = null;
				}
			}
		}
	}
	
	private void handleInput(SelectionKey key) throws Exception{
		if(key.isValid()){
			if(key.isAcceptable()) {
				ServerSocketChannel ssc = (ServerSocketChannel)key.channel();
				SocketChannel sc = ssc.accept();
				sc.configureBlocking(false);
				sc.register(selector, SelectionKey.OP_READ);
			}
		
			if(key.isReadable()){
				SocketChannel sc = (SocketChannel)key.channel();
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if(readBytes > 0){
					readBuffer.flip();
					byte[] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("The time server receive order :" + body);
					String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? sdf.format(Calendar.getInstance().getTime()) : "BAD ORDER";
					doWrite(sc, currentTime);
				} else if(readBytes < 0){
					key.cancel();
					sc.close();
				} else {
					//读取到0字节，忽略
				}
			}
		}
	}
	
	private void doWrite(SocketChannel sc, String response) throws Exception{
		if(response != null && response.length() > 0){
			byte [] bytes = response.getBytes();
			ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
			writeBuffer.put(bytes);
			writeBuffer.flip();
			sc.write(writeBuffer);
		}
	}
}
