package com.tech.test.cachelog.anno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)     
@Retention(RetentionPolicy.RUNTIME)      
@Documented      
@Inherited 
public @interface Cache {
	
	String prefix();//key的前缀，如咨询：zx  
	  
    long expiration() default 1000*60*60*2;//缓存有效期 1000*60*60*2==2小时过期 
}
