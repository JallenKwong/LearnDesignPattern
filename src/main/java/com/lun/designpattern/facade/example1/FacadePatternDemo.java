package com.lun.designpattern.facade.example1;

public class FacadePatternDemo {
	public static void main(String[] args) {
		ShapeMaker shapeMaker = new ShapeMaker();

		
		shapeMaker.drawCircle();
		shapeMaker.drawRectangle();
		shapeMaker.drawSquare();
	}
}

/*
Inside Circle::draw() method.
Inside Rectangle::draw() method.
Inside Square::draw() method.
*/
