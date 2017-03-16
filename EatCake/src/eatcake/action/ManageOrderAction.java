package eatcake.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.Orders;
import eatcake.service.OrderManager;

public class ManageOrderAction extends ActionSupport implements
		ModelDriven<Orders>, Preparable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Orders model;
	@Autowired
	private OrderManager orderManager;
	
	/**
	 * 更新订单信息
	 * @return
	 */
	public String update(){
		
		if(orderManager.updateOrderInfo(model)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 删除订单信息
	 * @return
	 */
	public String delete() {
		
		if(orderManager.deleteOrder(model.getOrderId())){
			return SUCCESS;
		}
		return ERROR;
	}
	
	@Override
	public void prepare() throws Exception {
		model = new Orders();
	}

	@Override
	public Orders getModel() {
		return model;
	}

}
