package eatcake.service;

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
public class GoodsManagerTest extends AbstractJUnit4SpringContextTests {

	private GoodsManager goodsManager;
	
	@Autowired
	public void setGoodsManager(GoodsManager goodsManager) {
		this.goodsManager = goodsManager;
	}


	@Test
	public void testAddGoodsRecord() {
		Goods goods = new Goods();
		
		goods.setGoodsId(33);
		goods.setGoodsName("testAdd3");
		goods.setGoodsBrief("testAdd3");
		goods.setGoodsDetail("testAdd3");
		goods.setGoodsImgPath("testAdd3");
		goods.setGoodsPrice(31.1);
		goods.setGoodsType("testAdd3");
		
		goodsManager.addGoodsRecord(goods);
	}

}
