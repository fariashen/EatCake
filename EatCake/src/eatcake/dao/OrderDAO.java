package eatcake.dao;

import java.util.List;

import eatcake.model.Order_Goods;
import eatcake.model.Orders;

public interface OrderDAO {

	/**
	 * 保存或更新订单信息
	 * @param order
	 * @return
	 */
	public Boolean saveOrUpdateOrder(Orders order);
	
	/**
	 * 保存或更新订单与商品的关联关系
	 * @param orderGoods
	 * @return
	 */
	public Boolean saveOrUpdateOrderGoods(Order_Goods orderGoods);
	
	/**
	 * 删除订单记录
	 * @param order
	 * @return
	 */
	public Boolean deleteOrder(Orders order);
	
	/**
	 * 根据用户名获取订单记录
	 * @param userName
	 * @return
	 */
	public List<Orders> getOrdersByUserName(String userName);
	
	/**
	 * 根据订单编码获取订单记录
	 * @param orderId
	 * @return
	 */
	public Orders getOrderByOrderId(Integer orderId);
	
	/**
	 * 根据订单编码获取与订单有关联的商品记录
	 * @param orderId
	 * @return
	 */
	public List<Order_Goods> getOrderGoodsByOrderId(Integer orderId);
}
