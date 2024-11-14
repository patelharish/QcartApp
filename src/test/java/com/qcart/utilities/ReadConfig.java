package com.qcart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	public ReadConfig() { //constructor
		File src = new File("./Configuration/config.properties");
	
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUsername() {
		String user = prop.getProperty("username");
		return user;
	}
	
	public String getPassword() {
		String pass = prop.getProperty("password");
		return pass;
	}
	
	public String getInvUsername() {
		String invuser = prop.getProperty("invusername");
		return invuser;
	}
	
	public String getInvPassword() {
		String invpass = prop.getProperty("invpassword");
		return invpass;
	}
	
	
}
