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

public class BaseClass {

	public WebDriver driver;
	public static FileInputStream fileLocation;
	static String userName;
	static String password;
	static String url;

	protected static void getUserData() throws IOException {
		fileLocation = new FileInputStream(System.getProperty("user.dir") + "\\data.properties");
		Properties property = new Properties();
		property.load(fileLocation);
		userName = property.getProperty("username");
		password = property.getProperty("password");
		url = property.getProperty("url");

	}

	protected void initiateChromeDriver() {

		ChromeOptions coptions = new ChromeOptions();
		coptions.addArguments("--disable-notifications");
		coptions.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "src" + File.separator + "chromedriver.exe");
		driver = new ChromeDriver(coptions);

	}

}