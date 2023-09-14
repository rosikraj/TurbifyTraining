package com.infinite.corejava;

public class Stringinfinite {
	public static void main(String args[]){
		String a="INFINITE";
		String b="infinite";
		String c="";
		System.out.println(a.length());
		String u=a.trim();
		System.out.println(a.length());;
		System.out.println(u.substring(0,3));
		System.out.println((a.equals(b.toUpperCase())));
		System.out.println(u.indexOf('E'));
		System.out.println(c.isEmpty());
		System.out.println(u.isEmpty());
		System.out.println(u.lastIndexOf('I'));
		System.out.println(u.equalsIgnoreCase(b));
		System.out.println(u.concat("COMPANY"));
		System.out.println(u.concat(b));
		System.out.println(u.endsWith("F"));
		System.out.println(u.hashCode());
		System.out.println(b.hashCode());
		System.out.println(a.replaceAll("N","F"));
		
		
	}

}
