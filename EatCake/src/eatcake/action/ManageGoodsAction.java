package eatcake.action;

import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.Goods;
import eatcake.service.GoodsManager;
import eatcake.vo.GoodsVo;

public class ManageGoodsAction extends ActionSupport implements 
	ModelDriven<GoodsVo>,Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GoodsVo model;
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
	public String manage(){
		
		if(goodsManager.getAllGoodsInfo(requset)){
			return "manage";
		}
		return ERROR;
	}
	
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
		ServletContext servletContext = ServletActionContext.getServletContext();
		String dir = servletContext.getRealPath("/img/" + model.getImgFileName());
		int lastIndex = dir.lastIndexOf("\\");
		lastIndex -= 3;
		
		model.setGoodsImgPath(dir.substring(lastIndex).replace("\\", "/"));
		
		if(goodsManager.addGoodsRecord(model)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public void prepareAdd(){
		model = new GoodsVo();
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
			model = new GoodsVo(goodsManager.searchGoods(goodsId));
		}
	}
	/**
	 * 更新商品信息的操作
	 * @return
	 */
	public String update(){
		
		Goods goods = new Goods(model);
		if(goodsManager.changeGoodsInfo(goods)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public void prepareUpdate(){
		model = new GoodsVo();
	}

	@Override
	public GoodsVo getModel() {
		return model;
	}

	@Override
	public void prepare() throws Exception {
		
	}

}
