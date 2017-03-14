package eatcake.service;

public interface CartManager {

	public Boolean addGoodsToCart(Integer goodsId,String userName);
	public Boolean checkCartRecord(String userName);
	
}
