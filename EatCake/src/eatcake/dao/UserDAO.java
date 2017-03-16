package eatcake.dao;

import eatcake.model.User;

public interface UserDAO {
	/**
	 * 根据用户名获取用户记录
	 * @param userName
	 * @return
	 */
	public User getUserByUserName(String userName);
	
	/**
	 * 保存用户记录
	 * @param user
	 * @return
	 */
	public Integer save(User user);
	
	/**
	 * 根据用户名删除用户记录
	 * @param userName
	 * @return
	 */
	public Boolean deleteUserByUserName(String userName);
}
