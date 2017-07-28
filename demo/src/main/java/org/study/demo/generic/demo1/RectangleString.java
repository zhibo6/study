package org.study.demo.generic.demo1;

public class RectangleString {
	private String width;
	private String height;
	
	public RectangleString(String width, String height){
		this.width = width;
		this.height = height;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}
	
	public void showDetails(){
		System.out.println("the rectangle, width is " + this.width + " height is " + this.height);
	}
	
	public static void main(String [] args){
		String width = "20";
		String	height = "40";
		RectangleString rect = new RectangleString(width, height);
		width = rect.getWidth();
		height = rect.getHeight();
		rect.showDetails();
	}
}
