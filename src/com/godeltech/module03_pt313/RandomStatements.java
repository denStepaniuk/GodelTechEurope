package com.godeltech.module03_pt313;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomStatements {
    int value() default 0;
    String strValue() default "Hello World!";
    boolean isValue() default false;
}


