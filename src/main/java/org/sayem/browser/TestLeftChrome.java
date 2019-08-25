package org.sayem.browser;

import com.smartbear.testleft.HttpException;
import com.smartbear.testleft.LocalDriver;
import com.smartbear.testleft.RestConnectionRefused;
import com.smartbear.testleft.TestAgentRunException;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLeftChrome implements Adapter<LocalDriver> {

    @Override
    public Browser<LocalDriver> browser() throws TestAgentRunException, RestConnectionRefused, HttpException {
        return new TestLeftAdapter<>(new LocalDriver());
    }
}
