package eatcake.service;

import java.util.Map;

public interface CartManager {

	/**
	 * 增加购物车记录
	 * @param goodsId
	 * @param userName
	 * @return
	 */
	public Boolean addGoodsToCart(Map<String, Object> request,Integer goodsId,String userName);
	
	/**
	 * 根据用户名查询购物车记录
	 * @param userName
	 * @return
	 */
	public Boolean checkCartRecord(Map<String, Object> session, String userName);
	
}
