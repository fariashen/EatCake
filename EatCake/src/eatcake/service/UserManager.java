package eatcake.service;

import eatcake.model.User;


public interface UserManager {

	/**
	 * 实现登录操作
	 * @param userName
	 * @param passWord
	 * @return
	 */
	public Boolean login(String userName,String passWord);
	
	/**
	 * 实现注册操作
	 * @param user
	 * @return
	 */
	public Boolean register(User user);
	
	/**
	 * 实现用户记录的添加操作
	 * @param user
	 * @return
	 */
	public Boolean addUser(User user);
	
	/**
	 * 实现用户记录的删除操作
	 * @param userName
	 * @return
	 */
	public Boolean deleteUser(String userName);
}
