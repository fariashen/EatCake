package eatcake.dao.impl;


import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import eatcake.dao.UserDAO;
import eatcake.model.User;

@Repository
public class UserDAOImpl extends BassDAOImpl implements UserDAO {

	@Override
	public User getUserByUserName(String userName) {
		String hql = "FROM User u WHERE u.userName = ?";
		Query query = getSession().createQuery(hql).setString(0, userName);
		return (User) query.uniqueResult();
	}

	@Override
	public Integer save(User user) {
		return (Integer) getSession().save(user);
	}
	
	@Override
	public Boolean deleteUserByUserName(String userName) {
		String hql = "DELETE User u WHERE u.userName = ?";
		int deleteNum = getSession().createQuery(hql).setString(0, userName).executeUpdate();
		
		if (deleteNum == 0) {
			return false;
		}
		return true;
	}


}
