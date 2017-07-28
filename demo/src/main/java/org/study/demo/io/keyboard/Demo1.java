package org.study.demo.io.keyboard;

import java.io.IOException;

public class Demo1 {

	public static void main(String[] args) {
		try {
			System.out.print("Enter a char :");
			while(true){
				char val = (char)System.in.read();
				if(val == 13 || val == 10){
//					byte b = (byte)val;
//					System.out.println(b);
				}else{
					System.out.println("Your char is :" + val + "\r");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
