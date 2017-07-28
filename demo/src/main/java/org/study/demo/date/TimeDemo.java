package org.study.demo.date;

import java.text.SimpleDateFormat;

public class TimeDemo {

	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
		java.util.Date utilDate = new java.util.Date();
		System.out.println(sdf.format(utilDate));
		
		java.sql.Time sqlTime = new java.sql.Time(utilDate.getTime());
		System.out.println(sqlTime);
		System.out.println(sdf.format(sqlTime));
		System.out.println(sqlTime.getDay());
	}

}
