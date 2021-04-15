package org.bigjava18.shop.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 二级分类实体类
 * @author zgp
 *
 */
public class CategorySecond implements Serializable{
	
	private Integer csid;		//一级分类的csid
	private String  csname;		//二级分类的名称
	
	//所属的一级分类:(一级分类和二级分类是一对多的关系)
	private Category category;
	
	//配置二级分类商品的集合:(二级分类和商品是一对多的关系)
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
