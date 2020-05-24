package base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pages.LandingPage;
import pages.LoginPage;
import utils.ExtentReportManager;


public class Base {
	public WebDriver driver;
	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	public void invokeBrowser(String browsername) {
		try {
			if (browsername.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\resourc\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browsername.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\resourc\\driver\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else {
				System.setProperty("webdriver.IEDriverServer.driver",
						System.getProperty("user.dir") + "\\src\\resourc\\driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
		} catch (Exception e) {

		}
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);

		if (prop == null) {
			prop = new Properties();

			try {
				FileInputStream file = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\resourc\\ObjectRepository\\projectConfig.properties");
				prop.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}
	
	public LandingPage OpenApplication(String websiteURLKey ) {
		driver.get(prop.getProperty(websiteURLKey));
		return PageFactory.initElements(driver, LandingPage.class);
	}
	
	
	
	public void closebrowser() {
		driver.close();
	}
	
	@AfterMethod
	public void reportFlush() {
		report.flush();
	}
	
	

}
