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
	public User selectUserByPrimaryKey(Integer userId) {
		return this.userDao.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> selectAllUser() {
		return userDao.selectAllUser();
	}
	
	@Override
	public List<User> selectAllUserByIdentity(String identity) {
		return userDao.selectAllUserByIdentity(identity);
	}
	
	@Override
	public List<User> selectAllUserExceptIdentity(String identity) {
		return userDao.selectAllUserExceptIdentity(identity);
	}
	
	/**
	 * insert user .
	 * @param user
	 */
	@Override
	public int insertUser(User user) {
		return this.userDao.insertSelective(user);
	}
	
	/**
	 * insert user .
	 * @param user
	 * @return 返回的并不是id,而是 0,1 = false,true
	 */
	@Override
	public int insertCacheId(User user) {
		return this.userDao.insertCacheId(user);
	}

	@Override
	public int updateByPrimaryKey(User user) {
		
		return this.userDao.updateByPrimaryKey(user);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return this.userDao.deleteByPrimaryKey(id);
	}
}
