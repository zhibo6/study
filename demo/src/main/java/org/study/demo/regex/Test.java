package org.study.demo.regex;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		System.out.println(Matcher.quoteReplacement(File.separator));
		
		String regex1 = "(\\d{3}?)-(\\d{8}?)";
		String regex2 = "-";
//		String content = "0349-3062462";
		String content = "010-51527699010-51527699010-51527699";
		Pattern pattern = Pattern.compile(regex1);
		/*
		 * pattern.matcher
		 */
		Matcher matcher = pattern.matcher(content);
		while(matcher.find()){
			System.out.println(matcher.start());
			System.out.println(matcher.end());
			System.out.println(matcher.group());
			System.out.println(matcher.group(1));
			System.out.println(matcher.group(2));
			System.out.println("##" + matcher.hitEnd());
		}
		
		/*
		 * pattern.split
		 */
		pattern = Pattern.compile(regex2, Pattern.CASE_INSENSITIVE | Pattern.UNIX_LINES | Pattern.COMMENTS);
		
		String [] arr = pattern.split(content);
		for(String item : arr){
			System.out.println(item);
		}
		
		System.out.println(pattern.flags());
		
		String text = Pattern.quote(".*");
		System.out.println(text);
	}

}
