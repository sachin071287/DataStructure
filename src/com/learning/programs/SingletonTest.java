package com.dp;

public class SingletonTest {

	private static SingletonTest singletonInstance;

	private SingletonTest() {

	}

	public static SingletonTest getInstance() {

		if (singletonInstance == null) {
			singletonInstance = new SingletonTest();
		}
		return singletonInstance;
	}

}
