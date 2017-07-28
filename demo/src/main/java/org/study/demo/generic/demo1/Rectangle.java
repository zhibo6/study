package org.study.demo.generic.demo1;

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
	
	public void showDetails(){
		System.out.println("the rectangle, width is " + this.width + " height is " + this.height);
	}
	
	public static void main(String [] args){
		Integer width = 10;
		Integer	height = 5;
		Rectangle<Integer> rect = new Rectangle<Integer>(width, height);
		width = rect.getWidth();
		height = rect.getHeight();
		rect.showDetails();

		String widthStr = "20";
		String	heightStr = "40";
		Rectangle<String> rect1 = new Rectangle<String>(widthStr, heightStr);
		widthStr = rect1.getWidth();
		heightStr = rect1.getHeight();
		rect1.showDetails();
	}
}
