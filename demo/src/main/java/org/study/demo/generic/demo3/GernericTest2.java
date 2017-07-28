package org.study.demo.generic.demo3;

import java.util.ArrayList;
import java.util.List;

public class GernericTest2 {
	public static void main(String [] args){
		List<? extends Number> eList = null;
		eList = new ArrayList<Integer>();
		eList = new ArrayList<Long>();
		eList = new ArrayList<Float>();
		Number numObject = eList.get(0);
//		Integer intObject = eList.get(0);  //Type mismatch: cannot convert from capture#3-of ? extends Number to Integer
//		eList.add(new Integer(1));  //The method add(capture#3-of ? extends Number) in the type List<capture#3-of ? extends Number> is not applicable for the arguments (Integer)
//		
//		List<? super Integer> sList = null;
//		sList = new ArrayList<Number>();
//		Number numObj = sList.get(0);  //Type mismatch: cannot convert from capture#5-of ? super Integer to Number
//		Integer intObj = sList.get(0); //Type mismatch: cannot convert from capture#6-of ? super Integer to Integer
//		sList.add(new Integer(1));
		
	}
}
