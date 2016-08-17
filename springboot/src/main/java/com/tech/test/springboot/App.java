package com.tech.test.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.tech.test.cachelog.impl.UserDAO;
import com.tech.test.cachelog.model.User;

/**
 * Hello world!
 *
 */
@Controller
public class App {
	
	@Autowired
	private UserDAO userDao;
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView greeting(String phone) {
//		User user = userDao.findByPhone(phone);
		User user = userDao.findOne(1026);
		if (user != null) {
			return new ModelAndView("hello").addObject("name", user.getUserName());
		} else {
			return new ModelAndView("hello").addObject("name", "nobody");
		}
	}
}
