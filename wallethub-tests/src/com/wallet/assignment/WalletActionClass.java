package com.wallet.assignment;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;

public class WalletActionClass extends BaseClass {

	protected WebElement loginButton() {
		return driver.findElement(By.cssSelector(".brgm-button.brgm-signup.brgm-signup-login"));
	}

	private WebElement userNameField() {
		return driver.findElement(By.id("email"));
	}

	private WebElement passwordField() {
		return driver.findElement(By.id("password"));
	}

	protected List<WebElement> starsList() {
		return driver.findElements(By.cssSelector(".rv.review-action.ng-enter-element .rvs-svg svg"));
	}

	private WebElement policyDropdown() {
		return driver.findElement(By.cssSelector("[class='dropdown second']"));
	}

	private WebElement healthInsValue() {
		return driver.findElement(By.cssSelector("[class='dropdown second opened']  ul li:nth-child(2)"));
	}

	private WebElement reviewTextField() {
		return driver.findElement(By.cssSelector(".android textarea"));
	}

	private WebElement submitButton() {
		return driver.findElement(By.cssSelector(".fixed-w-c.tall"));
	}

	private WebElement confirmationText() {
		return driver.findElement(By.cssSelector(".ng-enter-element .rvc-header h4"));
	}

	private WebElement userProfileListBox() {
		return driver.findElement(By.cssSelector(".brgm-button.brgm-user.brgm-list-box"));

	}

	private WebElement profileButtonInList() {
		return driver.findElement(By.cssSelector(".brgm-list.brgm-user-list.ng-enter-element a:nth-child(1)"));

	}

	private WebElement reviewOnProfilePage() {
		return driver.findElement(By.cssSelector(".pr-ct-box.pr-rec .pr-rec-title"));

	}

	public void launchAndLoginWalletHub(WalletActionClass object) {
		driver.get(walletUrl);
		object.loginButton().click();
		object.userNameField().sendKeys(walletUserName);
		object.passwordField().sendKeys(walletPassword + Keys.ENTER);
	}

	public void hoverOverStarsAndClickOnFourthStar(WalletActionClass object) throws InterruptedException {
		waitForAllElementsToBecomeInVisible(object.starsList(), 20);
		Actions actions = new Actions(driver);
		for (int i = 0; i < 4; i++) {
			actions.moveToElement(object.starsList().get(i)).perform();
			Thread.sleep(1000);
		}
		object.starsList().get(3).click();

	}

	public void clickPolicyDropdown() {
		policyDropdown().click();
	}

	public void selectHealthInsuranceValue() {
		healthInsValue().click();
	}

	public void enterReviewText() {
		reviewTextField().sendKeys(
				"Nam vel mauris leo. Vestibulum commodo mi sed augue bibendum facilisis. Proin dictum dignissim nibh. Mauris non nisl tincidunt, f.");
	}

	public void clickSubmitButton() {
		submitButton().click();
	}

	public String getBrowserTitle() {
		return confirmationText().getText();
	}

	public void hoverOverUsernameAndClickOnProfile(WalletActionClass object) throws InterruptedException {
		Actions actions = new Actions(driver);

		actions.moveToElement(object.userProfileListBox()).perform();
		Thread.sleep(1000);
		actions.moveToElement(object.profileButtonInList()).perform();
		object.profileButtonInList().click();

	}

	public boolean AssertThatUserIsAbleToSeeTheReview() {
		if (reviewOnProfilePage().getText().contains("Recommendations")) {
			return true;
		} else
			return false;

	}

}
