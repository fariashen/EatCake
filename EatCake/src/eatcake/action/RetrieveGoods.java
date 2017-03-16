package eatcake.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import eatcake.model.Goods;
import eatcake.service.GoodsManager;

public class RetrieveGoods extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GoodsManager goodsManager;
	
	private String goodsType;

	private String retrieve(){
		try {
			List<Goods> goodsList = goodsManager.searchGoods(goodsType);
		} catch (Exception e) {
			return ERROR;
		}
		return SUCCESS;
	}
	
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

}
