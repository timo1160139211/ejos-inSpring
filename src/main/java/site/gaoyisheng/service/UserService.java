package site.gaoyisheng.service;

import java.util.List;
import java.util.Map;

import site.gaoyisheng.pojo.User;
import site.gaoyisheng.pojo.UserTeamForm;

public interface UserService {
	User selectUserByPrimaryKey(Integer userId);

	List<User> selectAllUser();
	
	List<User> selectByTeamId(Integer teamId);

	List<User> selectAllUserByIdentity(String identity);

	int insertUser(User user);

	int insertCacheId(User user);

	List<User> selectAllUserExceptIdentity(String identity);

	int updateByPrimaryKey(User user);
	
	int updateByPrimaryKeySelective(User user);
	
	int deleteByPrimaryKey(Integer id);
	
	List<UserTeamForm> selectByTeacherIdAndTeamId(Integer teacherId,Integer teamId);
}
