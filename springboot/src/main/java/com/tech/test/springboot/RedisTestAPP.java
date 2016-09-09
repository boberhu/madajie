/**
 * Copyright ©2016 www.uinpay.cn Technology Co.,Ltd.All Rights Reserved
 * com.tech.test.springboot.RedisTestAPP.java
 * Administrator 2016年9月9日
 */
/**   
* @Title: RedisTestAPP.java 
* @Package com.tech.test.springboot 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bober bober.hu@outlook.com
* @date 2016年9月9日 下午3:52:59 
* @version V1.0   
*/
package com.tech.test.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tech.test.cachelog.model.Address;
import com.tech.test.cachelog.model.Users;
import com.tech.test.service.DemoService;

/**
 * @autor: Administrator
 * desc  : ...
 */
@Controller
public class RedisTestAPP {
	
	@Autowired  
    DemoService demoService;  
  
    @RequestMapping("/test")  
    @ResponseBody  
    public String putCache(){  
        demoService.findUser(1l,"wang","yunfei");  
        demoService.findAddress(1l,"anhui","hefei");  
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");  
        return "ok";  
    }  
    @RequestMapping("/test2")  
    @ResponseBody  
    public String testCache(){  
        Users user = demoService.findUser(1l,"wang","yunfei");  
        Address address =demoService.findAddress(1l,"anhui","hefei");  
        System.out.println("我这里没执行查询");  
        System.out.println("user:"+"/"+user.getFirstName()+"/"+user.getLastName());  
        System.out.println("address:"+"/"+address.getProvince()+"/"+address.getCity());  
        return "ok";  
    }
	
}
