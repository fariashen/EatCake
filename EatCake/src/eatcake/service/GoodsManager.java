package eatcake.service;

import eatcake.model.Goods;

public interface GoodsManager {

	public Boolean addGoodsRecord(Goods goods);
	public Boolean deleteGoodsRecord(Integer goodsId);
	public Boolean changeGoodsInfo(Goods goods);
	public Goods searchGoods(Integer goodsId);
	public Goods searchGoods(String GoodsType);
	
}
