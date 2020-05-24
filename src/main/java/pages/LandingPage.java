package pages;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Base;

public class LandingPage extends Base { // FLOW---- landing->login->Home->Upcoming->Display

	public LandingPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//html//body//header//div//div//div//div//div//div//div//div//div//img")
	public WebElement user_icon;

	@FindBy(css = "#googleSignIn")
	public WebElement continue_with_google_button;

	public LoginPage initiatelogin() throws InterruptedException {
		// Click on user icon
		
		user_icon.click();
		// Click on continue with google
		Thread.sleep(10000);
		continue_with_google_button.click();
		Thread.sleep(3000);
		// Navigate to LoginPage.java using PageFactory
		return PageFactory.initElements(driver, LoginPage.class);

	}

}
