package org.sayem.webdriver.listeners;

import org.sayem.webdriver.annotations.Browser;
import org.sayem.webdriver.annotations.WebSite;
import org.testng.*;

import java.lang.annotation.Annotation;

/**
 * Created by sayem on 2/24/16.
 */
public class TestNGListener implements IInvokedMethodListener2 {

    private String environment;
    private String browser;


    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        for (ITestNGMethod m : context.getAllTestMethods()) {
            if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(WebSite.class) &&
                    m.getConstructorOrMethod().getMethod().isAnnotationPresent(Browser.class)) {
                environment = m.getConstructorOrMethod().getMethod().getAnnotation(WebSite.class).value().getValue();
                browser = m.getConstructorOrMethod().getMethod().getAnnotation(Browser.class).browser().getValue();
            } else if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(WebSite.class)) {
                environment = m.getConstructorOrMethod().getMethod().getAnnotation(WebSite.class).value().getValue();
            } else if (m.getConstructorOrMethod().getMethod().isAnnotationPresent(Browser.class)) {
                browser = m.getConstructorOrMethod().getMethod().getAnnotation(Browser.class).browser().getValue();
            }
        }

        if (method.isTestMethod() && annotationPresent(method, WebSite.class) &&
                method.isTestMethod() && annotationPresent(method, Browser.class)) {
            System.setProperty("seleniumUrl", environment);
            System.setProperty("browser", browser);
        } else if (method.isTestMethod() && annotationPresent(method, WebSite.class)) {
            System.setProperty("seleniumUrl", environment);
        } else if (method.isTestMethod() && annotationPresent(method, Browser.class)) {
            System.setProperty("browser", browser);
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        // TODO Auto-generated method stub
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        // TODO Auto-generated method stub
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        // TODO Auto-generated method stub
    }

    private boolean annotationPresent(IInvokedMethod method, Class<? extends Annotation> clazz) {
        return method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(clazz);
    }
}

