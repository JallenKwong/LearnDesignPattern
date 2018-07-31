package com.lun.designpattern.abstractfactory.example1;

public class Green implements Color {
	
	   @Override
	   public void fill() {
	      System.out.println("Inside Green::fill() method.");
	   }
}