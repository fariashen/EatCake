package eatcake.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import eatcake.dao.OrderDAO;
import eatcake.model.Order_Goods;
import eatcake.model.Orders;

@Repository
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
	public List<Orders> getOrdersByUserName(String userName) {

		String hql = "FROM Order order "
				+ "WHERE order.creator.userName = ?";
		Query query = getSession().createQuery(hql)
				.setString(0, userName);
		
		return query.list();
	}

	@Override
	public Orders getOrderByOrderId(Integer orderId) {

		String hql = "From Order order "
				+ "WHERE order.orderId = ?";
		Query query = getSession().createQuery(hql)
				.setInteger(0, orderId);
		
		return (Orders) query.uniqueResult();
	}

	@Override
	public List<Order_Goods> getOrderGoodsByOrderId(Integer orderId) {

		String hql = "FROM Order_Goods oG "
				+ "WHERE oG.order.orderId = ?";
		Query query = getSession().createQuery(hql)
				.setInteger(0, orderId);
		
		return query.list();
	}

	@Override
	public Boolean deleteOrder(Orders order) {

		try {
			getSession().delete(order);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	
}
