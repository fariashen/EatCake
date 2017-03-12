package eatcake.service;

import eatcake.model.User;


public interface UserManager {

	public Boolean login(String userName,String passWord);
	public Boolean register(User user);
	public Boolean addUser(User user);
	public Boolean deleteUser(String userName);
}
