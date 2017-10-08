package site.gaoyisheng.service;

import java.util.List;

import site.gaoyisheng.pojo.User;

public interface UserService {
	public User getUserByPrimaryKey(Integer userId);

	public List<User> selectAllUser();
	public List<User> selectAllUserGroupByIdentity(String identity);
	
	int insertUser(User record);
}
