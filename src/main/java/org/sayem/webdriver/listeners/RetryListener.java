package org.sayem.webdriver.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by sayem on 2/3/16.
 */
public class RetryListener implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation testannotation, Class testClass,
                          Constructor testConstructor, Method testMethod) {
        IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

        if (retry == null) {
            testannotation.setRetryAnalyzer(TestNGRetry.class);
        }
    }
}
