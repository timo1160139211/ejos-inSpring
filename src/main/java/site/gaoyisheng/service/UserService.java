package site.gaoyisheng.service;

import java.util.List;

import site.gaoyisheng.pojo.User;

public interface UserService {
	User getUserByPrimaryKey(Integer userId);

	List<User> selectAllUser();

	List<User> selectAllUserByIdentity(String identity);

	int insertUser(User record);

	int insertCacheId(User record);

	List<User> selectAllUserExceptIdentity(String identity);
}
