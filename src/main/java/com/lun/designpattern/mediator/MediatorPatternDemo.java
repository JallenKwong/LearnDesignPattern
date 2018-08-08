package com.lun.designpattern.mediator;

public class MediatorPatternDemo {

	public static void main(String[] args) {
		User robert = new User("Robert");
		User john = new User("John");

		robert.sendMessage("Hi! John!");
		john.sendMessage("Hello! Robert!");
	}

}
/*
Wed Aug 08 17:57:25 CST 2018 [Robert] : Hi! John!
Wed Aug 08 17:57:25 CST 2018 [John] : Hello! Robert!
*/