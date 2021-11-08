package com.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target({ElementType.METHOD})
public @interface DataDictionary {
}
