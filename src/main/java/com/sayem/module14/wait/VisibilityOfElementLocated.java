package com.sayem.module14.wait;

 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
 
public class VisibilityOfElementLocated implements ExpectedCondition {
 
	By findCondition;
 
	VisibilityOfElementLocated(By by) {
		this.findCondition = by;
	}
 
	

	@Override
	public Object apply(Object driver) {
		((WebDriver)driver).findElement(this.findCondition);
		return Boolean.valueOf(true);
	}
 
}