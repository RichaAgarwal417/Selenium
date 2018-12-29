package com.selenium.amazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonTest {
	WebDriver dr;
	WebDriverWait wait;
	AmazonTest(){
		dr = new FirefoxDriver();
		wait = new WebDriverWait(dr,10);
	}
	public static void main(String[] args) throws InterruptedException {
		AmazonTest at = new AmazonTest();
		Login lg =new Login();
		ProductBrowse pb = new ProductBrowse();
		lg.signIn(at.dr, "https://www.amazon.ca", "<Enter your amazon username>", "<enter your pswd>");
		pb.productSearch(at.dr, at.wait, "Sneakers ");
		pb.sort(at.dr, "Average");
		//pb.selectShoeClosureType(at.dr, at.wait, "lace");
		pb.clickOnProduct(at.dr, at.wait, "Clarks Women's Wave Trek Lace-Up Fashion Sneaker");
		pb.SelectSizeOfTheProduct(at.dr, "10 M US");
		pb.AddToCart(at.dr, at.wait);
		pb.selectUserOption(at.dr, "cart", at.wait);
	}
}
