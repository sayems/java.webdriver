package org.sayem.browser;

import com.smartbear.testleft.ApiException;
import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.RestConnectionRefused;
import com.smartbear.testleft.TestAgentRunException;
import com.smartbear.testleft.testobjects.TestObject;
import org.openqa.selenium.WebDriver;

/**
 * Created by sayem on 08/02/17.
 */
public interface WebAdapter<T extends TestObject, W extends WebDriver> extends Adapter<T> {

    Browser<T> webPage(String url) throws TestAgentRunException, RestConnectionRefused, HttpException, ApiException;

    Browser<W> webDriver();
}
