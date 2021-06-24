package com.wallet.assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class FacebookActionClass extends BaseClass {

	private WebElement userNameField() {
		return driver.findElement(By.id("email"));
	}

	private WebElement passwordField() {
		return driver.findElement(By.id("pass"));
	}

	protected WebElement homeLink() {
		return driver.findElement(By.cssSelector("a[aria-label='Home']"));
	}

	protected WebElement notNowButton() {
		return driver.findElement(By.cssSelector("div[aria-label='Not Now']:nth-child(2)"));
	}

	protected WebElement whatsOnYourMindSection() {
		return driver.findElement(By.cssSelector("[aria-label*='timeline']+div [style*='-webkit-box-orient']"));
	}

	protected WebElement textAreaExpanded() {
		return driver.findElement(By.cssSelector("div[aria-describedby*='placeholder']"));
	}

	protected WebElement postButton() {
		return driver.findElement(By.cssSelector("div[aria-label='Post']"));
	}

	public void launchAndLoginFacebook(FacebookActionClass object) {
		driver.get(fbUrl);
		object.userNameField().sendKeys(fbUserName);
		object.passwordField().sendKeys(fbPassword + Keys.ENTER);
	}

}
