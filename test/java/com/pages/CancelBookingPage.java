package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

public class CancelBookingPage extends BaseClass {
	
	private static String idNo = null ;
	
	public CancelBookingPage() {

		PageFactory.initElements(driver, this);
	
	}
	@FindBy(id="order_no")
	private WebElement printOrderId;
	
	
	@FindBy(id="order_id_text")
	private WebElement txtOrderId;

	@FindBy(xpath="//a[text()='Booked Itinerary']")
	private WebElement btnBookedItinerary;
	
	@FindBy(id="search_hotel_id")
	private WebElement btnGo;
	
	@FindBy(xpath="//input[@name='ids[]']")
	private WebElement CheckBox;
	
	@FindBy(xpath="(//input[@type='button'])[1]")
	private WebElement btnCancel;

	@FindBy(id="search_result_error")
	private WebElement cancelledErrorMsg;
	

	public WebElement getPrintOrderId() {
		return printOrderId;
	}



	public WebElement getBtnCancel() {
		return btnCancel;
	}



	public WebElement getprintOrderId() {
		return printOrderId;
	}



	public WebElement getCancelledErrorMsg() {
		return cancelledErrorMsg;
	}



	public WebElement getTxtOrderId() {
		
		return txtOrderId;
	}



	public WebElement getBtnBookedItinerary() {
		return btnBookedItinerary;
	}



	public WebElement getBtnGo() {
		return btnGo;
	}



	public WebElement getCheckBox() {
		return CheckBox;
	}

	public void cancelOrderId(String idNo) throws InterruptedException {
		
		click(getBtnBookedItinerary());
		Thread.sleep(3000);
elementSendKeys(getTxtOrderId(),idNo);		
		click(getBtnGo());
		
		click(getCheckBox());
		
		click(getBtnCancel());
		
		alertclick();
		
	}

}


