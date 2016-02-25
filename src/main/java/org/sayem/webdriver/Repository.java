package org.sayem.webdriver;

/**
 * Created by sayem on 12/28/15.
 */
public enum Repository {

    /**
     * Browser settings
     */

    CHROME("chrome"),
    FIREFOX("firefox"),
    SAFARI("safari"),
    IE("ie"),
    EDGE("edge"),
    OPERA("opera"),
    PHANTOMJS("phantomjs"),
    HTML_UNIT("htmlunit"),

    /**
     * Environment settings
     */
    MADISON_ISLAND(""),
    THE_INTERNET("http://the-internet.herokuapp.com/"),
    JQUERY_DEMO("http://jqueryui.com/demos/"),
    PHP_TRAVELS("http://phptravels.com/demo/"),
    MERCURY_TOUR("http://newtours.demoaut.com/"),
    WAY2AUTOMATION("http://www.way2automation.com/demo.html"),
    AUTOMATION_PRACTICE("http://automationpractice.com/index.php"),
    DEMO_QA("http://demoqa.com/"),
    ORANGE_HRM("http://enterprise.demo.orangehrmlive.com/symfony/web/index.php/auth/login"),


    /**
     * Properties file settings
     */
    LOCATION("src/test/resources/org.sayem.webdriver/selenium.properties"),
    BROWSER("browser"),
    URL("url");

    private String value;

    Repository(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }
}