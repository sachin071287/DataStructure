package com.learning.programs;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * This can be break using
 * -- Reflection : making constructor visibility as public
 * -- Serialization : 
 * -- Cloning
 * @author kumars
 *
 */

public class TestSingleton {
	
	
	public static void main(String[] args) {
		//breakUsingReflection();
		breakUsingCloning();
	
	}

	private static void breakUsingReflection() {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = null;
		Constructor[] constructors = Singleton.class.getConstructors();
		for (Constructor constructor : constructors) {
			constructor.setAccessible(true);
			// obj2 = new Singleton();
			try {
				obj2 = (Singleton) constructor.newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		printObjectHashCode(obj1, obj2);

	}

	private static void breakUsingCloning() {
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = null;
		try {
			obj2 = (Singleton) obj1.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		printObjectHashCode(obj1, obj2);

	}
	private static void printObjectHashCode(Singleton obj1, Singleton obj2) {
		System.out.println("The firstObject is : " + obj1.hashCode());
		System.out.println("The SecondObject is : " + obj2.hashCode());
	}

	static class Singleton implements Cloneable, Serializable {

		private static Singleton myInstance ;

		/**
		 * private constructor
		 */
		private Singleton() {
		}

		public static Singleton getInstance() {
			if (myInstance == null) {
				synchronized (Singleton.class) {
					if (myInstance == null) {
						myInstance = new Singleton();
						return myInstance;

					}
				}
			}
			return myInstance;
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			//throw new CloneNotSupportedException();
			return myInstance;
		}

		protected Object readResolve() {
			return myInstance;
		}
	}
}