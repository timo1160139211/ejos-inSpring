package site.gaoyisheng.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.gaoyisheng.dao.UserMapper;
import site.gaoyisheng.pojo.User;
import site.gaoyisheng.service.UserService;

@Service("userService")  
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userDao; 
    
	@Override
	public User getUserByPrimaryKey(Integer userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

}
