package com.infinite.corejava;

class A {
	public void display() {
		System.out.println("A");

	}
}

class B extends A {
	public void diaplay() {
		System.out.println("B");
	}
}

public class Superclass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B obj = new B();
		obj.display();
	}

}
