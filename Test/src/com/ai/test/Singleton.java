package com.ai.test;

public class Singleton {
	
	private static Singleton singleton = null;
	
	public static Singleton getInstance() {
		
		if (singleton == null) {
			synchronized (Singleton.class) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		
		return singleton;
		
	}
	
	public static void main(String[] args) {
//		A a = new A();
//		B b = new B();
//		C c = (C) b;
		
		System.out.println(3*0.1 == 0.3);
		
	}
	

}


class A {
}

class B extends A {
	
}

class C extends B {
	
}
