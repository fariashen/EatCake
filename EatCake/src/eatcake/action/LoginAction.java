package eatcake.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.User;
import eatcake.service.CartManager;
import eatcake.service.GoodsManager;
import eatcake.service.OrderManager;
import eatcake.service.UserManager;

public class LoginAction extends ActionSupport implements 
	ModelDriven<User>,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User model;
	
	private UserManager userManager;
	private GoodsManager goodsManager;
	private CartManager cartManager;
	private OrderManager orderManager;
	
	private ActionContext actionContext = ActionContext.getContext();
	private Map<String, Object> session = actionContext.getSession();
	private Map<String, Object> request = (Map<String, Object>) actionContext.get("request");
	
	public String login() {
		
		if(userManager.login(model.getUserName(),model.getPassWord())){
			session.put("userName", model.getUserName());
			
			//进入personal.jsp前获取所有商品信息，获取用户购物车信息，获取用户订单信息
			goodsManager.getAllGoodsInfo(request);
			cartManager.checkCartRecord(session, model.getUserName());
			orderManager.checkOrder(session, request);
			
			return SUCCESS;
		}
		
		return ERROR;
	}

	public void prepareLogin(){
		model = new User();
	}
	
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return model;
	}
	
	@Autowired
	public void setOrderManager(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	@Autowired
	public void setGoodsManager(GoodsManager goodsManager) {
		this.goodsManager = goodsManager;
	}

	@Autowired
	public void setCartManager(CartManager cartManager) {
		this.cartManager = cartManager;
	}

	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
}
