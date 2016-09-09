/**
 * Copyright ©2016 www.uinpay.cn Technology Co.,Ltd.All Rights Reserved
 * com.tech.test.cachelog.model.Users.java
 * Administrator 2016年9月9日
 */
package com.tech.test.cachelog.model;

/**
 * @autor: Administrator
 * desc  : ...
 */
public class Users {  
    private Long id;  
    private String firstName;  
    private String lastName;  
  
    public Users(Long id,String firstName, String lastName) {  
        this.id = id ;  
        this.firstName = firstName;  
        this.lastName = lastName;  
    }  
  
    public Users() {  
    }  
  
    public Long getId() {  
        return id;  
    }  
  
    public void setId(Long id) {  
        this.id = id;  
    }  
  
    public String getFirstName() {  
        return firstName;  
    }  
  
    public void setFirstName(String firstName) {  
        this.firstName = firstName;  
    }  
  
    public String getLastName() {  
        return lastName;  
    }  
  
    public void setLastName(String lastName) {  
        this.lastName = lastName;  
    }  
}  
