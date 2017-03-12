package eatcake.dao;

import eatcake.model.User;

public interface UserDAO {
	public User getUserByUserName(String userName);
	public Integer save(User user);
	public Boolean deleteUserByUserName(String userName);
}
