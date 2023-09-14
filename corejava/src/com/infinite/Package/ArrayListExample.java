package com.infinite.Package;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList ls = new ArrayList();
		ls.add(34);
		ls.add("Rosik");
		ls.add("Rosik");
		ls.add(33.45f);
		for (int a = 89; a < 99; a++)
			ls.add(a);
		System.out.println(ls);
		System.out.println("size " + ls.size());
		System.out.println(ls.get(3));
		System.out.println(ls.isEmpty());
		System.out.println(ls.remove(2));
		System.out.println(ls.toArray());
		Iterator it = ls.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
			
		}
		
	for(Object p:ls)
	{
		System.out.print(p);
	}
}
}