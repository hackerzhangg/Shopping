package org.bigjava18.shop.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * �û�ʵ����
 * @author zgp
 *
 */
//public class User implements Serializable{
public class User {
	
	private Integer uid;				//�û�id
	private String username;			//�û�����
	private String password;			//�û�����
	private String name;				//�û���ʵ����
	private String email;				//�û�����
	private String phone;				//�û�����
	private String sex;					//�û��Ա�
	private String address;				//�û���ַ
	private Integer state;				//�û�״̬��state=0 �û�δ���� state=1 �û��Ѽ���
	private String code;				//�û�������
	
	//һ���û����Զ�Ӧ�������(�û��Ͷ����Ĺ�����ϵΪһ�Զ�)
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
	
	//����toString����	
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", name=" + name + ", email="
				+ email + ", phone=" + phone + ", sex=" + sex + ", address=" + address + ", state=" + state + ", code="
				+ code + "]";
	}
	
}
