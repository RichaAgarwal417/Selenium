package com.selenium.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		WebDriver dr = new FirefoxDriver();
		//dr.get("https://www.amazon.ca");
		dr.get("https://www.amazon.ca/s/ref=sr_st_review-rank?keywords=sneakers+women&rh=i%3Aaps%2Ck%3Asneakers+women&qid=1545628192&sort=review-rank");
		Thread.sleep(2000);
		//dr.findElement(By.xpath("//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal' and contains (text(), \"Clarks Women's Breeze Sea Flip Flops\")]")).click();
		
		String productTitle = "Clarks Women's Breeze Sea Flip Flops";
		
		By productLink = By.xpath("//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal' and contains (text(), \""+ productTitle + "\")]");
		dr.findElement(productLink).click();
		
		
		//button.click();
		
		Select selectSize = new Select(dr.findElement(By.xpath("//select[@id = 'native_dropdown_selected_size_name' ]")));
		selectSize.selectByVisibleText("6 B(M) US");
		Thread.sleep(2000);
		//dr.navigate().refresh();
		WebElement button = dr.findElement(By.xpath("//input[@value='Add to Cart']"));
				
		//WebDriverWait wait = new WebDriverWait (dr, 30);
		//wait.until(ExpectedConditions.elementToBeClickable(button)); // visibilityOfElementLocated(By.xpath("//input[@value = 'Add to Cart']"))); 
		button.click();
		
		//   elementToBeClickable(button)).click();
		/*if(button.isEnabled()){
			System.out.println("richa");
		}*/
		
			}
	

}
