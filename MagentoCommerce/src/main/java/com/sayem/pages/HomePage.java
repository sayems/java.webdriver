package com.sayem.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.Assert.*;

public class HomePage extends LoadableComponent<HomePage> {

	static String url = "http://demo.magentocommerce.com/";
    private static String title = "Home page - Magento Commerce Demo Store";
   
    public HomePage() {
    	PageFactory.initElements(Browser.driver(), this);
    }
    
    @Override
    public void load() {
        Browser.open(url);
    }

    @Override
    public void isLoaded() {
    	assertTrue(Browser.driver().getTitle().equals(title));
    }
    
    public void close() {
    	Browser.close();
    }
    
    public Search Search() {
    	Search search = new Search();
    	return search;
    }
}
