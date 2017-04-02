package eatcake.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

import eatcake.model.User;
import eatcake.service.UserManager;

public class ManageUserAction extends ActionSupport implements 
	ModelDriven<User>,Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User model;
	
	private UserManager userManager;
	
	public void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}
	
	public String addUser(){
		
		if(userManager.addUser(model)){
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	public void prepareAddUser(){
		model = new User();
	}
	
	public String deleteUser(){
		
		if(userManager.deleteUser(model.getUserName())){
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	public void prepareDeleteUser(){
		model = new User();
	}
	
	@Override
	public void prepare() throws Exception {
	}

	@Override
	public User getModel() {
		return model;
	}

}
