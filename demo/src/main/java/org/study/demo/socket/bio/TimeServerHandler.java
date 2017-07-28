package org.study.demo.socket.bio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeServerHandler implements Runnable {
	private final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
	private Socket socket;
	
	public TimeServerHandler(Socket socket){
		this.socket = socket;
	}
	@Override
	public void run() {
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			out = new PrintWriter(this.socket.getOutputStream(), true);
			
			String currentTime = null;
			String body = null;
			while(true){
				body = in.readLine();
				if(body == null || body.length() == 0){
					break;
				}
				System.out.println("The time server receive order :" + body);
				
				
				currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? sdf.format(Calendar.getInstance().getTime()) : "BAD ORDER";
				out.println(currentTime);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
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
			
			if(this.socket != null){
				try {
					this.socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					this.socket = null;
				}
			}
		}
	}

}
