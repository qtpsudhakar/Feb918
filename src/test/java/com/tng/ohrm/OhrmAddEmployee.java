package com.tng.ohrm;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.wd.ohrm.BaseTest;

public class OhrmAddEmployee extends BaseTest {

	@Test()
	public void Login() {
		System.out.println("Login started");
		// enter text on username
		driver.findElement(By.id("txtUsername")).sendKeys("admin");

		// enter text on password
		driver.findElement(By.name("txtPassword")).sendKeys("admin");

		// click on login button
		driver.findElement(By.id("btnLogin")).click();

		System.out.println("Logged into application");
		System.out.println("end of login");
	}

	@Test(dependsOnMethods = "Login")
	public void AddEmployee() {
		// click on PIM lnk
		driver.findElement(By.linkText("PIM")).click();

		// click on add employee
		driver.findElement(By.partialLinkText("Add Emp")).click();

		// enter text on first name
		driver.findElement(By.id("firstName")).sendKeys("selenium");

		// enter text on last name
		driver.findElement(By.id("lastName")).sendKeys("hq");

		// click on save
		driver.findElement(By.id("btnSave")).click();

		System.out.println("Employee Added");
	}

}
