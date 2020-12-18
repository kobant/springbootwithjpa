package com.example.springbootwithjpa.Annotation;

import java.lang.annotation.*;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2020/12/18 16:52
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PermissionsAnnotation {
}
