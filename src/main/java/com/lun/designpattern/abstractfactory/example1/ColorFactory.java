package com.lun.designpattern.abstractfactory.example1;

import com.lun.designpattern.factory.example1.Shape;

public class ColorFactory extends AbstractFactory {
    
	   @Override
	   public Shape getShape(String shapeType){
	      return null;
	   }
	   
	   @Override
	   Color getColor(String color) {
	      if(color == null){
	         return null;
	      }        
	      if(color.equalsIgnoreCase("RED")){
	         return new Red();
	      } else if(color.equalsIgnoreCase("GREEN")){
	         return new Green();
	      } else if(color.equalsIgnoreCase("BLUE")){
	         return new Blue();
	      }
	      return null;
	   }
}