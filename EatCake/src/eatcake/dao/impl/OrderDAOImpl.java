package eatcake.dao.impl;

import org.hibernate.Query;

import eatcake.dao.OrderDAO;
import eatcake.model.Order;

public class OrderDAOImpl extends BassDAOImpl implements OrderDAO {

	@Override
	public Boolean saveOrUpdateOrder(Order order) {

		try {
			getSession().saveOrUpdate(order);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Order getOrdersByUserName(String userName) {

		String hql = "FROM Order order "
				+ "WHERE order.creator.userName = ?";
		Query query = getSession().createQuery(hql)
				.setString(0, userName);
		
		return (Order) query.uniqueResult();
	}

	@Override
	public Order getOrderByOrderId(Integer orderId) {

		String hql = "From Order order "
				+ "WHERE order.orderId = ?";
		Query query = getSession().createQuery(hql)
				.setInteger(0, orderId);
		
		return (Order) query.uniqueResult();
	}

}
