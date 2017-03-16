package eatcake.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import eatcake.dao.GoodsDAO;
import eatcake.dao.OrderDAO;
import eatcake.model.Goods;
import eatcake.model.Order_Goods;
import eatcake.model.Orders;
import eatcake.service.OrderManager;

public class OrderManagerImpl implements OrderManager {

	@Autowired
	private OrderDAO orderDao;
	
	@Autowired
	private GoodsDAO goodsDao;
	
	@Override
	public Boolean checkOrder(String userName) {

		List<Orders> orderList = orderDao.getOrdersByUserName(userName);
		if(orderList == null){
			return false;
		}
		return true;
	}

	@Override
	public Boolean checkOrderDetail(Integer orderId) {

		try {
			List<Order_Goods> oG = orderDao.getOrderGoodsByOrderId(orderId);
			List<Goods> goodsList = null;
			for(Order_Goods orderGoods : oG){
				goodsList.add(orderGoods.getGoods());
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean generateOrder(Orders order) {

		try {
			orderDao.saveOrUpdateOrder(order);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean checkOut(Integer orderId) {

		try {
			Orders order = orderDao.getOrderByOrderId(orderId);
			order.setOrderStatus(1);
			orderDao.saveOrUpdateOrder(order);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
