package org.study.demo.classloader;

public class Coordinate {
	public static int x;
	public static int y = 1;

	private static Coordinate obj = new Coordinate();
	
	private Coordinate() {
		x++;
		y++;
	}

	public static Coordinate getInstance() {
		return obj;
	}

	public static void main(String[] args) {
		Coordinate.getInstance();
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println(System.currentTimeMillis());
	}
}
