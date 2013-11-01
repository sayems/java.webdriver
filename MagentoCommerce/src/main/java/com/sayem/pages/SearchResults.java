package com.sayem.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchResults extends LoadableComponent<SearchResults> {

	private String query;
	
	public SearchResults(String query){
		PageFactory.initElements(Browser.driver(),this);
	}
	
	@Override
    public void isLoaded() {
    	assertTrue(Browser.driver().getTitle().equals("Search results for: '" + this.query
    			+ "' - Magento1 Commerce Demo Store"));
    }

	@Override
	protected void load() {
		// TODO Auto-generated method stub
	}
	
	public List<String> getProducts() {
		List<String> products = new ArrayList<String>();
		List<WebElement> productList = Browser.driver().findElements(By.cssSelector("ul.products-grid > li"));
		for(WebElement item : productList)
			products.add(item.findElement(By.cssSelector("h2 > a")).getText());
		return products;
	}
	
	public void close() {
    	Browser.close();
    }
	
	 public Search Search() {
	    	Search search = new Search();
	    	return search;
	 }
}
