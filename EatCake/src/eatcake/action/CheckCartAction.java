package eatcake.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.Cart;
import eatcake.service.CartManager;

public class CheckCartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cart model;
	private String userName;
	
	@Autowired
	private CartManager cartManager;
	
	/**
	 * 查看简要购物车记录
	 * @return
	 */
	public String check(){
		if(cartManager.checkCartRecord(userName)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 查看购物车中的商品详情
	 * @return
	 */
	public String detail(){
		//TODO
		return ERROR;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
