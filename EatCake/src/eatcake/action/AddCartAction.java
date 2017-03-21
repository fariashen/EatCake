package eatcake.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
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
	
	private ActionContext actionContext = ActionContext.getContext();
	private Map<String, Object> request = (Map<String, Object>) actionContext.get("request"); 
	/**
	 * 增加用户购物车记录
	 * @return
	 */
	public String addCart(){
		if(cartManager.addGoodsToCart(request, goodsId, userName)){
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

	public void setCartManager(CartManager cartManager) {
		this.cartManager = cartManager;
	}
	
	
}
