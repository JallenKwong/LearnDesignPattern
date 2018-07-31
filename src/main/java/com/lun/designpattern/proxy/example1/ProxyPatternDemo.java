package com.lun.designpattern.proxy.example1;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		Image image = new ProxyImage("18stop.jpg");

		image.display();
	}
}
