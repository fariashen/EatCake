package eatcake.service;

import java.util.List;
import java.util.Map;

import eatcake.model.Goods;

public interface GoodsManager {

	/**
	 * 实现增加商品的业务逻辑
	 * @param goods
	 * @return
	 */
	public Boolean addGoodsRecord(Goods goods);
	
	/**
	 * 根据商品编码删除商品记录
	 * @param goodsId
	 * @return
	 */
	public Boolean deleteGoodsRecord(Integer goodsId);
	
	/**
	 * 更新商品信息
	 * @param goods
	 * @return
	 */
	public Boolean changeGoodsInfo(Goods goods);
	
	/**
	 * 根据商品编码搜索商品
	 * @param goodsId
	 * @return
	 */
	public Goods searchGoods(Integer goodsId);
	
	/**
	 * 根据商品类型搜索商品列表
	 * @param goodsType
	 * @return
	 */
	public List<Goods> searchGoods(String goodsType);

	/**
	 * 查询所有商品记录，并放到request中
	 * @param requset
	 * @return
	 */
	public boolean getAllGoodsInfo(Map<String, Object> requset);
	
}
