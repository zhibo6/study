package org.study.demo.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpDemo {

	public static void main(String[] args) {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
