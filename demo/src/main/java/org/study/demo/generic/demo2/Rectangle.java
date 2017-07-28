package org.study.demo.generic.demo2;

public class Rectangle<T> {
	private T width;
	private T height;
	
	public Rectangle(T width, T height){
		this.width = width;
		this.height = height;
	}

	public T getWidth() {
		return width;
	}

	public void setWidth(T width) {
		this.width = width;
	}

	public T getHeight() {
		return height;
	}

	public void setHeight(T height) {
		this.height = height;
	}
	
	public static void main(String [] args){
		Integer width = 10;
		Integer	height = 5;
		Rectangle<Integer> rect = new Rectangle<Integer>(width, height);

		String widthStr = "20";
		String	heightStr = "40";
		Rectangle<String> rect1 = new Rectangle<String>(widthStr, heightStr);
	}
}
