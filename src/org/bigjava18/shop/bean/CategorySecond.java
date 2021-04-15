package org.bigjava18.shop.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ��������ʵ����
 * @author zgp
 *
 */
public class CategorySecond implements Serializable{
	
	private Integer csid;		//һ�������csid
	private String  csname;		//�������������
	
	//������һ������:(һ������Ͷ���������һ�Զ�Ĺ�ϵ)
	private Category category;
	
	//���ö���������Ʒ�ļ���:(�����������Ʒ��һ�Զ�Ĺ�ϵ)
	private Set<Product> products=new HashSet<Product>();
	
	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Integer getCsid() {
		return csid;
	}

	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	public String getCsname() {
		return csname;
	}

	public void setCsname(String csname) {
		this.csname = csname;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "CategorySecond [csid=" + csid + ", csname=" + csname + ", category=" + category + "]";
	}
	
}
