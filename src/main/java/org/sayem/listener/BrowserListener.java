package org.sayem.listener;

import org.sayem.annotations.Chrome;
import org.sayem.annotations.Firefox;
import org.testng.*;

import java.lang.annotation.Annotation;

public class BrowserListener implements IInvokedMethodListener2 {

    private static final String BROWSER = "browser";
    private String chrome;
    private String firefox;

    private static boolean annotationPresent(IInvokedMethod method, Class<? extends Annotation> clazz) {
        return method.getTestMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(clazz);
    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult, ITestContext iTestContext) {

        for (ITestNGMethod m : iTestContext.getAllTestMethods()) {
            if (isAnnotationPresent(m, Chrome.class)) {
                chrome = getAnnotation(m, Chrome.class).browser().getValue();
            } else if (isAnnotationPresent(m, Firefox.class)) {
                firefox = getAnnotation(m, Firefox.class).browser().getValue();
            }
        }

        if (iInvokedMethod.isTestMethod() && annotationPresent(iInvokedMethod, Chrome.class)) {
            System.setProperty(BROWSER, chrome);
        } else if (iInvokedMethod.isTestMethod() && annotationPresent(iInvokedMethod, Firefox.class)) {
            System.setProperty(BROWSER, firefox);
        }
    }


    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult, ITestContext iTestContext) {

    }

    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    private boolean isAnnotationPresent(ITestNGMethod m, Class<? extends Annotation> annotationClass) {
        return m.getConstructorOrMethod().getMethod().isAnnotationPresent(annotationClass);
    }

    private <T extends Annotation> T getAnnotation(ITestNGMethod m, Class<T> annotationClass) {
        return m.getConstructorOrMethod().getMethod().getAnnotation(annotationClass);
    }
}
