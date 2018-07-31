package com.lun.designpattern.abstractfactory.example1;

import com.lun.designpattern.factory.example1.Shape;

public abstract class AbstractFactory {
	   abstract Color getColor(String color);
	   abstract Shape getShape(String shape);
}
