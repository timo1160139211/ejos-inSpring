package site.gaoyisheng.test;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import site.gaoyisheng.pojo.User;
import site.gaoyisheng.service.impl.LoginServiceImpl;
import site.gaoyisheng.service.impl.UserServiceImpl;

public class TestMe {

	private static final Logger logger = LoggerFactory.getLogger(TestMe.class);

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		UserServiceImpl us = context.getBean(UserServiceImpl.class);
		LoginServiceImpl ls = context.getBean(LoginServiceImpl.class);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("number", "15110471070");
		param.put("password", "123456");

		User u = us.getUserByPrimaryKey(2);
		User u1 = ls.selectByNumberAndPassword(param);
		System.out.println(u.toString());
		System.out.println(u1.toString());
	}

}
