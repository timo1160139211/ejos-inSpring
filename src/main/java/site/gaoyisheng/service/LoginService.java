package site.gaoyisheng.service;

import site.gaoyisheng.pojo.User;

public interface LoginService {
	 public User selectByNumberAndPassword(String number, String password);  
}
