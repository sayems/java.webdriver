package com.sayem.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Search {
	
	private WebElement search;
	@FindBy(css = "button.button")
	private WebElement searchButton; 

	public Search() {
		PageFactory.initElements(Browser.driver(), this);
	}
	
	public SearchResults searchInStore(String query) {
		search.sendKeys(query);
		searchButton.click();
		return new SearchResults(query);
	}
}
