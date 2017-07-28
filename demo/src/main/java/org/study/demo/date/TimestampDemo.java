package org.study.demo.date;

import java.text.SimpleDateFormat;

public class TimestampDemo {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(utilDate.getTime());

		System.out.println(sdf.format(sqlTimestamp));
		System.out.println("year:" + sqlTimestamp.getYear());
		System.out.println("month:" + sqlTimestamp.getMonth());
		System.out.println("date:" + sqlTimestamp.getDate());
		System.out.println("day:" + sqlTimestamp.getDay());
		System.out.println("hours:" + sqlTimestamp.getHours());
		System.out.println("minutes:" + sqlTimestamp.getMinutes());
		System.out.println("seconds:" + sqlTimestamp.getSeconds());
		System.out.println("nanos:" + sqlTimestamp.getNanos());
		System.out.println("time:" + utilDate.getTime());
	}
}
