package com.java.solutions;

public class ConstructorCall {
	ConstructorCall() {
		greeting();
		prints();
	}
	void greeting() {
		System.out.println("instance method from B");
	}
	static void prints() {
		System.out.println("Static method from B");
	}
	public static void main(String[] args) {
		new supperClass();
	}
}

class supperClass extends ConstructorCall  {
	supperClass() {
		greeting();
		prints();
	}
	void greeting() {
		System.out.println("instance method from A");
	}
	static void prints() {
		System.out.println("Static method from A");
	}
	
}