package eatcake.dao.impl;

import org.hibernate.Query;

import eatcake.dao.OrderDAO;
import eatcake.model.Orders;

public class OrderDAOImpl extends BassDAOImpl implements OrderDAO {

	@Override
	public Boolean saveOrUpdateOrder(Orders order) {

		try {
			getSession().saveOrUpdate(order);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Orders getOrdersByUserName(String userName) {

		String hql = "FROM Order order "
				+ "WHERE order.creator.userName = ?";
		Query query = getSession().createQuery(hql)
				.setString(0, userName);
		
		return (Orders) query.uniqueResult();
	}

	@Override
	public Orders getOrderByOrderId(Integer orderId) {

		String hql = "From Order order "
				+ "WHERE order.orderId = ?";
		Query query = getSession().createQuery(hql)
				.setInteger(0, orderId);
		
		return (Orders) query.uniqueResult();
	}

}
