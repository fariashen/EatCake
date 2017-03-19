package eatcake.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eatcake.model.Goods;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext*.xml")
public class GoodsDAOTest extends AbstractJUnit4SpringContextTests{

	private GoodsDAO goodsDao;
	
	@Autowired
	public void setGoodsDao(GoodsDAO goodsDao) {
		this.goodsDao = goodsDao;
	}

	@Test
	public void testGetGoodsByGoodsId(){

		/*
		Goods goods = new Goods();
		
		goods.setGoodsId(111);
		goods.setGoodsName("testAdd");
		goods.setGoodsBrief("testAdd");
		goods.setGoodsDetail("testAdd");
		goods.setGoodsImgPath("testAdd");
		goods.setGoodsPrice(1.1);
		goods.setGoodsType("testAdd");	
		
		goodsDao.getGoodsByGoodsId(goods.getGoodsId());
		*/
		Goods goods = goodsDao.getGoodsByGoodsId(111);
		System.out.println(goods.getGoodsName());
		
	}
	
	@Test
	public void testSaveOrUpdateGoodsInfo() {
		/*
		Goods goods = new Goods();
		
		goods.setGoodsId(111);
		goods.setGoodsName("testAdd2");
		goods.setGoodsBrief("testAdd2");
		goods.setGoodsDetail("testAdd2");
		goods.setGoodsImgPath("testAdd2");
		goods.setGoodsPrice(21.1);
		goods.setGoodsType("testAdd2");	
		
		goodsDao.saveOrUpdateGoodsInfo(goods);
		*/
		
		Goods goods = goodsDao.getGoodsByGoodsId(111);
		goods.setGoodsName("testUpdate");
		goods.setGoodsDetail("testUpdate");
		
		goodsDao.saveOrUpdateGoodsInfo(goods);
	}

}
