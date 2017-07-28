package org.study.demo.generic.demo3;

import java.util.ArrayList;
import java.util.List;

public class GernericTest {
	public static void main(String [] args){
		List<? extends Number> eList = null;
		eList = new ArrayList<Integer>();
		eList = new ArrayList<Long>();
		
		List<? super Integer> sList = null;
		sList = new ArrayList<Integer>();
		sList = new ArrayList<Number>();
	}
}
