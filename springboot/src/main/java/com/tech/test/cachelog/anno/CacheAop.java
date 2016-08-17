package com.tech.test.cachelog.anno;

import java.lang.reflect.Method;
import java.util.Date;

import javax.annotation.Resource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

//import com.danga.MemCached.MemCachedClient;
import com.tech.test.cachelog.CacheLogService;
import com.tech.test.cachelog.model.CacheLog;

public class CacheAop {
	
	private CacheLogService logService;
	
//	private MemCachedClient client;
	
	@Resource(name="cacheLogService") 
	public void setCacheLogService(CacheLogService cacheLogService) {  
        this.logService = cacheLogService;  
    }
	
	@Resource(name="memcachedClient")
//	public void setClient(MemCachedClient client) {
//		this.client = client;
//	}
//	
	 //定义切面  
    @Pointcut("execution(* com.tech.test.cachelog..*.*(..))")  
    public void cachedPointcut() {  
  
    }
    
    @Around("cachedPointcut()")  
    public Object doAround(ProceedingJoinPoint call){  
         Object result = null;  
         Method[] methods = call.getTarget().getClass().getDeclaredMethods();    
         Signature signature = call.getSignature();  
         MethodSignature methodSignature = (MethodSignature) signature;    
         Method method = methodSignature.getMethod();  
           
         for(Method m:methods){//循环方法，找匹配的方法进行执行  
             if(m.getName().equals(method.getName())){  
                 if(m.isAnnotationPresent(Cache.class)){  
                     Cache cache = m.getAnnotation(Cache.class);  
                     if(cache!=null){  
                            String tempKey = this.getKey(method, call.getArgs());  
                            String prefix = cache.prefix();  
                            String key = prefix+"_"+tempKey;  
//                            result =client.get(key);  
//                            if(null == result){  
//                                try {  
//                                    result = call.proceed();  
//                                    long expiration = cache.expiration();//1000*60*60*2==2小时过期  
//                                    Date d=new Date();  
//                                    d=new Date(d.getTime()+expiration);  
//                                    client.set(key, result, d);  
//                                    //将key存入数据库  
//                                    CacheLog log = new CacheLog();  
//                                    log.setPrefix(prefix);  
//                                    log.setKey(key);  
//                                    this.logService.saveLog(log);  
//                                } catch (Throwable e) {  
//                                    e.printStackTrace();  
//                                }  
//                            }  
                              
                        }  
                } else  if(method.isAnnotationPresent(Flush.class)){  
                     Flush flush = method.getAnnotation(Flush.class);  
                     if(flush!=null){  
                            String prefix = flush.prefix();  
                            CacheLog logs= logService.findLog(prefix); 
                            System.out.println("hello !!!");
                             if(logs!=null){  
//                                 //删除数据库  
//                                int rows =  logService.deleteByPrefix(prefix);  
//                                if(rows>0){  
//                                    for(CacheLog log :logs){  
//                                        if(log!=null){  
//                                            String key = log.getCacheKey();  
//                                            Memcache.delete(key);//删除缓存  
//                                        }  
//                                    }  
//                                }  
                             }  
                        }  
                 }else{  
                     try {  
                         result = call.proceed();  
                        } catch (Throwable e) {  
                            e.printStackTrace();  
                        }  
                 }  
                 break;  
             }  
              
        }  
          
          
          
        return result;  
    }  
      
    /** 
     * 组装key值 
     * @param method 
     * @param args 
     * @return 
     */  
   private String getKey(Method method, Object [] args){  
        StringBuffer sb = new StringBuffer();   
        String methodName = method.getName();  
        sb.append(methodName);  
        if(args!=null && args.length>0){  
              
            for(Object arg:args){  
                sb.append(arg);  
            }  
        }  
          
        return sb.toString();  
         
   }  
}
