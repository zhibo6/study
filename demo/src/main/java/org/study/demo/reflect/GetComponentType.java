package org.study.demo.reflect;

import java.lang.reflect.Array;

public class GetComponentType {
	public static void main(String[] args) {
		Class<char[]> aa = (Class<char[]>) char.class.getComponentType();
		System.out.println("the componentType of the char is :" + char.class.getComponentType());
		System.out.println("the componentType of the char[] is :" + char[].class.getComponentType());
		System.out.println("the componentType of the String is :" + String.class.getComponentType());
		System.out.println("the componentType of the String[] is :" + String[].class.getComponentType());
		System.out.println("the componentType of the int is :" + int.class.getComponentType());
		System.out.println("the componentType of the int[] is :" + int[].class.getComponentType());
		System.out.println("the componentType of the Integer is :" + Integer.class.getComponentType());
		System.out.println("the componentType of the Integer[] is :" + Integer[].class.getComponentType());

		try {
			char c = (char) Array.newInstance(char.class.getComponentType(), 10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		char[] charArray = (char[]) Array.newInstance(char[].class.getComponentType(), 100);
		System.out.println("the length of the charArray is :" + charArray.length);

		try {
			String c = (String) Array.newInstance(String.class.getComponentType(), 10);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String[] strArray = (String[]) Array.newInstance(String[].class.getComponentType(), 10);
		System.out.println("the length of the strArray is :" + strArray.length);

	}

	// 非基本类型
	public static <T, U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
		T[] copy = ((Object) newType == (Object) Object[].class) ? (T[]) new Object[newLength]
				: (T[]) Array.newInstance(newType.getComponentType(), newLength);
		System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
		return copy;
	}

	// 基本数据类型
	public static int[] copyOf(int[] original, int newLength) {
		int[] copy = new int[newLength];
		System.arraycopy(original, 0, copy, 0, Math.min(original.length, newLength));
		return copy;
	}

}
