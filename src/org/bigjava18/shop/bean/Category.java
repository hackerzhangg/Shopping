package org.bigjava18.shop.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 一级分类实体类对象
 * @author zgp
 *
 */
public class Category implements Serializable{
	
	private Integer cid;		//一级分类的cid
	private String cname;		//一级分类的名称
	
	//在一级分类中存放二级分类的集合(一级分类和二级分类为一对多的关系)
	private Set<CategorySecond> categorySeconds=new HashSet<CategorySecond>();
	
	//创建set/get方法
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
	
	//创建toString方法
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}
	
}
