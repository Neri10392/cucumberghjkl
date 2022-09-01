package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class BookHotelPage extends BaseClass {
public BookHotelPage() {
	PageFactory.initElements(driver, this);
}
	@FindBy(id = "first_name")
	private WebElement txtFname;

	@FindBy(id = "last_name")
	private WebElement txtLname;

	@FindBy(id = "address")
	private WebElement txtAddress;
	
	@FindBy(id="cc_num")
	private WebElement cardNo;
	
	@FindBy(id="cc_type")
	private WebElement cardType;
	
	@FindBy(id="cc_exp_month")
	private WebElement cardExpMonth;
	
	@FindBy(id="cc_exp_year" )
	private WebElement cardExpYear;
	
	@FindBy(id="cc_cvv")
	private WebElement cardCvv;

	
	@FindBy(xpath = "//td[text()='Book A Hotel ']")
	private WebElement titleBookHotel;
	
	@FindBy(xpath = "//td[contains(text(),'Booking Confirmation')] ")
	private WebElement titleConfirmaton;
	

	@FindBy(id = "first_name_span")
	private WebElement fistNameSpan;

	@FindBy(id = "last_name_span")
	private WebElement lastNameSpan;

	@FindBy(id = "address_span")
	private WebElement addressSpan;

	@FindBy(xpath = "//label[contains(text(),'your 16 ')]")
	private WebElement cardNoSpan;
	
	@FindBy(id = "cc_type_span")
	private WebElement cardTypeSpan;
	
	@FindBy(id = "cc_expiry_span")
	private WebElement cardExpSpan;
	
	@FindBy(id = "cc_cvv_span")
	private WebElement cvvSpan;
	
	
	

	

	@FindBy(id = "book_now")
	private WebElement bookNow;

	@FindBy(id = "order_no")
	private WebElement orderId;
	
	public WebElement getTitleConfirmaton() {
		return titleConfirmaton;
	}

	public WebElement getTxtFname() {
		return txtFname;
	}

	public WebElement getTxtLname() {
		return txtLname;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}
	public WebElement getCardNo() {
		return cardNo;
	}

	public WebElement getCardType() {
		return cardType;
	}

	public WebElement getCardExpMonth() {
		return cardExpMonth;
	}

	public WebElement getCardExpYear() {
		return cardExpYear;
	}

	public WebElement getCardCvv() {
		return cardCvv;
	}

	public WebElement getTitleBookHotel() {
		return titleBookHotel;
	}

	public WebElement getFistNameSpan() {
		return fistNameSpan;
	}

	public WebElement getLastNameSpan() {
		return lastNameSpan;
	}

	public WebElement getAddressSpan() {
		return addressSpan;
	}

	public WebElement getCardNoSpan() {
		return cardNoSpan;
	}

	public WebElement getCardTypeSpan() {
		return cardTypeSpan;
	}

	public WebElement getCardExpSpan() {
		return cardExpSpan;
	}

	public WebElement getCvvSpan() {
		return cvvSpan;
	}

	public WebElement getBookNow() {
		return bookNow;
	}

	public WebElement getOrderId() {
		return orderId;
	}

	public void bookHotel(String firstName, String lastName, String address,String cardNo,String cardType,String cardExpMonth,String cardExpYear,String cvv) throws InterruptedException {

		elementSendKeys(getTxtFname(), firstName);
		elementSendKeys(getTxtLname(), lastName);
		elementSendKeys(getTxtAddress(), address);
        elementSendKeys(getCardNo(), cardNo);
    	elementSendKeys(getCardType(), cardType);
    	elementSendKeys(getCardExpMonth(), cardExpMonth);
    	elementSendKeys(getCardExpYear(), cardExpYear);
    	elementSendKeys(getCardCvv(), cvv);
    	
    	
		click(getBookNow());
		Thread.sleep(10000);

	}

	public void bookWithoutEnterAnyField() throws InterruptedException {
		click(getBookNow());
		Thread.sleep(10000);
	}

}
