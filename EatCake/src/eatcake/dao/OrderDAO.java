package eatcake.dao;

import eatcake.model.Order;

public interface OrderDAO {

	public Boolean saveOrUpdateOrder(Order order);
	public Order getOrdersByUserName(String userName);
	public Order getOrderByOrderId(Integer orderId);
}
