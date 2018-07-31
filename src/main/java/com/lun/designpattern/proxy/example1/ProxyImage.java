package com.lun.designpattern.proxy.example1;

public class ProxyImage implements Image {

	private RealImage realImage;
	private String fileName;

	public ProxyImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		
		long begin = System.currentTimeMillis();
		
		if (realImage == null) {
			realImage = new RealImage(fileName);
		}
		
		realImage.display();
		
		long end = System.currentTimeMillis();
		
		System.out.println("It's spent " + (end - begin)+ "ms");
		
	}
}
