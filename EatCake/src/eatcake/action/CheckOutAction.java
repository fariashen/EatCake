package eatcake.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.Orders;
import eatcake.service.OrderManager;

public class CheckOutAction extends ActionSupport implements 
	ModelDriven<Orders>,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private OrderManager orderManager;
	
	private Orders model;
	private Integer orderId;
	private Integer goodsId;
	
	private ActionContext actionContext = ActionContext.getContext();
	private Map<String, Object> session = actionContext.getSession();

	/**
	 * 购物车结算操作
	 * @return
	 */
	public String clearing(){
		if(goodsId != null && goodsId > 0){
			
			String userName = (String) session.get("userName");
			if(orderManager.generateOrder(goodsId,userName,model)){
				return SUCCESS;
			}
			
		}else {
			
			if(orderManager.generateOrder(session,model)){
				return SUCCESS;
			}
			
		}
		return ERROR;
	}
	
	public void prepareClearing(){
		model = new Orders();
	}
	
	/**
	 * “立即购买” 操作，转发到填写订单信息页面
	 * @return
	 */
	public String Immediately(){
		
		return "fillInOrder";
	}
	
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

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}
	
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	public void setModel(Orders model) {
		this.model = model;
	}

	@Override
	public void prepare() throws Exception {
	}

	@Override
	public Orders getModel() {
		return model;
	}
	
	
}
