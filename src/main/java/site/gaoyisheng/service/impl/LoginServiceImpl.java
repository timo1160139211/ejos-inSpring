package site.gaoyisheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.gaoyisheng.dao.UserMapper;
import site.gaoyisheng.pojo.User;
import site.gaoyisheng.service.LoginService;

@Service("loginService")  
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userDao; 
    
	@Override
	public User selectByNumberAndPassword(String number, String password) {
		return this.userDao.selectByNumberAndPassword(number, password);
	}

}

