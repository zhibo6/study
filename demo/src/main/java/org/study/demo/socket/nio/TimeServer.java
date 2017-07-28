package org.study.demo.socket.nio;

public class TimeServer {
	public static void main(String [] args){
		try {
			//定义服务器访问端口
			int port = 8080;
			if(args != null && args.length > 0){
				port = Integer.valueOf(args[0]);
			}
			new Thread(new MultiPlexerTimeServerHandler(port), "NIO-MultiPlexerTimeServer-001").start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
		}
	}
}
