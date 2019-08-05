package org.sayem.annotations;

import org.sayem.config.Repository;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.sayem.config.Repository.FIREFOX;

@Retention(RUNTIME)
@Target({METHOD})
public @interface Firefox {
    Repository browser() default FIREFOX;
}
