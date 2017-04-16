package eatcake.action;

import java.util.Map;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
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
	
	private Integer orderId = null;
	
	private ActionContext actionContext = ActionContext.getContext();
	private Map<String, Object> session = actionContext.getSession();
	private Map<String, Object> request = (Map<String, Object>) actionContext.get("request");

	/**
	 * 查看用户的所有订单记录（简要）
	 * @return
	 */
	public String check(){
		
		if(orderManager.checkOrder(session,request)){
			return "brief";
		}
		return ERROR;
	}
	
	/**
	 * 查看某条订单记录的详情
	 * @return
	 */
	public String detail(){
		
		if(orderManager.checkOrderDetail(orderId, request)){
			return "detail";
		}
		return ERROR;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	
}
