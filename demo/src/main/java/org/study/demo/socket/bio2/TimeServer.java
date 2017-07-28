package org.study.demo.socket.bio2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
	public static void main(String [] args){
		ServerSocket serverSocket = null;
		TimeServerHandlerExecutePool executor = null;
		try {
			//定义服务器访问端口
			int port = 8080;
			if(args != null && args.length > 0){
				port = Integer.valueOf(args[0]);
			}
			
			serverSocket = new ServerSocket(port);
			System.out.println("the time server is start in port：" + port);
			Socket socket = null;
			executor = new TimeServerHandlerExecutePool(2, 2);
			while(true){
				socket = serverSocket.accept();
				try {
					executor.execute(new TimeServerHandler(socket));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				serverSocket = null;
			}
			
			try {
				if(executor != null){
					executor.shutdown();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				executor = null;
			}
				
		}
	}
}
