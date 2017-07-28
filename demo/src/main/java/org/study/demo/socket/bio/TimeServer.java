package org.study.demo.socket.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
	public static void main(String [] args){
		ServerSocket serverSocket = null;
		try {
			//定义服务器访问端口
			int port = 8080;
			if(args != null && args.length > 0){
				port = Integer.valueOf(args[0]);
			}
			
			serverSocket = new ServerSocket(port);
			System.out.println("the time server is start in port：" + port);
			Socket socket = null;
			while(true){
				socket = serverSocket.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(serverSocket != null) {
					serverSocket.close();
					serverSocket = null;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
