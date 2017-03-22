package eatcake.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext*.xml")
public class OrderManagerTest extends AbstractJUnit4SpringContextTests{

	private OrderManager orderManager;
	
	@Autowired
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	@Test
	public void testCheckOut(){
		orderManager.checkOut(8);
	}
	
	@Test
	public void testCheckOrder(){
		orderManager.checkOrder("test");
	}

}
