package com.selenium.amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.selenium.amazonConfigs.*;

public class AmazonTest {
	WebDriver dr;
	WebDriverWait wait;
	AmazonTest(){
		dr = new FirefoxDriver();
		wait = new WebDriverWait(dr,10);
	}
	
	public static void main(String[] args) throws InterruptedException {

		AmazonTest at = new AmazonTest();
		ReadTestData rtd = new ReadTestData();
		Login lg =new Login();
		ProductBrowse pb = new ProductBrowse();
		
		String URL = rtd.getURL();
		String Username = rtd.getUsername();
		String Password = rtd.getPassword();
		
		lg.signIn(at.dr, URL, Username, Password);
		pb.productSearch(at.dr, at.wait, "Sneakers ");
		pb.sort(at.dr, "Average");
		Thread.sleep(2000);
		//pb.selectShoeClosureType(at.dr, at.wait, "lace");
		pb.clickOnProduct(at.dr, at.wait, "Clarks Women's Wave Trek Lace-Up Fashion Sneaker");
		//pb.SelectSizeOfTheProduct(at.dr, "10 M US");
		pb.AddToCart(at.dr, at.wait, "10 M US");
		pb.selectUserOption(at.dr, "cart", at.wait);
	}
}
