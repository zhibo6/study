package org.study.demo.generic.demo2;

public class CalculatorInteger implements Calculator<Integer>{
	public Integer and(Integer a, Integer b){
		return a + b;
	}
	
	public static void main(String[] args) {
		CalculatorInteger ci = new CalculatorInteger();
		Integer val = ci.and(10, 20);
		System.out.println(val);
	}
}
