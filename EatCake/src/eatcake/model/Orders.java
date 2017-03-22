package eatcake.model;


public class Orders {

	/**
	 * 订单编码
	 */
	private Integer orderId;
	
	/**
	 * 收货地址
	 */
	private String address;
	
	/**
	 * 联系电话
	 */
	private String phone;
	
	/**
	 * 支付状态（1：已支付 0：未支付）
	 */
	private Integer orderStatus;
	
	/**
	 * 创建用户
	 */
	private User creator;
	
	
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}

	
}
