package com.lun.designpattern.proxy.example2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.lun.designpattern.proxy.example1.Image;
import com.lun.designpattern.proxy.example1.RealImage;

public class TimerHandler implements InvocationHandler {

	private Object target;
	
	public TimerHandler(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		long begin = System.currentTimeMillis();
		
		Object obj = method.invoke(target, args);
		
		long end = System.currentTimeMillis();
		System.out.println("It's spent " + (end - begin)+ "ms");
		
		return obj;
	}
	
	public static void main(String[] args) {
		RealImage image = new RealImage("18stop.jpg");
		
		TimerHandler timer = new TimerHandler(image);
		
		Image proxyImage = (Image)Proxy.newProxyInstance(
				image.getClass().getClassLoader(), 
				image.getClass().getInterfaces(), 
				timer);
		
		proxyImage.display();
		
	}

}
