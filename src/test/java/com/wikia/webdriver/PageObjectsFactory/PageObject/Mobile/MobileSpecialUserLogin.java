package com.wikia.webdriver.PageObjectsFactory.PageObject.Mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wikia.webdriver.Common.Core.Assertion;

public class MobileSpecialUserLogin extends MobileBasePageObject {

	@FindBy(css=".wkErr")
	private WebElement errorMessage;

	public MobileSpecialUserLogin(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public void verifyWrongPasswordErrorMessage() {
		waitForElementByElement(errorMessage);
		Assertion.assertEquals(
				"Oops, wrong password. Make sure caps lock is off and try again.",
				errorMessage.getText()
		);
	}

	public void verifyWrongLoginErrorMessage() {
		waitForElementByElement(errorMessage);
		Assertion.assertEquals(
				"Hm, we don't recognize this name. Don't forget usernames are case sensitive.",
				errorMessage.getText()
		);
	}

	public void verifyEmptyPasswordErrorMessage() {
		waitForElementByElement(errorMessage);
		Assertion.assertEquals(
				"Oops, please fill in the password field.",
				errorMessage.getText()
		);
	}


}
