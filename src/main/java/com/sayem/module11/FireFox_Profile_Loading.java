package com.sayem.module11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;


public abstract class FireFox_Profile_Loading {

	public static void main(String[] args) {
		ProfilesIni allProfiles = new ProfilesIni();
		FirefoxProfile profile = allProfiles.getProfile("ashish");
	
		WebDriver driver = new FirefoxDriver(profile);
		
		driver.get("http://www.gmail.com");
		System.out.println("Title is --  " +driver.getTitle());
		System.out.println("Current URL -- "+ driver.getCurrentUrl());
		System.out.println("Page source ---- ");
		System.out.println(driver.getPageSource());
		
		driver.quit();
	}

}
