package com.infinite.beantest;
import java.util.Date;
import com.infinite.beans.Bean_user;

public class Bean_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bean_user rosik = new Bean_user();
		rosik.setUsername("Rosikraj");
		rosik.setPassword("rr");
		rosik.setLogindate(new Date());
		rosik.Display();
		System.out.println(rosik.getUsername());
	}
}
