package com.stepdefinition;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_CancelBooking extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@When("User should cancel booking using order id")
	public void userShouldCancelBookingUsingOrderId() throws InterruptedException {
		// Thread.sleep(10000);
		String idNo = pom.getBookingConfirmation().getOrderId();
		pom.getCanceBookingPage().cancelOrderId(idNo);

	}

	@When("User should navigate to Booked Itinerary page and cancel existing {string}")
	public void userShouldNavigateToBookedItineraryPageAndCancelExisting(String idNo) throws InterruptedException {
		pom.getCanceBookingPage().cancelOrderId(idNo);

	}

	@Then("User should verify after cancel the order id {string}")
	public void userShouldVerifyAfterCancelTheOrderId(String expcancelerr) {
		
		String acterrormsg = pom.getCanceBookingPage().getCancelledErrorMsg().getText();
		Assert.assertEquals("verify cancelled orderid msg", expcancelerr, acterrormsg);
	}

}
