package org.bigjava18.shop.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 用户实体类
 * @author zgp
 *
 */
//public class User implements Serializable{
public class User {
	
	private Integer uid;				//用户id
	private String username;			//用户名称
	private String password;			//用户密码
	private String name;				//用户真实姓名
	private String email;				//用户邮箱
	private String phone;				//用户号码
	private String sex;					//用户性别
	private String address;				//用户地址
	private Integer state;				//用户状态：state=0 用户未激活 state=1 用户已激活
	private String code;				//用户激活码
	
	//一个用户可以对应多个订单(用户和订单的关联关系为一对多)
	private Set<Order> orders=new HashSet<Order>();
	
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	//创建toString方法	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", sex=" + sex + ", address=" + address + ", state=" + state + ", code="
				+ code + "]";
	}
	
}
