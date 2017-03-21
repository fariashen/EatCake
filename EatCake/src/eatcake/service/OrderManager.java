package eatcake.service;

import java.util.Map;

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
	public Boolean generateOrder(Map<String, Object> session, Orders order);
	
	/**
	 * “立即购买”操作
	 * @param goodsId 商品编码
	 * @param userName 用户名
	 * @param orders 订单基本信息
	 * @return
	 */
	public boolean generateOrder(Integer goodsId, String userName, Orders orders);
	
	/**
	 * 支付订单操作
	 * @param orderId
	 * @return
	 */
	public Boolean checkOut(Integer orderId);
	
	/**
	 * 更新订单信息
	 * @param order
	 * @return
	 */
	public Boolean updateOrderInfo(Orders order);
	
	/**
	 * 删除订单记录
	 * @param order
	 * @return
	 */
	public Boolean deleteOrder(Integer orderId);

}
