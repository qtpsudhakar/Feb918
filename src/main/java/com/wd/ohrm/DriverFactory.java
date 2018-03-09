package com.wd.ohrm;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
	private static WebDriver driver;
	public static WebDriver getDriver(String brName) {

		driver = null;
		switch (brName) {

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\chromedriver.exe");
			ChromeOptions cp = new ChromeOptions();
			cp.addArguments("--disable-notifications");
			
			// open new chrome window
			driver = new ChromeDriver(cp);
			break;
		case "firefox":
			// specify driver
			System.setProperty("webdriver.gecko.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\geckodriver.exe");
			
			FirefoxProfile p = new FirefoxProfile();
			p.setPreference("dom.webnotifications.enabled", false);
			
			FirefoxOptions fo = new FirefoxOptions();
			fo.setProfile(p);
			driver = new FirefoxDriver(fo);
			
			// open new ff window
			driver = new FirefoxDriver();
			break;
		case "ie":
			// specify driver
			System.setProperty("webdriver.ie.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\IEDriverServer.exe");

			// open new ie window
			driver = new InternetExplorerDriver();
			break;
		case "edge":
			// specify driver
			System.setProperty("webdriver.edge.driver", "F:\\SeleniumSoftware\\BrowserDrivers\\MicrosoftWebDriver.exe");

			// open new ie window
			driver = new EdgeDriver();
			break;
		default:
			//new Exception("no browser found");
		}
		
		return driver;
	}

	public static WebDriver getRemoteDriver(String osName, String brName) throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName(brName);
		
		switch(osName.toLowerCase()) {
		
		case "win8":
			cap.setPlatform(Platform.WIN8_1);
			break;
		case "win10":
			cap.setPlatform(Platform.WIN10);
			break;
		case "win7":
			cap.setPlatform(Platform.WINDOWS);
			break;
		case "mac":
			cap.setPlatform(Platform.MAC);
			break;
		}
		
		return driver = new RemoteWebDriver(new URL("http://192.168.1.126:4444/wd/hub"), cap);
		
	}
	public JavascriptExecutor getJsDriver() {
		return (JavascriptExecutor) driver;
	}
	
}













