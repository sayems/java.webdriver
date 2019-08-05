package org.sayem.annotations;

import org.sayem.config.Repository;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.sayem.config.Repository.CHROME;

@Retention(RUNTIME)
@Target({METHOD})
public @interface Chrome {
    Repository browser() default CHROME;
}
