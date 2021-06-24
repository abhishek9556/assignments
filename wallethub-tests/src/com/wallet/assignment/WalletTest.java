package com.wallet.assignment;

import java.io.IOException;

public class WalletTest extends WalletActionClass {

	public static void main(String[] args) throws IOException, InterruptedException {

		WalletActionClass wallet = new WalletActionClass();

		wallet.getWalletUserData();
		wallet.initiateChromeDriver();
		wallet.launchAndLoginWalletHub(wallet);
		wallet.hoverOverStarsAndClickOnFourthStar(wallet);
		wallet.clickPolicyDropdown();
		wallet.selectHealthInsuranceValue();
		wallet.enterReviewText();
		wallet.clickSubmitButton();
		wallet.hoverOverUsernameAndClickOnProfile(wallet);

		if (wallet.AssertThatUserIsAbleToSeeTheReview() == true) {
			System.out.println("User is able to post the review and it's displaying on profile page");
		} else {
			System.out.println(" User Review is not displaying on profile page");
		}

		wallet.closeBrowser();

	}

}
