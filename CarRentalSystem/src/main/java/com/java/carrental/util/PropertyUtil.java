package com.java.carrental.util;

import java.util.ResourceBundle;

public class PropertyUtil {

	public static void getPropertyString() {
		ResourceBundle rb = ResourceBundle.getBundle("db");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String user = rb.getString("user");
		String password = rb.getString("password");
		System.out.println("Driver "+driver);
		System.out.println("URL  "+ url);
		System.out.println("User "+ user);
		System.out.println("Password "+password);
	}
	
}
