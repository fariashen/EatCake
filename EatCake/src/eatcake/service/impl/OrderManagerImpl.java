package eatcake.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eatcake.dao.CartDAO;
import eatcake.dao.GoodsDAO;
import eatcake.dao.OrderDAO;
import eatcake.dao.UserDAO;
import eatcake.model.Goods;
import eatcake.model.Order_Goods;
import eatcake.model.Orders;
import eatcake.model.User;
import eatcake.service.OrderManager;
import eatcake.vo.CartVO;

@Service
public class OrderManagerImpl implements OrderManager {

	@Autowired
	private OrderDAO orderDao;
	@Autowired
	private GoodsDAO goodsDao;
	@Autowired
	private UserDAO userDao;
	@Autowired
	private CartDAO cartDao;
	
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
	public Boolean generateOrder(Map<String, Object>session, Orders order) {

		try {
			List<CartVO> cartVoList = (List<CartVO>) session.get("cartVoList");
			
			CartVO firstCartVo = cartVoList.get(0);
			//保存订单信息
			User creator = userDao.getUserByUserName(firstCartVo.getUserName());
			order.setCreator(creator);
			order.setOrderStatus(0);
			orderDao.saveOrUpdateOrder(order);
			
			for(CartVO cartVo : cartVoList){
				
				//保存订单和商品的关联关系
				Order_Goods oG = new Order_Goods();
				Goods goods = goodsDao.getGoodsByGoodsId(cartVo.getGoodsId());
				oG.setGoods(goods);
				oG.setNum(cartVo.getNum());
				oG.setOrder(order);
				orderDao.saveOrUpdateOrderGoods(oG);
				
				//清空购物车记录
				cartDao.deleteCart(cartVo.getUserName());
			}
			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	@Override
	public boolean generateOrder(Integer goodsId, Map<String, Object> session, Orders order) {
		
		try {
			
			Goods goods = goodsDao.getGoodsByGoodsId(goodsId);
			session.put("checkOutGoods", goods);
			String userName = (String) session.get("userName");
			User creator = userDao.getUserByUserName(userName);
			order.setCreator(creator);
			order.setOrderStatus(0);
			orderDao.saveOrUpdateOrder(order);
			
			Order_Goods oG = new Order_Goods();
			oG.setGoods(goods);
			oG.setNum(1);
			oG.setOrder(order);
			orderDao.saveOrUpdateOrderGoods(oG);
			
		} catch (Exception e) {
			e.printStackTrace();
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

	@Override
	public Boolean updateOrderInfo(Orders order) {

		if(orderDao.saveOrUpdateOrder(order)){
			return true;
		}
		return false;
	}

	@Override
	public Boolean deleteOrder(Integer orderId) {

		Orders order = orderDao.getOrderByOrderId(orderId);
		if(orderDao.deleteOrder(order)){
			return true;
		}
		return false;
	}

	

}
