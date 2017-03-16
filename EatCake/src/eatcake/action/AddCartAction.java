package eatcake.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.Cart;
import eatcake.service.CartManager;

public class AddCartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer goodsId = null;
	private String userName = null;
	
	@Autowired
	private CartManager cartManager;
	
	/**
	 * 增加用户购物车记录
	 * @return
	 */
	public String add(){
		if(cartManager.addGoodsToCart(goodsId, userName)){
			return SUCCESS;
		}
		return ERROR;
	}

	
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
