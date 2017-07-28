package org.study.demo.generic.demo2;

public class CalculatorString implements Calculator<String>{
	public String and(String a, String b){
		return a + b;
	}
	
	public static void main(String[] args) {
		CalculatorString ci = new CalculatorString();
		String val = ci.and("10", "20");
		System.out.println(val);
	}
}
