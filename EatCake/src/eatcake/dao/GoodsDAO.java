package eatcake.dao;

import java.util.List;

import eatcake.model.Goods;

public interface GoodsDAO {

	/**
	 * 根据 商品编码 获取指定商品
	 * @param goodsId
	 * @return
	 */
	public Goods getGoodsByGoodsId(Integer goodsId);
	
	/**
	 * 保存或更新指定商品
	 * @param goods
	 * @return
	 */
	public Boolean saveOrUpdateGoodsInfo(Goods goods);
	
	/**
	 * 删除指定商品信息
	 * @param goods
	 * @return
	 */
	public Boolean deleteGoods(Goods goods);
	
	/**
	 * 根据商品类型获取商品列表
	 * @param goodsType
	 * @return
	 */
	public List<Goods> getGoodsByCategory(String goodsType);

	/**
	 * 获取所有的商品记录信息
	 * @return
	 */
	public List<Goods> getAllGoods();
}
