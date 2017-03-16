package eatcake.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import eatcake.model.Orders;
import eatcake.service.OrderManager;

public class CheckOrderAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private OrderManager orderManager;
	
	private String userName = null;
	private Integer orderId = null;
	
	/**
	 * 查看用户的所有订单记录（简要）
	 * @return
	 */
	private String check(){
		
		if(orderManager.checkOrder(userName)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	/**
	 * 查看某条订单记录的详情
	 * @return
	 */
	private String detail(){
		
		if(orderManager.checkOrderDetail(orderId)){
			return SUCCESS;
		}
		return ERROR;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	
}
