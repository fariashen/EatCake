package eatcake.service.impl;

import java.util.ArrayList;
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
import eatcake.vo.OrdersVO;

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
	public boolean checkOrder(Map<String, Object> session, Map<String, Object> request) {

		try {
			String userName = (String) session.get("userName");
			List<Orders> orderList = orderDao.getOrdersByUserName(userName);
			//orders的值对象列表
			List<OrdersVO> orderVoList = new ArrayList<OrdersVO>();
			
			if(orderList != null){
				//为orders的值对象列表赋值
				for(Orders order : orderList){
					OrdersVO ordersVo = new OrdersVO();
					
					ordersVo.setAddress(order.getAddress());
					ordersVo.setOrderId(order.getOrderId());
					ordersVo.setPhone(order.getPhone());
					if (order.getOrderStatus() == 1) {
						ordersVo.setOrderStatus("已支付");
					}else {
						ordersVo.setOrderStatus("未支付");
					}
					
					orderVoList.add(ordersVo);
				}
			}
			request.put("orderVoList", orderVoList);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Boolean checkOrderDetail(Integer orderId, Map<String, Object> request) {

		try {
			Orders order = orderDao.getOrderByOrderId(orderId);
			List<Order_Goods> oG = orderDao.getOrderGoodsByOrderId(orderId);
			
			//设置Order值对象
			OrdersVO orderVo = new OrdersVO();
			orderVo.setAddress(order.getAddress());
			orderVo.setOrderId(order.getOrderId());
			orderVo.setPhone(order.getPhone());
			if(order.getOrderStatus() == 1){
				orderVo.setOrderStatus("已支付");
			}else {
				orderVo.setOrderStatus("未支付");
			}
			//将值对象放置在请求域中
			request.put("orderVo", orderVo);
			
			//新建商品展示信息列表
			List<Goods> goodsList = new ArrayList<Goods>();
			for(Order_Goods orderGoods : oG){
				Goods goods = new Goods();
				Goods ogGoods = orderGoods.getGoods();
				goods.setGoodsBrief(ogGoods.getGoodsBrief());
				goods.setGoodsDetail(ogGoods.getGoodsDetail());
				goods.setGoodsId(ogGoods.getGoodsId());
				goods.setGoodsImgPath(ogGoods.getGoodsImgPath());
				goods.setGoodsName(ogGoods.getGoodsName());
				goods.setGoodsPrice(ogGoods.getGoodsPrice());
				goods.setGoodsType(ogGoods.getGoodsType());
				
				goodsList.add(goods);
			}
			//将值对象放置在请求域中
			request.put("orderGoodsList", goodsList);
			
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
