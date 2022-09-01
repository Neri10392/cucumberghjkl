
package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_SearchHotelStep extends BaseClass {
	
	           
	PageObjectManager pom = new PageObjectManager();

	@When("User should enter valid {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldEnterValidAnd(String location, String hotels, String roomtype, String roomnos, String dateIn, String dateOut, String adultPerRoom, String childPerRoom) {
   
		pom.getSearchHotelPage().selectByAllFields(location, hotels, roomtype, roomnos, dateIn, dateOut, adultPerRoom, childPerRoom);
		
	}
	@Then("User should navigate to Select Hotel and verify success msg {string}")
	public void userShouldNavigateToSelectHotelAndVerifySuccessMsg(String selectHotel) {
		//String actualText = pom.getSelectHotel().getSlectMsgMsg().getText();
		//Assert.assertEquals("verify select Hotel msg", selectHotel, actualText);
		
		String actselecthotel = gettext(pom.getSearchHotelPage().getTxtSelectHotel());
		Assert.assertEquals("verify select Hotel msg", selectHotel, actselecthotel);
	}

	@When("User should enter mandotory fields {string},{string},{string},{string} and {string}")
	public void userShouldEnterMandotoryFieldsAnd(String location, String roomnos, String dateIn, String dateOut, String adultPerRoom) {
		pom.getSearchHotelPage().selectMandotaryField(location, roomnos, dateIn, dateOut, adultPerRoom);
	}


	@Then("User should verify date error msg {string} and {string}")
	public void userShouldVerifyDateErrorMsgAnd(String dateInError, String dateOutError) {
		
		String checkInErrorText = pom.getSearchHotelPage().getErrorCheckIn().getText();
//		String actErcheckin = gettext(pom.getSearchHotelPage().getDatepickIn());
		Assert.assertEquals("Verify ChectInDate Error", dateInError, checkInErrorText);
		
		String checkOutErrorText = pom.getSearchHotelPage().getErrorCheckOut().getText();
//		String actErcheckout = gettext(pom.getSearchHotelPage().getDatePickOut());
		Assert.assertEquals("Verify CheckOutDate Error", dateOutError, checkOutErrorText);
		
	}
	@When("User should click search button without entering any fields")
	public void userShouldClickSearchButtonWithoutEnteringAnyFields() {
		
		//pom.getSearchHotelPage().getBtnContinue();
		pom.getSearchHotelPage().withoutEnterAnyFields();
	}
	
	@Then("User should  verify error msg {string}")
	public void userShouldVerifyErrorMsg(String pleaseSelectLocation) {
		
		//String locationError = pom.getSearchHotelPage().getErrorLocation().getText();
		
		String actErlocation = gettext(pom.getSearchHotelPage().getErrorLocation());
		
		Assert.assertEquals("verify Select Location", pleaseSelectLocation, actErlocation);
		
		
	}
	



}
