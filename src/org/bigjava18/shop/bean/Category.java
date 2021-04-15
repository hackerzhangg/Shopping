package org.bigjava18.shop.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * һ������ʵ�������
 * @author zgp
 *
 */
public class Category implements Serializable{
	
	private Integer cid;		//һ�������cid
	private String cname;		//һ�����������
	
	//��һ�������д�Ŷ�������ļ���(һ������Ͷ�������Ϊһ�Զ�Ĺ�ϵ)
	private Set<CategorySecond> categorySeconds=new HashSet<CategorySecond>();
	
	//����set/get����
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}
	
	//����toString����
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
