package eatcake.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eatcake.model.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext*.xml")
public class OrdersDAOTest extends AbstractJUnit4SpringContextTests{

	private OrderDAO orderDao;

	@Autowired
	public void setOrderDao(OrderDAO orderDao) {
		this.orderDao = orderDao;
	}

	@Test
	public void testGetOrderByOrderId(){
		Orders order = orderDao.getOrderByOrderId(8);
		System.out.println(order.getAddress());
	}
}
