package org.study.demo.io.keyboard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo2 {
	public static void main(String[] args) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.print("Enter a String :");
				String val = bufferedReader.readLine();
				System.out.println("Your String is :" + val + "\r");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(bufferedReader != null){
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				bufferedReader = null;
			}
		}
	}
}
