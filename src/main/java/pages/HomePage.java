package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;

public class HomePage extends Base {
	public HomePage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//body/div/div[1]/div[1]/div[1]/span[1]")
	public WebElement cancel_homeframe_button;

	@FindBy(xpath = "//html//body//header//div//div//div//div//ul//li//a[contains(text(),'New Bikes')]")
	public WebElement newbikes_mousehover;

	@FindBy(xpath = "/html/body/header/div[2]/div[2]/div/div[2]/ul/li[3]/ul/li/div[1]/ul/li[5]/a")
	public WebElement upcomingbikes_mousehover;

	public UpcomingBikesPage home() throws InterruptedException {
		String MainWindow = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {

				driver.switchTo().window(ChildWindow);

				Thread.sleep(6000);
				// Click on cancel button on a frame Which Car or Bike you own
				cancel_homeframe_button.click();

			}
		}

		// Navigate to newBikes, Click on Upcoming Bikes
		Actions act = new Actions(driver);
		act.moveToElement(newbikes_mousehover).moveToElement(upcomingbikes_mousehover).click().build().perform();

		// Navigate to UpcomingBikePage.java using PageFactory
		return PageFactory.initElements(driver, UpcomingBikesPage.class);

	}

}
