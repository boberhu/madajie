package com.tech.test.springboot;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.danga.MemCached.MemCachedClient;
import com.tech.test.cachelog.CacheLogService;
import com.tech.test.cachelog.model.CacheLog;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
    public void inteceptorTest(){  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");  
        PersonServer bean = (PersonServer)ctx.getBean("personServiceBean");  
        bean.save(null);
        
//        MemCachedClient mc = (MemCachedClient)ctx.getBean("memcachedClient");
        
//        mc.add("hello-a", "abc");
//        
//        System.out.println(mc.get("hello-a"));
//        
//        CacheLogService logService = (CacheLogService)ctx.getBean("cacheLogService");
//        
//        CacheLog log = new CacheLog();
//        log.setKey("a");
//        log.setPrefix("test");
//        logService.saveLog(log);
//        
//        logService.findLog("a");
    }  
}
