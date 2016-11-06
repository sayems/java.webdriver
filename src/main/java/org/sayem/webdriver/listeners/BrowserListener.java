package org.sayem.webdriver.listeners;

import org.sayem.webdriver.annotations.*;
import org.testng.*;

import java.lang.annotation.Annotation;

/**
 * Created by sayem on 10/10/16.
 */
public class BrowserListener implements IInvokedMethodListener2 {

    private static final String BROWSER = "browser";
    private static final String SELENIUM_URL = "seleniumUrl";
    private String environment;
    private String browser;
    private String chrome;
    private String ie;
    private String firefox;
    private String safari;

    private static boolean annotationPresent(IInvokedMethod method, Class<? extends Annotation> clazz) {
        return method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(clazz);
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {

        for (ITestNGMethod m : context.getAllTestMethods()) {
            if (isAnnotationPresent(m, Url.class) && isAnnotationPresent(m, Browser.class)) {
                environment = getAnnotation(m, Url.class).value().getValue();
                browser = getAnnotation(m, Browser.class).browser().getValue();
            } else if (isAnnotationPresent(m, Url.class) && isAnnotationPresent(m, Chrome.class)) {
                environment = getAnnotation(m, Url.class).value().getValue();
                chrome = getAnnotation(m, Chrome.class).browser().getValue();
            } else if (isAnnotationPresent(m, Url.class) && isAnnotationPresent(m, Firefox.class)) {
                environment = getAnnotation(m, Url.class).value().getValue();
                firefox = getAnnotation(m, Firefox.class).browser().getValue();
            } else if (isAnnotationPresent(m, Url.class) && isAnnotationPresent(m, Safari.class)) {
                environment = getAnnotation(m, Url.class).value().getValue();
                safari = getAnnotation(m, Safari.class).browser().getValue();
            } else if (isAnnotationPresent(m, Url.class) && isAnnotationPresent(m, InternetExplorer.class)) {
                environment = getAnnotation(m, Url.class).value().getValue();
                ie = getAnnotation(m, InternetExplorer.class).browser().getValue();
            } else if (isAnnotationPresent(m, Url.class)) {
                environment = getAnnotation(m, Url.class).value().getValue();
            } else if (isAnnotationPresent(m, Browser.class)) {
                browser = getAnnotation(m, Browser.class).browser().getValue();
            } else if (isAnnotationPresent(m, Firefox.class)) {
                firefox = getAnnotation(m, Firefox.class).browser().getValue();
            } else if (isAnnotationPresent(m, Chrome.class)) {
                chrome = getAnnotation(m, Chrome.class).browser().getValue();
            } else if (isAnnotationPresent(m, Safari.class)) {
                safari = getAnnotation(m, Safari.class).browser().getValue();
            } else if (isAnnotationPresent(m, InternetExplorer.class)) {
                ie = getAnnotation(m, InternetExplorer.class).browser().getValue();
            }
        }

        if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                annotationPresent(method, Browser.class)) {
            System.setProperty(SELENIUM_URL, environment);
            System.setProperty(BROWSER, browser);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                annotationPresent(method, Chrome.class)) {
            System.setProperty(SELENIUM_URL, environment);
            System.setProperty(BROWSER, chrome);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                annotationPresent(method, Firefox.class)) {
            System.setProperty(SELENIUM_URL, environment);
            System.setProperty(BROWSER, firefox);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                annotationPresent(method, Safari.class)) {
            System.setProperty(SELENIUM_URL, environment);
            System.setProperty(BROWSER, safari);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class) &&
                annotationPresent(method, InternetExplorer.class)) {
            System.setProperty(SELENIUM_URL, environment);
            System.setProperty(BROWSER, ie);
        } else if (method.isTestMethod() && annotationPresent(method, Url.class)) {
            System.setProperty(SELENIUM_URL, environment);
        } else if (method.isTestMethod() && annotationPresent(method, Browser.class)) {
            System.setProperty(BROWSER, browser);
        } else if (method.isTestMethod() && annotationPresent(method, Firefox.class)) {
            System.setProperty(BROWSER, firefox);
        } else if (method.isTestMethod() && annotationPresent(method, Chrome.class)) {
            System.setProperty(BROWSER, chrome);
        } else if (method.isTestMethod() && annotationPresent(method, Safari.class)) {
            System.setProperty(BROWSER, safari);
        } else if (method.isTestMethod() && annotationPresent(method, InternetExplorer.class)) {
            System.setProperty(BROWSER, ie);
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

    private boolean isAnnotationPresent(ITestNGMethod m, Class<? extends Annotation> annotationClass) {
        return m.getConstructorOrMethod().getMethod().isAnnotationPresent(annotationClass);
    }

    private <T extends Annotation> T getAnnotation(ITestNGMethod m, Class<T> annotationClass) {
        return m.getConstructorOrMethod().getMethod().getAnnotation(annotationClass);
    }
}
