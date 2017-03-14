package eatcake.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import eatcake.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext*.xml")
public class DaoTest extends AbstractJUnit4SpringContextTests{

	@Autowired
	private UserDAO userDao;
	
	@Test
	public void test() {

		User user = new User();
		user.setUserName("SecondTransactionTest");
		user.setPassWord("SecondTransactionTest");
		
		userDao.save(user);
	}

}
