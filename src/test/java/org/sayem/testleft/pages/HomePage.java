package org.sayem.testleft.pages;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.InvocationException;
import com.smartbear.testleft.testobjects.web.WebElement;
import com.smartbear.testleft.testobjects.web.WebPage;

public class HomePage {

    private WebPage page;

    public HomePage(WebPage page) {
        this.page = page;
    }

    public HomePage googleSearch() throws InvocationException, HttpException {
        page.querySelector(WebElement.class, "").click();
        return this;
    }
}
