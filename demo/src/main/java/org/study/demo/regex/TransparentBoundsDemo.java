package org.study.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TransparentBoundsDemo {

	public static void main(String[] args) {
		String regex = "\\bcar\\b";
		String text = "Madagascar is best seen by car or bike.";
		Matcher m = Pattern.compile(regex).matcher(text);
		m.region(7, text.length());
		m.useAnchoringBounds(false);
		m.useTransparentBounds(false);
		m.find();
		System.out.println("Matches starting at character " + m.start());
		m.reset();
		m.useTransparentBounds(true);
		m.find();
		System.out.println("Matches starting at character " + m.start());
	}

}
