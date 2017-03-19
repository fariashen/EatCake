package eatcake.action;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import eatcake.model.Goods;
import eatcake.service.GoodsManager;

public class RetrieveGoodsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GoodsManager goodsManager;
	
	private String goodsType;
	
	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> requset = (Map<String, Object>) actionContext.get("request");
	
	public String retrieve(){
		try {
			List<Goods> goodsList = goodsManager.searchGoods(goodsType);
			requset.put("goodsList", goodsList);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public void setGoodsManager(GoodsManager goodsManager) {
		this.goodsManager = goodsManager;
	}

}
