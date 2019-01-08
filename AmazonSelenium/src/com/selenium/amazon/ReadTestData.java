package com.selenium.amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadTestData {
	
	private Properties prop;
	private final String filePath = "<filepath>";

	public ReadTestData()
	{
		// Read data from file 
		
		File file = new File(filePath);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		prop = new Properties();		
		try {
			prop.load(fileInput);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getURL() {
		String Url = prop.getProperty("Url");
		if(Url!=null)return Url;
		else throw new RuntimeException("Url is not specified in test data file");
	}
	
	public String getUsername() {
		String Username = prop.getProperty("Username");
		if(Username!= null)return Username;
		else throw new RuntimeException("Username is not specified in test data file");
	}
	public String getPassword() {
		String Password = prop.getProperty("Password");
		if(Password!= null)return Password;
		else throw new RuntimeException("Password is not specified in test data file");
	}
}
