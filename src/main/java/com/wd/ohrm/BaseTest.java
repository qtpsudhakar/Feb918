package com.wd.ohrm;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.wd.ohrm.DriverFactory;

public class BaseTest {
	public static WebDriver driver;

	@BeforeClass
	@Parameters({ "browser", "aUrl" })
	public void OpenApplication(String brName, String appUrl) {

		try {

			// open chrome window
			driver = DriverFactory.getDriver(brName);

			// maximize window
			driver.manage().window().maximize();

			// specify page load time
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			// specify find element time
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// navigate to orange hrm
			driver.get(appUrl);
		} catch (Exception e) {
			System.out.println("Failed at OpenApplication");
			throw e;
		} 
	}

	@AfterClass
	public void closeApplication() {
		driver.quit();
	}
}
