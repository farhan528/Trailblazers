package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.Base;
import base.CusRegExcel;

public class UpcomingBikesPage extends Base {
	public UpcomingBikesPage(WebDriver driver) {
		this.driver = driver;
	}
	// Name
	// Price
	// Expected Launch Date

	@FindBy(xpath = "//*[@id=\'makeId\']")
	public WebElement manufacturer;

	public DisplayDetails hondamanufacturer() throws Exception {
		String CData[]=CusRegExcel.readExcelData("HackathonTestData.xlsx");	
		// Select Manufacturer as Honda
		Select optionvalue = new Select(manufacturer);
		optionvalue.selectByVisibleText(CData[2]);
		// Navigate to DisplayDetails.java using PageFactory
		return PageFactory.initElements(driver, DisplayDetails.class);

	}

}
