package eatcake.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.User;
import eatcake.service.UserManager;

public class LoginAction extends ActionSupport implements 
	ModelDriven<User>,Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User model;
	
	private UserManager userManager;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public String login() {
		
		if(userManager.login(model.getUserName(),model.getPassWord())){
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
	
}
