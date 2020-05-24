package pages;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import base.CusRegExcel;



public class LoginPage extends Base {
	public LoginPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div/div[1]/div/div[1]/input")
	public WebElement emailid_textbox;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/span/span")
	public WebElement emailid_continue_button;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[1]/div/form/span/section/div/div/div[1]/div[1]/div/div/div/div/div[1]/div/div[1]/input")
	public WebElement password_textbox;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/span/span")
	public WebElement password_continue_textbox;
	
	
	
	public HomePage login() throws Exception {
		
		//CusRegExcel cs=new CusRegExcel();
		
		String CData[]=CusRegExcel.readExcelData("HackathonTestData.xlsx");	
		//Thread.sleep(5000);
		String MainWindow = driver.getWindowHandle();

		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();
		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			if (!MainWindow.equalsIgnoreCase(ChildWindow)) {
				
				driver.switchTo().window(ChildWindow);
				
				emailid_textbox.sendKeys(CData[0]);
				emailid_continue_button.click();
				password_textbox.sendKeys(CData[1]);
				Thread.sleep(3000);
				password_continue_textbox.click();
				
			}
		}Thread.sleep(4000);
		return PageFactory.initElements(driver, HomePage.class);

	}
}
