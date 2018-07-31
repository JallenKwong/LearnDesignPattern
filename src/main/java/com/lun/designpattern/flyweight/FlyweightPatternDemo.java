package com.lun.designpattern.flyweight;

public class FlyweightPatternDemo {
	private static final String colors[] = { "Red", "Green", "Blue", "White", "Black" };

	public static void main(String[] args) {

		for (int i = 0; i < 20; ++i) {
			Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
			circle.setX(getRandomX());
			circle.setY(getRandomY());
			circle.setRadius(100);
			circle.draw();
		}
	}

	private static String getRandomColor() {
		return colors[(int) (Math.random() * colors.length)];
	}

	private static int getRandomX() {
		return (int) (Math.random() * 100);
	}

	private static int getRandomY() {
		return (int) (Math.random() * 100);
	}
}

/*
Creating circle of color : Red
Circle: Draw() [Color : Red, x : 98, y :78, radius :100
Creating circle of color : Blue
Circle: Draw() [Color : Blue, x : 43, y :84, radius :100
Creating circle of color : Black
Circle: Draw() [Color : Black, x : 2, y :98, radius :100
Creating circle of color : White
Circle: Draw() [Color : White, x : 52, y :53, radius :100
Circle: Draw() [Color : Black, x : 94, y :54, radius :100
Circle: Draw() [Color : Blue, x : 39, y :74, radius :100
Circle: Draw() [Color : Blue, x : 8, y :61, radius :100
Circle: Draw() [Color : White, x : 42, y :71, radius :100
Circle: Draw() [Color : Red, x : 33, y :1, radius :100
Creating circle of color : Green
Circle: Draw() [Color : Green, x : 69, y :73, radius :100
Circle: Draw() [Color : Black, x : 56, y :77, radius :100
Circle: Draw() [Color : Red, x : 95, y :68, radius :100
Circle: Draw() [Color : Blue, x : 9, y :2, radius :100
Circle: Draw() [Color : Black, x : 77, y :41, radius :100
Circle: Draw() [Color : Blue, x : 46, y :87, radius :100
Circle: Draw() [Color : Black, x : 77, y :39, radius :100
Circle: Draw() [Color : Red, x : 9, y :75, radius :100
Circle: Draw() [Color : Green, x : 81, y :74, radius :100
Circle: Draw() [Color : White, x : 35, y :0, radius :100
Circle: Draw() [Color : Blue, x : 59, y :70, radius :100
 */