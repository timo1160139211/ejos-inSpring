package site.gaoyisheng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.gaoyisheng.dao.UserMapper;
import site.gaoyisheng.pojo.User;
import site.gaoyisheng.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userDao;

	/**
	 * select user by PK.
	 */
	@Override
	public User getUserByPrimaryKey(Integer userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> selectAllUser() {
		return userDao.selectAllUser();
	}
	
	@Override
	public List<User> selectAllUserGroupByIdentity(String identity) {
		return userDao.selectAllUserGroupByIdentity(identity);
	}
	
	/**
	 * insert user .
	 * @param user
	 */
	@Override
	public int insertUser(User user) {
		return this.userDao.insertSelective(user);
	}

}
