package com.selenium.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.config.*;
import com.selenium.util.*;
import static com.selenium.main.DriverScript.prop;
import com.selenium.main.DriverScript;



public class Keyword {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void openBrowser(String object, String data)
	{
		try {
			Logs.info("Opening FirefoxBrowser");
			driver = new FirefoxDriver();
		}
		catch(Exception e) {
			Logs.error("Error in opening Fireox " + e.getMessage());
			DriverScript.result = false;
		}

	}

	public static void navigate(String object, String data)
	{
		try {
			Logs.info("Navigating to the Website");
			driver.get(prop.getProperty(object));
		}
		catch(Exception e) {
			Logs.error("Error --- Not able to navigate to the Website "+ e.getMessage());
			DriverScript.result = false;
		}

	}

	public static void enterUsername(String object, String data)
	{
		try {
			Logs.info("Writing Username");
			driver.findElement(By.xpath(prop.getProperty(object))).sendKeys(Constants.username);
		}
		catch(Exception e) {
			Logs.error("Not able to enter Username " + e.getMessage());
			DriverScript.result = false;
		}
	}

	public static void enterPassword(String object, String data)
	{
		try {
			Logs.info("Entering Password");
			driver.findElement(By.xpath(prop.getProperty(object))).sendKeys(Constants.password);
		}
		catch (Exception e) {
			Logs.error("Error while entering password"+e.getMessage());
			DriverScript.result = false;
		}

	}

	public static void click(String object, String data)
	{
		String element = driver.findElement(By.xpath(prop.getProperty(object))).getAttribute("value");
		try {
			Logs.info("Clicking on element " +"$$$$$$$$$ "+ element + " $$$$$$$$$$");
			driver.findElement(By.xpath(prop.getProperty(object))).click();
		}
		catch (Exception e) {
			Logs.error("Unable to click on WebElement "+"$$$$$$$$$ "+ element + " $$$$$$$$$$"+e.getMessage());
			DriverScript.result = false;
		}

	}

	public static void verify(String object, String data)
	{
		try {
			Logs.info("Verifying SignIn is succesfull");
			String Expectedtitle = "LinkedIn";
			String Actualtitle = driver.getTitle();
			if(Actualtitle.contains(Expectedtitle))
			{
				DriverScript.result = true;
			}
			else {
				DriverScript.result = false;
			}
		}
		catch(Exception e) {
			Logs.error("SignIn failed "+e.getMessage());
			DriverScript.result = false;
		}
	}

	public static void input(String object, String data)
	{
		try {
			Logs.info("Entering " + data + " in search box");
			WebElement searchbox = driver.findElement(By.xpath(object));
			wait.until(ExpectedConditions.visibilityOf(searchbox));
			searchbox.sendKeys(data);
		}
		catch(Exception e) {
			Logs.error("Unable to input "+data+" in search box field" + e.getMessage());
			DriverScript.result = false;
		}
	}

}
