package eatcake.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eatcake.dao.GoodsDAO;
import eatcake.model.Goods;
import eatcake.service.GoodsManager;

@Service
public class GoodsManagerImpl implements GoodsManager {

	@Autowired
	private GoodsDAO goodsDao;
	
	@Override
	public Boolean addGoodsRecord(Goods goods) {

		try {
			Goods existGoods = goodsDao.getGoodsByGoodsId(goods.getGoodsId());
			if(existGoods == null){
				goodsDao.saveOrUpdateGoodsInfo(goods);
			}
		} catch (Exception e) {
			return false;
		}
		
		return true;
	}

	@Override
	public Boolean deleteGoodsRecord(Integer goodsId) {
		try {
			goodsDao.deleteGoods(goodsDao.getGoodsByGoodsId(goodsId));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Boolean changeGoodsInfo(Goods goods) {

		try {
			goodsDao.saveOrUpdateGoodsInfo(goods);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public Goods searchGoods(Integer goodsId) {

		return goodsDao.getGoodsByGoodsId(goodsId);
	}

	@Override
	public List<Goods> searchGoods(String goodsType) {

		return goodsDao.getGoodsByCategory(goodsType);
	}

	@Override
	public boolean getAllGoodsInfo(Map<String, Object> requset) {

		try {
			requset.put("goodsList", goodsDao.getAllGoods());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
