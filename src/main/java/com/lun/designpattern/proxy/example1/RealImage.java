package com.lun.designpattern.proxy.example1;

public class RealImage implements Image {

	private String fileName;

	public RealImage(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void display() {
		System.out.println("Displaying " + fileName);
		
		try {
			Thread.sleep(666);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
