package com.infinite.security;

public class Enc_Dec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(JavaSecurity.encrypt("root","Rosik"));
		System.out.println(JavaSecurity.decrypt("o0BMSaKUE3TpAbtoDwQYIw==","Rosik"));
		System.out.println(JavaSecurity.encrypt("mysql23","rosik"));
		System.out.println(JavaSecurity.decrypt("5uuKdkWlSkeCy47aWb1zsg==","rosik"));
	}

}
