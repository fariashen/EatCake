package eatcake.action;

import org.springframework.beans.factory.annotation.Autowired;

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
	@Autowired
	private GoodsManager goodsManager;
	
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
	
	/**
	 * 删除商品记录的操作
	 * @return
	 */
	public String delete(){
		
		if(goodsManager.deleteGoodsRecord(model.getGoodsId())){
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 更新商品信息的操作
	 * @return
	 */
	public String update(){
		
		if(goodsManager.changeGoodsInfo(model)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	@Override
	public void prepare() throws Exception {	}

	@Override
	public Goods getModel() {
		return model;
	}

}
