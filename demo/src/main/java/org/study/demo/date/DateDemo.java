package org.study.demo.date;

public class DateDemo {

	public static void main(String[] args) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
//		java.util.Date utilDate = new java.util.Date();
//		System.out.println(sdf.format(utilDate));
//		System.out.println("year:" + utilDate.getYear());
//		System.out.println("month:" + utilDate.getMonth());
//		System.out.println("date:" + utilDate.getDate());
//		System.out.println("day:" + utilDate.getDay());
//		System.out.println("hours:" + utilDate.getHours());
//		System.out.println("minutes:" + utilDate.getMinutes());
//		System.out.println("seconds:" + utilDate.getSeconds());
//		System.out.println("time:" + utilDate.getTime());
		
		
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		java.sql.Time time = new java.sql.Time(new java.util.Date().getTime());
		java.util.Date utilDate = new java.util.Date(date.getTime() + time.getTime());
		System.out.println("date:" + date.getTime());
		System.out.println("time:" + time.getTime());
		System.out.println("utilDate:" + utilDate);
	}
}
