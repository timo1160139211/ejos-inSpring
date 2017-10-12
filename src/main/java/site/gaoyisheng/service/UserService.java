package site.gaoyisheng.service;

import java.util.List;

import site.gaoyisheng.pojo.User;

public interface UserService {
	User selectUserByPrimaryKey(Integer userId);

	List<User> selectAllUser();

	List<User> selectAllUserByIdentity(String identity);

	int insertUser(User record);

	int insertCacheId(User record);

	List<User> selectAllUserExceptIdentity(String identity);

	int updateByPrimaryKey(User record);
	
	int deleteByPrimaryKey(Integer id);
}
