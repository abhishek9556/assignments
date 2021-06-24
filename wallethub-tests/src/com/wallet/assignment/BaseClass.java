package com.wallet.assignment;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public WebDriver driver;
	public static FileInputStream fileLocation;
	String fbUserName;
	String fbPassword;
	String fbUrl;
	String walletUserName;
	String walletPassword;
	String walletUrl;

	protected void getFacebookUserData() throws IOException {
		fileLocation = new FileInputStream(System.getProperty("user.dir") + "\\data.properties");
		Properties property = new Properties();
		property.load(fileLocation);
		fbUserName = property.getProperty("username");
		fbPassword = property.getProperty("password");
		fbUrl = property.getProperty("url");

	}

	protected void getWalletUserData() throws IOException {
		fileLocation = new FileInputStream(System.getProperty("user.dir") + "\\data.properties");
		Properties property = new Properties();
		property.load(fileLocation);
		walletUserName = property.getProperty("walletUsername");
		walletPassword = property.getProperty("walletPassword");
		walletUrl = property.getProperty("walletUrl");

	}

	protected void initiateChromeDriver() throws IOException {
		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--disable-notifications");
		coptions.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "src" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver(coptions);
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

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

	protected void closeBrowser() {

		driver.quit();
	}

}