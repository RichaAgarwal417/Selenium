/**
 * Author: Richa Agarwal
 */
package com.selenium.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductBrowse {
	
	/**
	 * This function will search the product and click on search button.
	 * @param dr
	 * @param wait
	 * @param productName
	 * @throws InterruptedException
	 */
	public void productSearch(WebDriver dr, WebDriverWait wait, String productName) throws InterruptedException{
		By searchBox = By.xpath("//input[@id = 'twotabsearchtextbox']");
		By autoSuggestItem = By.xpath("//div[@id='issDiv2']");
		
		WebElement searchText = dr.findElement(searchBox);
		Thread.sleep(30000);
		searchText.sendKeys(productName);
		WebElement autoSuggest = wait.until(ExpectedConditions.visibilityOfElementLocated(autoSuggestItem));
		autoSuggest.click();
	}
	
	/**
	 * This function will sort the order of the searched product.
	 * @param dr
	 * @param sortOrder
	 */
	public void sort(WebDriver dr, String sortOrder) {
		
		Select sortMenu = new Select(dr.findElement(By.id("sort")));
		switch (sortOrder) {
		case "Featured":
			sortMenu.selectByIndex(0);
			break;
		case "Ascending":
			sortMenu.selectByIndex(1);
			break;
		case "Descending":
			sortMenu.selectByIndex(2);
			break;
		case "Average":
			sortMenu.selectByIndex(3);
			break;
		case "New":
			sortMenu.selectByIndex(4);
			break;
			
		}
	}
	
	public void selectShoeClosureType(WebDriver dr, WebDriverWait wait, String laceType) {
		By laceUp = By.xpath("//input[@name = 's-ref-checkbox-11162235011']");
		By slipOn = By.xpath("//input[@name = 's-ref-checkbox-11162236011']");
		
		WebElement selectCheckbox = null;
		
		switch (laceType) {
		case "lace":
			selectCheckbox = dr.findElement(laceUp);
			break;
		case "slip":
			selectCheckbox = dr.findElement(slipOn);
			break;
		}
		wait.until(ExpectedConditions.visibilityOf(selectCheckbox));
		if(!selectCheckbox.isSelected())
		{
			selectCheckbox.click();
		}
	}
	/**
	 * This function will click on the product from the sorted order.
	 * @param dr
	 * @param wait
	 * @param productTitle
	 */
	public static void clickOnProduct(WebDriver dr, WebDriverWait wait, String productTitle)
	{
		By productLink = By.xpath("//h2[@class='a-size-medium s-inline  s-access-title  a-text-normal' and contains (text(), \""+productTitle+"\")]");
		
		try {
			Thread.sleep(2000);
			WebElement product = dr.findElement(productLink);
			wait.until(ExpectedConditions.visibilityOf(product)); //     elementToBeClickable(product)).click();
			product.click();
		}
		catch (Exception e) {
			System.out.println("Richa");
		}
	}
	/**
	 * This function will select the shoesize on product screen
	 * @param dr
	 * @param size
	 */
	public static void SelectSizeOfTheProduct(WebDriver dr, String size)
	{
		By selectSize = By.xpath("//select[@id = 'native_dropdown_selected_size_name' ]");
		
		Select sSize = new Select(dr.findElement(selectSize));
		sSize.selectByVisibleText(size);
	}
	/**
	 * This function will click on AddToCart button
	 * @param dr
	 * @param wait
	 * @throws InterruptedException
	 */
	public static void AddToCart(WebDriver dr, WebDriverWait wait) throws InterruptedException
	{
		By addToCart =  By.xpath("//input[@value='Add to Cart']");
		Thread.sleep(2000);
		WebElement buttonAddToCart = dr.findElement(addToCart);
		wait.until(ExpectedConditions.visibilityOf(buttonAddToCart)); //  elementToBeClickable(buttonAddToCart));
		if (buttonAddToCart.isDisplayed())
		{
			buttonAddToCart.click();
		}
		else
		{
			System.out.println("Add To Cart button is not displayed");
		}
	}
	/**
	 * This function will click and navigate to cart.
	 * @param dr
	 * @param wait
	 */
	public static void checkItemsInCart(WebDriver dr, WebDriverWait wait)
	{
		By cart = By.xpath("//a[@id = 'hlb-view-cart-announce'][@class= 'a-button-text']");
		
		WebElement clickCart = dr.findElement(cart);
		wait.until(ExpectedConditions.visibilityOf(clickCart));
		clickCart.click();
	}
	/**
	 * This function will click and navigate to proceedToCheckout
	 * @param dr
	 * @param wait
	 */
	public static void proceedToCheckout(WebDriver dr, WebDriverWait wait)
	{
		By checkout = By.xpath("//a[@id = 'hlb-ptc-btn-native'][@class = 'a-button-text a-text-center']");
		
		WebElement proceedToCheckout = dr.findElement(checkout);
		wait.until(ExpectedConditions.visibilityOf(proceedToCheckout));
		proceedToCheckout.click();
	}
	/**
	 * This function will select and process as per userOption
	 * @param dr
	 * @param userOption
	 * @param wait
	 */
	public static void selectUserOption(WebDriver dr, String userOption, WebDriverWait wait)
	{
		try {
				if (userOption.equals("cart"))
				{
					checkItemsInCart(dr, wait);
				}
				else if (userOption.equals("proceedToCheckout"))
				{
					proceedToCheckout(dr, wait);
				}
				else
				{
					System.out.println("No Option Selected by User");
				}
			}
		catch (Exception e) {
			System.out.println("InValid Selection: Following Exception Occured->");
			System.out.println(e.getMessage());
		}
		
	}
}
