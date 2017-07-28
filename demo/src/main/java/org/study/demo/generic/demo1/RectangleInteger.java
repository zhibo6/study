package org.study.demo.generic.demo1;

public class RectangleInteger {
	private Integer width;
	private Integer height;
	
	public RectangleInteger(Integer width, Integer height){
		this.width = width;
		this.height = height;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
	
	public void showDetails(){
		System.out.println("the rectangle, width is " + this.width + " height is " + this.height);
	}
	
	public static void main(String [] args){
		Integer width = 10;
		Integer	height = 5;
		RectangleInteger rect = new RectangleInteger(width, height);
		width = rect.getWidth();
		height = rect.getHeight();
		rect.showDetails();
	}
}
