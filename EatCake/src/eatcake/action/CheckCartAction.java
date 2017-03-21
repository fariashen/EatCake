package eatcake.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.Cart;
import eatcake.model.Goods;
import eatcake.service.CartManager;
import eatcake.service.GoodsManager;

public class CheckCartAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Cart model;
	private String userName;
	private Integer goodsId;
	
	private CartManager cartManager;
	private GoodsManager goodsManager;
	
	private ActionContext actionContext = ActionContext.getContext();
	private Map<String, Object> request = (Map<String, Object>) actionContext.get("request");
	private Map<String, Object> session = actionContext.getSession();
	/**
	 * 查看简要购物车记录
	 * @return
	 */
	public String check(){
		if(cartManager.checkCartRecord(session,userName)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 查看购物车中的商品详情
	 * @return
	 */
	public String detail(){
		try {
			Goods goods = goodsManager.searchGoods(goodsId);
			request.put("goods", goods);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return "detail";
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Autowired
	public void setCartManager(CartManager cartManager) {
		this.cartManager = cartManager;
	}

	@Autowired
	public void setGoodsManager(GoodsManager goodsManager) {
		this.goodsManager = goodsManager;
	}
	
}
