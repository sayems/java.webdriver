package org.sayem.webdriver.annotations;

import org.sayem.webdriver.Repository;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.sayem.webdriver.Repository.CHROME;

/**
 * Created by sayem on 2/24/16.
 */
@Retention(RUNTIME)
@Target({METHOD})
public @interface Browser {
    Repository browser() default CHROME;
}
