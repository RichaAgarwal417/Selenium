/**
 * Author: Richa Agarwal
 */
package com.selenium.amazon;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {
	
	/**
	 * This function will navigate user to the url and signIn to the account with given username and Password.
	 * @param dr
	 * @param url
	 * @param username
	 * @param password
	 */
	public void signIn(WebDriver dr, String url, String username, String password) {
		dr.get(url);
		WebElement yourAccount = dr.findElement(By.xpath("//a[@class = 'nav-a nav-a-2']"));
		yourAccount.click();
		WebElement userName = dr.findElement(By.xpath("//input[@id = 'ap_email']"));
		userName.sendKeys(username);
		WebElement pswd = dr.findElement(By.xpath("//input[@id = 'ap_password']"));
		pswd.sendKeys(password);
		dr.findElement(By.xpath("//input[@id = 'signInSubmit']")).click();
		
	}
}
