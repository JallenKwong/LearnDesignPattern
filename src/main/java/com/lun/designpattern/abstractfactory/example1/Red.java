package com.lun.designpattern.abstractfactory.example1;

public class Red implements Color {
	
	   @Override
	   public void fill() {
	      System.out.println("Inside Red::fill() method.");
	   }
}
