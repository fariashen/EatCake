package eatcake.model;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateModelTest {

	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;

	@Before
	public void before(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
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
		Order order = new Order();
		Order_Goods orderGoods= new Order_Goods();
		User user = (User) session.load(User.class, 1);
		
		goods.setGoodsName("testGoods1");
		order.setCreator(user);
		orderGoods.setNum(1);
		orderGoods.setGoods(goods);
		orderGoods.setOrder(order);
	}

}
