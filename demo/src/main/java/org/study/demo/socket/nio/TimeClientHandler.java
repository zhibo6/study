package org.study.demo.socket.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class TimeClientHandler implements Runnable{
	private String host;
	private int port;
	private Selector selector;
	private SocketChannel sc;
	private volatile boolean stop = false;
	
	public TimeClientHandler(String host, int port){
		this.host = host != null ? host : "127.0.0.1";
		this.port = port;
		try {
			selector = Selector.open();
			sc = SocketChannel.open();
			sc.configureBlocking(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		
	}
	public void run(){
		try {
			doConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(1);
		}
		while(!stop){
			try {
				selector.select(1000L);
				Set<SelectionKey> selectedKes = selector.selectedKeys();
				Iterator<SelectionKey> iter = selectedKes.iterator();
				SelectionKey key = null;
				while(iter.hasNext()){
					key = iter.next();
					iter.remove();
					try {
						handleInput(key);
					} catch (Exception e) {
						e.printStackTrace();
						
						if(key != null){
							key.cancel();
							if(key.channel() != null){
								key.channel().close();
							}
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(1);
			}
		}
		
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
	
	private void handleInput(SelectionKey key) throws IOException{
		if(key.isValid()){
			SocketChannel sc = (SocketChannel)key.channel();
			if(key.isConnectable()){
				if(sc.finishConnect()){
					sc.register(selector, SelectionKey.OP_READ);
					doWrite(sc);
				}else{
					System.exit(1);
				}
			}
			if(key.isReadable()){
				ByteBuffer readBuffer = ByteBuffer.allocate(1024);
				int readBytes = sc.read(readBuffer);
				if(readBytes > 0){
					readBuffer.flip();
					byte [] bytes = new byte[readBuffer.remaining()];
					readBuffer.get(bytes);
					String body = new String(bytes, "UTF-8");
					System.out.println("Now is :" + body);
//					this.stop = true;
					doWrite(sc);
				} else if(readBytes < 0){
					//对端链路关闭
					key.cancel();
					sc.close();
				} else {
					//读到0字节，忽略
				}
			}
		}
	}
	
	private void doConnect() throws IOException{
		if(sc.connect(new InetSocketAddress(host, port))){
			sc.register(selector, SelectionKey.OP_READ);
			doWrite(sc);
		} else {
			sc.register(selector, SelectionKey.OP_CONNECT);
		}
	}
	
	private void doWrite(SocketChannel sc) throws IOException{
		byte [] bytes = "QUERY TIME ORDER".getBytes();
		ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
		writeBuffer.put(bytes);
		writeBuffer.flip();
		sc.write(writeBuffer);
		if(!writeBuffer.hasRemaining()){
			System.out.println("Send order to server secceed.");
		}
	}
}
