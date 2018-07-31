package com.lun.designpattern.flyweight;

import java.util.HashMap;

import com.lun.designpattern.factory.example1.Shape;

/**
 * 就是用HashMap作为缓存
 * @author JK
 *
 */
public class ShapeFactory {
	   private static final HashMap<String, Shape> circleMap = new HashMap<>();

	   public static Shape getCircle(String color) {
	      Circle circle = (Circle)circleMap.get(color);

	      if(circle == null) {
	         circle = new Circle(color);
	         circleMap.put(color, circle);
	         System.out.println("Creating circle of color : " + color);
	      }
	      return circle;
	   }
}
