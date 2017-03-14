package eatcake.dao;

import eatcake.model.Cart;

public interface CartDAO {

	public Cart getCartByUserName(String userName);
	public Cart getCartByGoodsIdAndUserNama(Integer goodsId,String userName);
	public Integer saveCartRecord(Cart cart);
}
