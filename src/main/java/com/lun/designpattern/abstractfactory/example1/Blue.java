package com.lun.designpattern.abstractfactory.example1;

public class Blue implements Color {
	
	   @Override
	   public void fill() {
	      System.out.println("Inside Blue::fill() method.");
	   }
}