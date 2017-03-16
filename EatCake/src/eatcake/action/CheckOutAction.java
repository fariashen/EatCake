package eatcake.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import eatcake.service.OrderManager;

public class CheckOutAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private OrderManager orderManager;
	
	private Integer orderId;

	/**
	 * 订单付款操作
	 * @return
	 */
	public String checkOut(){
		if(orderManager.checkOut(orderId)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	
}
