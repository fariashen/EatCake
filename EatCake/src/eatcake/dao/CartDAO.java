package eatcake.dao;

import java.util.List;

import eatcake.model.Cart;

public interface CartDAO {

	/**
	 * 根据用户名获取对应的购物车记录列表
	 * @param userName
	 * @return
	 */
	public List<Cart> getCartByUserName(String userName);
	
	/**
	 * 根据商品编码和用户名获取对应的购物车记录
	 * @param goodsId
	 * @param userName
	 * @return
	 */
	public Cart getCartByGoodsIdAndUserNama(Integer goodsId,String userName);
	
	/**
	 * 保存购物车记录
	 * @param cart
	 * @return
	 */
	public Integer saveCartRecord(Cart cart);

	/**
	 * 删除购物车记录
	 * @param goodsId
	 * @param userName
	 */
	public void deleteCart(Integer goodsId,String userName);
	
	/**
	 * 保存或更新购物车记录
	 * @param cart
	 */
	public void saveOrUpdateRecord(Cart cart);

}
