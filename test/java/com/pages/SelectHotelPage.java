package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class SelectHotelPage extends BaseClass {
	
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="radiobutton_0")
	private WebElement btnradio;
	
	@FindBy(id="continue")
	private WebElement btncontinue;
	
	@FindBy(id="radiobutton_span")
	private WebElement btnRadioSpan;
	
	@FindBy(xpath = "//td[contains(text(),'Select Hotel ')]")
	private WebElement selectHotelMsg;
	
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement txtBookHotel;
	
	
	
	

	public WebElement getTxtBookHotel() {
		return txtBookHotel;
	}

	public WebElement getBtnradio() {
		return btnradio;
	}

	public WebElement getBtncontinue() {
		return btncontinue;
	}

	public WebElement getSelectHotelMsg() {
		return selectHotelMsg;
	}

	public WebElement getBtnRadioSpan() {
		return btnRadioSpan;
	}

	public void bySelectHotelName() {
	   click(getBtnradio());
	   click(getBtncontinue());
	}

	public void clickAndContinue() {
		click(getBtncontinue());
	
	}
}
