package com.stepdefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_SelectHotelStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
	@When("User should Select Hotel Name")
	public void userShouldSelectHotelName() {
	pom.getSelectHotelPage().bySelectHotelName();
     }
	@Then("User should Verify after Select hotel name {string}")
	public void userShouldVerifyAfterSelectHotelName(String titleBookHotel)  {
		//String BookHotelLbl = pom.getBookHotelPage().getTitleBookHotel().getText();
		String actBokkHotel = gettext(pom.getSelectHotelPage().getTxtBookHotel());
		Assert.assertEquals("verify title", titleBookHotel, actBokkHotel);	
	}
	@When("User should without select Hotel Name")
	public void userShouldWithoutSelectHotelName() {

		pom.getSelectHotelPage().clickAndContinue();
	}
	@Then("User should click continue after verify success msg {string}")
	public void userShouldClickContinueAfterVerifySuccessMsg(String selectHotelSpam) {
		
		//String pleaseSelectError = pom.getSelectHotelPage().getBtnRadioSpan().getText();
		String acterrormsg = gettext(pom.getSelectHotelPage().getBtnRadioSpan());
		Assert.assertEquals("verify title book Hotel", selectHotelSpam, acterrormsg);
		
		
	}
}
