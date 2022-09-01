package com.stepdefinition;


import org.junit.Assert;

import com.base.BaseClass;
import com.pagemanagers.PageObjectManager;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass {
	
	PageObjectManager pom = new PageObjectManager();
	
/**
 * 
 * @author Welcome 
 * 
 * @since1947
 * 
 * 
 * @category KGF
 * 
 * 
 * 
 */
	
	
	
//	@Then("User should Verify the after Login {String}")
//	public void userShouldVerifyTheAfterLogin(String string) {
//		System.out.println(string);
//		Assert.assertEquals("Verify after login Welcome Msg", string, getAttribute(pom.getSearchHotelPage().getWelcomeText()));		
			
@Then("User should Verify the after Login {string}")
public void userShouldVerifyTheAfterLogin(String string) {
	            String attribute = getAttribute(pom.getSearchHotelPage().getWelcomeText());
	Assert.assertEquals("Verify after login Welcome Msg", string, attribute);	
	System.out.println(attribute);
	
}

}
