package eatcake.service;

import eatcake.model.Orders;

public interface OrderManager {

	public Boolean checkOrder(String userName);
	public Orders checkOrderDetail(String orderId);
	public Boolean generateOrder(Orders order);
	public Boolean checkOut(Integer orderId);
}
