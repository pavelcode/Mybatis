package com.cblue.manytomany;

import java.util.List;

public class Orders {
	
	private int id;
	private int userid;
	private String number;
	private String createdate;
	private String node;
	
	private List<OrderDetail> orderDetails;
	
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCreatedate() {
		return createdate;
	}
	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}
	public String getNode() {
		return node;
	}
	public void setNode(String node) {
		this.node = node;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", userid=" + userid + ", number=" + number
				+ ", createdate=" + createdate + ", node=" + node + "]";
	}
	
	
}
