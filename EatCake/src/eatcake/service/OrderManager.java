package eatcake.service;

import eatcake.model.Orders;

public interface OrderManager {

	/**
	 * 用户查看所有订单记录
	 * @param userName
	 * @return
	 */
	public Boolean checkOrder(String userName);
	
	/**
	 * 用户根据订单编码查看订单记录详情
	 * @param orderId
	 * @return
	 */
	public Boolean checkOrderDetail(Integer orderId);
	
	/**
	 * 生成订单记录
	 * @param order
	 * @return
	 */
	public Boolean generateOrder(Orders order);
	
	/**
	 * 支付订单操作
	 * @param orderId
	 * @return
	 */
	public Boolean checkOut(Integer orderId);
}
