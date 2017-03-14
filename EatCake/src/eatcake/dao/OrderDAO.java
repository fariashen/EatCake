package eatcake.dao;

import eatcake.model.Orders;

public interface OrderDAO {

	public Boolean saveOrUpdateOrder(Orders order);
	public Orders getOrdersByUserName(String userName);
	public Orders getOrderByOrderId(Integer orderId);
}
