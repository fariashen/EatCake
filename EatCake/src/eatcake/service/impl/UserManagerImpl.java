package eatcake.service.impl;

import eatcake.dao.UserDAO;
import eatcake.model.User;
import eatcake.service.UserManager;

public class UserManagerImpl implements UserManager {

	private UserDAO userDao;	
	
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public Boolean login(String userName, String passWord) {

		Boolean loginFlag = false;
		User user = userDao.getUserByUserName(userName);
		if (user != null) {
			loginFlag = user.getPassWord().equals(passWord);
		}
		
		return loginFlag;
	}

	@Override
	public Boolean register(User user) {
		
		Boolean registerFlag = false;
		Integer userId = null;
		User userExist = userDao.getUserByUserName(user.getUserName());
		if (userExist == null) {			
			userId = userDao.save(user);
		}
		
		if(userId != null){
			registerFlag = true; 
		}
		return registerFlag;
	}

	@Override
	public Boolean addUser(User user) {
		return register(user);
	}

	@Override
	public Boolean deleteUser(String userName) {
		return userDao.deleteUserByUserName(userName);
	}

}
