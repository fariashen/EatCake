package eatcake.dao;

import eatcake.model.Goods;

public interface GoodsDAO {

	public Goods getGoodsByGoodsId(Integer goodsId);
	public Boolean saveOrUpdateGoodsInfo(Goods goods);
	public Boolean deleteGoods(Goods goods);
	public Goods getGoodsByCategory(String goodsType);
}
