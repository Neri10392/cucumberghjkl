package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

public class BookingConfirmation extends BaseClass {
	
	static String orderId;
	public BookingConfirmation() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "order_no")
	private WebElement order;

	public WebElement getOrder() {
		return order;
	}
	
	

	public String getOrderId() throws InterruptedException {
		
		orderId = getAttribute(getOrder());
		 
		return orderId;
		
		 
		
		

		
		
	}

}
