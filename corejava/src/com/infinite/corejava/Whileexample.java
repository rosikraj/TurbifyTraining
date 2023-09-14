package com.infinite.corejava;

public class Whileexample {
	public static void main(String[] args) {
		int j = 10;
		while (j <= 90) {
			if (j == 60) {
				j = j + 10;
				continue;
			}

			System.out.println(j);
			j = j + 10;
		}

	}
}
