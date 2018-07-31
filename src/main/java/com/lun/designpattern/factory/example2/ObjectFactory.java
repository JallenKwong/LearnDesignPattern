package com.lun.designpattern.factory.example2;

public class ObjectFactory {
	@SuppressWarnings("unchecked")
	public static <T> T getObject(Class<T> clazz) {
		if (clazz == null) {
			return null;
		}
		T obj = null;
		try {
			obj = (T)Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public static void main(String[] args) {
		String s = ObjectFactory.getObject(String.class);
	}
}