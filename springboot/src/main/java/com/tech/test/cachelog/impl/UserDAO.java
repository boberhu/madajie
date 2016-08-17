/**
 * 
 */
package com.tech.test.cachelog.impl;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.tech.test.cachelog.model.User;

/**
 * @author Administrator
 *
 */

public interface UserDAO extends JpaRepository<User, Integer> {
	
	@Transactional
	public User findByPhone(@Param("phone") String phone);
}
