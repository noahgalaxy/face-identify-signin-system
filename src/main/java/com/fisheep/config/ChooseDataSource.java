package com.fisheep.config;
import com.fisheep.constant.DataSourceConstants;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface ChooseDataSource {
    String value() default DataSourceConstants.DEFAULT_DATA_SOURCE;
}

