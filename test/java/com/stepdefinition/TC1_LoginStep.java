package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1_LoginStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the Adactin Login page")
	public void userIsOnTheAdactinLoginPage() throws IOException {
		
//		getDriver(getPropertyFileValue("browserType"));
//		getUrl(getPropertyFileValue("url"));
		
	}
	
	@When("User should perform Login {string} and {string}")
	public void userShouldPerformLoginAnd(String username, String password) {
		pom.getLoginPage().login(username, password);
	}
	
	@When("User should perform Login {string} and {string} with Enter Key")
	public void userShouldPerformLoginAndWithEnterKey(String username, String password) throws AWTException {
		pom.getLoginPage().loginWithEnter(username, password);
	
	}

	@Then("User should verify the after Login error contains {string}")
	public void userShouldVerifyTheAfterLoginErrorContains(String errorText) {
		
	  String text = pom.getLoginPage().getErrorText().getText();
	  
		Assert.assertTrue("verify error msg", text.contains(errorText));
	
	}

}
