package com.wallet.assignment;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

public class FacebookTest extends ActionClass {
	WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		FacebookTest facebook = new FacebookTest();
		getUserData();
		facebook.initiateChromeDriver();
		facebook.launchAndLoginFacebook(facebook);

		Thread.sleep(2000);
		facebook.waitForElementToClick(facebook.homeLink(), 5);
		facebook.waitForElementToLoad(facebook.homeLink(), 5);
		facebook.homeLink().click();

		// In case if the browser shows - Click on Not Now for Remember Password button
		Thread.sleep(2000);
		facebook.waitForElementToLoad(facebook.notNowButton(), 5);
		facebook.notNowButton().click();
		;

		// Click on What's on Your Mind? section
		Thread.sleep(1000);
		facebook.waitForElementToLoad(facebook.whatsOnYourMindSection(), 5);
		facebook.whatsOnYourMindSection().click();

		// Click on the expanded text area
		Thread.sleep(1000);
		facebook.waitForElementToLoad(facebook.textAreaExpanded(), 5);
		facebook.textAreaExpanded().click();
		facebook.textAreaExpanded().sendKeys("Hello World");

		// Click On Post Button

		facebook.waitForElementToLoad(facebook.postButton(), 5);
		facebook.postButton().click();

	}

}
