package eatcake.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.Goods;
import eatcake.service.GoodsManager;

public class ManageGoodsAction extends ActionSupport implements 
	ModelDriven<Goods>,Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Goods model;
	private GoodsManager goodsManager;
	private Integer goodsId;
	
	
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	@Autowired
	public void setGoodsManager(GoodsManager goodsManager) {
		this.goodsManager = goodsManager;
	}

	ActionContext actionContext = ActionContext.getContext();
	Map<String, Object> requset = (Map<String, Object>) actionContext.get("request");
	
	/**
	 * 展示所有商品记录
	 * @return
	 */
	public String list(){
		
		if(goodsManager.getAllGoodsInfo(requset)){
			return "list";
		}
		return ERROR;
	}
	
	/**
	 * 增加商品记录的操作
	 * @return
	 */
	public String add(){
		
		if(goodsManager.addGoodsRecord(model)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public void prepareAdd(){
		model = new Goods();
	}
	
	/**
	 * 删除商品记录的操作
	 * @return
	 */
	public String delete(){
		
		if(goodsManager.deleteGoodsRecord(goodsId)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 跳转到更新商品信息页面
	 * @return
	 */
	public String toUpdate(){
		return "update";
	}
	
	public void prepareToUpdate(){
		if(goodsId != null){
			model = goodsManager.searchGoods(goodsId);
		}
	}
	/**
	 * 更新商品信息的操作
	 * @return
	 */
	public String update(){
		
		System.out.println(model.toString());
		if(goodsManager.changeGoodsInfo(model)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public void prepareUpdate(){
		model = new Goods();
	}

	@Override
	public Goods getModel() {
		return model;
	}

	@Override
	public void prepare() throws Exception {
		
	}

}
