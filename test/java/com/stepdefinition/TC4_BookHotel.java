package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;

public class TC4_BookHotel extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	
	@Then("User should Book hotel {string},{string} and {string}")
	public void userShouldBookHotelAnd(String firstName, String lastName, String address, io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
           
		List<Map<String, String>> maps = dataTable.asMaps();
	    Map<String, String> map = maps.get(0);
	    String txtCardNo = map.get("cardNo");
	    String txtCardType = map.get("cardType");
	    String txtExpMonth = map.get("expMonth");
	    String txtExpYear = map.get("expYear");
	    String txtCvv = map.get("cvv");

		pom.getBookHotelPage().bookHotel(firstName, lastName, address, txtCardNo, txtCardType, txtExpMonth, txtExpYear, txtCvv);
                   
    }
	@Then("User should navigate to Book Hotel and verify success msg {string}")
	public void userShouldNavigateToBookHotelAndVerifySuccessMsg(String bookingtitle) {
//		String titleConfirm = pom.getBookHotelPage().getTitleConfirmaton().getText();
		String acttitleConfirm = gettext(pom.getBookHotelPage().getTitleConfirmaton());
		Assert.assertEquals("verify booking Confirmation msg", bookingtitle, acttitleConfirm);

	}

	@Then("User should click Book Now without enter any fields")
	public void userShouldClickBookNowWithoutEnterAnyFields() throws InterruptedException {
		
		pom.getBookHotelPage().bookWithoutEnterAnyField();

	}
	@Then("User should verify error msg {string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldVerifyErrorMsgAnd(String firstNameerror, String lastNameerror, String addresserror, String cardNoerror, String cardTypeerror, String cardExperror, String cvverror) {
       String firstNameSpan = pom.getBookHotelPage().getFistNameSpan().getText();
       Assert.assertEquals("verify Please Enter FirstName", firstNameerror, firstNameSpan);
       
       String lastNameSpan = pom.getBookHotelPage().getLastNameSpan().getText();
       Assert.assertEquals("verify Please Enter LastName", lastNameerror, lastNameSpan);
       
       String addressSpan = pom.getBookHotelPage().getAddressSpan().getText();
       Assert.assertEquals("verify Please Enter FirstName", addresserror, addressSpan);
       
       String cardNoSpan = pom.getBookHotelPage().getCardNoSpan().getText();
       Assert.assertEquals("verify Please Enter cardNo", cardNoerror, cardNoSpan);
       
       String cardTypeSpan = pom.getBookHotelPage().getCardTypeSpan().getText();
       Assert.assertEquals("verify Please Enter cardType", cardTypeerror, cardTypeSpan);
       
       String cardExpSpan = pom.getBookHotelPage().getCardExpSpan().getText();
       Assert.assertEquals("verify Please Enter ExpMonth", cardExperror, cardExpSpan);
       
       String cvvSpan = pom.getBookHotelPage().getCvvSpan().getText();
       Assert.assertEquals("verify Please Enter Cvv", cvverror, cvvSpan);
       
       
       
	}


}
