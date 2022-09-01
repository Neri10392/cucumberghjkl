package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUsername;

	@FindBy(id = "password")
	private WebElement txtPassword;

	@FindBy(id = "login")
	private WebElement btnLogIn;

	@FindBy(xpath = "//b[contains(text(),'Invalid ')]")
	private WebElement errorText;
	
	

	public WebElement getTxtusername() {
		return txtUsername;
	}

	public WebElement getTxtpassword() {
		return txtPassword;
	}

	public WebElement getBtnLogIn() {
		return btnLogIn;
	}

	public WebElement getErrorText() {
		return errorText;
	}

	public void login(String username, String password) {

		elementSendKeys(getTxtusername(), username);
		elementSendKeys(getTxtpassword(), password);
		click(getBtnLogIn());

	}

	public void loginWithEnter(String username, String password) throws AWTException {

		elementSendKeys(getTxtusername(), username);
		elementSendKeys(getTxtpassword(), password);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
