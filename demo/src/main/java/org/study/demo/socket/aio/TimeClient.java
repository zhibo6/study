package org.study.demo.socket.aio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TimeClient {

	public static void main(String [] args){
		Socket socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		Scanner scanner = null;
		try {
			//定义服务器访问端口
			String host = "127.0.0.1";
			int port = 8080;
			if(args != null && args.length > 0){
				port = Integer.valueOf(args[0]);
			}
			
			new Thread(new AsyncTimeClientHandler(host, port)).start();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			if(scanner != null){
				try {
					scanner.close();
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					scanner = null;
				}
			}
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					in = null;
				}
			}
			
			if(out != null){
				try {
					out.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					out = null;
				}
			}
			
			if(socket != null){
				try {
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				socket = null;
			}
		}
	}

}
