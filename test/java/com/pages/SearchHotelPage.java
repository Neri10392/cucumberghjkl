package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SearchHotelPage extends BaseClass {
	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username_show")
	private WebElement welcomeText;

	@FindBy(id = "location")
	private WebElement dDnLocation;

	@FindBy(id = "hotels")
	private WebElement dDnHotels;

	@FindBy(id = "room_type")
	private WebElement dDnRoomType;

	@FindBy(id = "room_nos")
	private WebElement dDnRoomNos;

//	@FindBy(id="datepick_in")
//	private WebElement clearin;
	
	@FindBy(id = "datepick_in")
	private WebElement datepickIn;
	
	@FindBy(id = "datepick_out")
	private WebElement datePickOut;
	
//	@FindBy(id="datepick_out")
//	private WebElement clearout;

	@FindBy(id = "adult_room")
	private WebElement dDnAdult;

	@FindBy(id = "child_room")
	private WebElement dDnChild;

	@FindBy(id = "Submit")
	private WebElement btnContinue;
	
	@FindBy(id = "location_span")
	private WebElement errorLocation;
	
	@FindBy(id ="checkin_span")
	private WebElement errorCheckIn;
	
	@FindBy(id="checkout_span")
	private WebElement errorCheckOut;
	
	@FindBy(xpath="//td[contains(text(),'Select Hotel ')]")
	private WebElement txtSelectHotel;
	
	
	
	public WebElement getTxtSelectHotel() {
		return txtSelectHotel;
	}

	public WebElement getWelcomeText() {
		return welcomeText;
	}

	public WebElement getErrorLocation() {
		return errorLocation;
	}

	public WebElement getErrorCheckIn() {
		return errorCheckIn;
	}

	public WebElement getErrorCheckOut() {
		return errorCheckOut;
	}

	public WebElement getdDnLocation() {
		return dDnLocation;
	}

	public WebElement getdDnHotels() {
		return dDnHotels;
	}

	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}

	public WebElement getdDnRoomNos() {
		return dDnRoomNos;
	}

	public WebElement getDatepickIn() {
		return datepickIn;
	}

	public WebElement getDatePickOut() {
		return datePickOut;
	}

	public WebElement getdDnAdult() {
		return dDnAdult;
	}

	public WebElement getdDnChild() {
		return dDnChild;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	

//	public WebElement getClearin() {
//		return clearin;
//	}

//	public WebElement getClearout() {
//		return clearout;
//	}

	public void selectByAllFields(String location, String hotels, String roomtype, String roomnos, String dateIn,
			String dateOut, String adultPerRoom, String childPerRoom) {

		elementSendKeys(getdDnLocation(), location);
		elementSendKeys(getdDnHotels(), hotels);
		elementSendKeys(getdDnRoomType(), roomtype);
		elementSendKeys(getdDnRoomNos(), roomnos);
		clear(getDatepickIn());
		elementSendKeys(getDatepickIn(), dateIn);
		clear(getDatePickOut());
		elementSendKeys(getDatePickOut(), dateOut);
		elementSendKeys(getdDnAdult(), adultPerRoom);
		elementSendKeys(getdDnChild(), childPerRoom);
		click(getBtnContinue());

	}

	public void selectMandotaryField(String location, String roomnos, String dateIn, String dateOut,
			String adultPerRoom) {
		elementSendKeys(getdDnLocation(), location);
		elementSendKeys(getdDnRoomNos(), roomnos);
		clear(getDatepickIn());
		elementSendKeys(getDatepickIn(), dateIn);
		clear(getDatePickOut());
		elementSendKeys(getDatePickOut(), dateOut);
		click(getBtnContinue());
	}

	public void withoutEnterAnyFields() {
		click(getBtnContinue());
	}

}
