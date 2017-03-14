package eatcake.service;

import eatcake.model.Order;

public interface OrderManager {

	public Boolean checkOrder(String userName);
	public Order checkOrderDetail(String orderId);
	public Boolean generateOrder(Order order);
	public Boolean checkOut(Integer orderId);
}
