package com.automation.testutilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtil extends TestBase {
	/**
     * Waits for element to display.
     * @param locator
     */
    public void waitForElementToDisplay(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
   
	
	/** 
	 * To Refresh page.
	 */
	public void navigate_refresh() {
	driver.navigate().refresh();
	}

	/** 
	 * click Webelement.
	 * @param element
	 */
	public void clickWebelement(WebElement element) {
	try {
		boolean status = element.isEnabled();
		if(status) {
	
		element.click();
		}
	

	} catch (Exception e) {
	System.out.println("Element is not enabled");
	e.printStackTrace();
	}
	}

	/** 
	 * Select element from dropdown.
	 * @param element,@param value
	 */
	public void selectElementByValueMethod(WebElement element,
	String value) {
	try{
	Select selectitem = new Select(element);
	selectitem.selectByValue(value);
	}catch (Exception e) {
	System.out.println("Element is not enabled");
	e.printStackTrace();
	}

	}


	/** 
	 * Enter the value in editbox.
	 * @param element,@param val
	 */
	public void entervalueinfield(WebElement element,String val) {
	try {
		boolean status = element.isEnabled();
		if(status) {
		element.sendKeys(val);
		}
	

	}catch (Exception e) {
	System.out.println("Element is not enabled");
	e.printStackTrace();
	}
	}
	
	public void selectElementByIndexMethod(WebElement element, int index) {
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
		}

}
