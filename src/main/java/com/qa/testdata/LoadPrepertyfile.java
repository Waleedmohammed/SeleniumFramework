package com.qa.testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoadPrepertyfile {

	public static Properties UserData = loadproperties(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
			
			
	private static Properties loadproperties(String Path) {
		Properties prop = new Properties();
		try {
			
			FileInputStream ip = new FileInputStream(Path);			
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}
	
	
}
