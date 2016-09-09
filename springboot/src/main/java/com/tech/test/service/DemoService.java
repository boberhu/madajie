/**
 * Copyright ©2016 www.uinpay.cn Technology Co.,Ltd.All Rights Reserved
 * com.tech.test.service.DemoService.java Administrator 2016年9月9日
 */
package com.tech.test.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.tech.test.cachelog.model.Address;
import com.tech.test.cachelog.model.Users;

/**
 * @autor: Administrator desc : ...
 */
@Service
public class DemoService {
	
	@Cacheable(value = "usercache" , keyGenerator = "wiselyKeyGenerator")
	public Users findUser(Long id , String firstName , String lastName){
		System.out.println("无缓存的时候调用这里");
		return new Users(id , firstName , lastName);
	}
	
	@Cacheable(value = "addresscache" , keyGenerator = "wiselyKeyGenerator")
	public Address findAddress(Long id , String province , String city){
		System.out.println("无缓存的时候调用这里");
		return new Address(id , province , city);
	}
}
