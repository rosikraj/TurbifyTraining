package com.infinite.corejava;

public class Comparethreevariables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 90, b = 890, c = 78;// compare for the highest variable
		if (a > b && a > c) {
			System.out.println("highest variable is :a ");
		}
		if (b > a && b > c) {
			System.out.println("highest variable is :b ");
		}
		if (c > a && c > b) {
			System.out.println("highest variable is :c ");
		}
		// compare for the lowest variable
		if (a < b && a < c) {
			System.out.println("lowest variable is :a ");
		}
		if (b < a && b < c) {
			System.out.println("lowest variable is :b ");
		}
		if (c < a && c < b) {
			System.out.println("lowest variable is :c ");
		}

	}

}
