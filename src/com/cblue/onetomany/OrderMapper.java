package com.cblue.onetomany;

import java.util.List;

public interface OrderMapper {
	
	public List<Orders> findOrderAndOrderDetail();

}
