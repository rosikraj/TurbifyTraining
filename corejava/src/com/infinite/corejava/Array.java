package com.infinite.corejava;

public class Array {
	public static void main(String[] args) {
		String y[] = { "monday", "tuesday", "wednesday", "thrusday" };
		String e = y[2].toUpperCase();
		char t[] = e.toCharArray();
		int p = t.length - 1;
		while (p >= 0) {
			System.out.print(t[p]);
			p--;
		}
	}
}