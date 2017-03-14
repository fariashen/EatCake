package eatcake.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateModelTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void before(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
	}
	
	@After
	public void after(){
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void test() {
		
		Goods goods = new Goods();
		Orders order = new Orders();
		Order_Goods orderGoods= new Order_Goods();
		User user = (User) session.load(User.class, 1);
		
		goods.setGoodsName("testGoods1");
		order.setCreator(user);
		orderGoods.setNum(1);
		orderGoods.setGoods(goods);
		orderGoods.setOrder(order);
		
		session.save(order);
		session.save(goods);
		session.save(orderGoods);
	}

}
