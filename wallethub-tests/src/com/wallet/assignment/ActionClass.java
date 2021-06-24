package com.wallet.assignment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionClass extends BaseClass {

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

	public void launchAndLoginFacebook(ActionClass object) {
		driver.get(url);
		object.userNameField().sendKeys(userName);
		object.passwordField().sendKeys(password + Keys.ENTER);
	}

	public WebElement waitForElementToLoad(WebElement element, int waitInSeconds) {
		new WebDriverWait(driver, waitInSeconds).until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public WebElement waitForElementToClick(WebElement element, int waitTime) {
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.elementToBeClickable(element));
		return element;
	}

	public List<WebElement> waitForAllElementsToBecomeInVisible(List<WebElement> element, int waitInSeconds) {
		new WebDriverWait(driver, waitInSeconds).until(ExpectedConditions.invisibilityOfAllElements(element));
		return element;
	}

}
