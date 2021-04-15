package org.bigjava18.shop.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户的订单实体类
 * @author zgp
 *
 */
public class Order {
	
	private Integer oid;		//用户订单的oid
	private Double total;		//用户订单的总价
	private Date ordertime;		//用户订单的时间
	private Integer state;		//用户订单的状态1:未付款   2:订单已经付款   3:已经发货   4:订单结束
	private String name;		//用户订单的用户名
	private String phone;		//用户订单的用户号码
	private String address;		//用户订单的用户地址
	
	//订单的外键uid(用户和订单的关联关系是一对多)
	private User user;
	
	//配置订单项(订单和订单项是一对多的关联关系)
	private Set<OrderItem> orderItems=new HashSet<OrderItem>();

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", name="
				+ name + ", phone=" + phone + ", address=" + address + "]";
	}
	
}
