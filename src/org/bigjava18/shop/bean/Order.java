package org.bigjava18.shop.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * �û��Ķ���ʵ����
 * @author zgp
 *
 */
public class Order {
	
	private Integer oid;		//�û�������oid
	private Double total;		//�û��������ܼ�
	private Date ordertime;		//�û�������ʱ��
	private Integer state;		//�û�������״̬1:δ����   2:�����Ѿ�����   3:�Ѿ�����   4:��������
	private String name;		//�û��������û���
	private String phone;		//�û��������û�����
	private String address;		//�û��������û���ַ
	
	//���������uid(�û��Ͷ����Ĺ�����ϵ��һ�Զ�)
	private User user;
	
	//���ö�����(�����Ͷ�������һ�Զ�Ĺ�����ϵ)
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
