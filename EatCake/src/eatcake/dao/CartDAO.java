package eatcake.dao;

import java.util.List;

import eatcake.model.Cart;

public interface CartDAO {

	public List<Cart> getCartByUserName(String userName);
	public Cart getCartByGoodsIdAndUserNama(Integer goodsId,String userName);
	public Integer saveCartRecord(Cart cart);
}
