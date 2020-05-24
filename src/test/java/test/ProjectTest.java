package test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.Base;
import pages.HomePage;
import pages.LandingPage;
import pages.LoginPage;
import pages.UpcomingBikesPage;
import utils.ExtentReportManager;

public class ProjectTest extends Base{
	LandingPage landingpage;
	LoginPage loginpage;
	HomePage homepage;
	UpcomingBikesPage upcomingbikespage;

	@Test
	public void openBrowser() throws Exception {
		
		logger = report.createTest("Zigwheels Automation");
		Base base = new Base();
		logger.log(Status.INFO, "Initializing the Browser");
		base.invokeBrowser("chrome");
		logger.log(Status.INFO, "Opening the Website");
		landingpage = base.OpenApplication("websiteURL");
		logger.log(Status.INFO, " Login initated Successfully");
		loginpage = landingpage.initiatelogin();
		logger.log(Status.INFO, "Entered Credentials Successfully");

		homepage = loginpage.login();
		logger.log(Status.INFO, "Login Successfull");

		upcomingbikespage = homepage.home();
		logger.log(Status.INFO, "Got Upcoming Honda Bikes Successfully");
		upcomingbikespage.hondamanufacturer();
        
	}

}