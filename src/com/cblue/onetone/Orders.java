package com.cblue.onetone;

public class Orders {
	
	private int id;
	private int userid;
	private String number;
	private String createdate;
	private String node;
	
	private User user;
	
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
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", number=" + number
				+ ", createdate=" + createdate + ", node=" + node + "]";
	}
	
}
