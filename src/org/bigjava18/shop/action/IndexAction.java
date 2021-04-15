package org.bigjava18.shop.action;

import java.util.List;

import org.bigjava18.shop.bean.Category;
import org.bigjava18.shop.bean.Product;
import org.bigjava18.shop.biz.CategoryBiz;
import org.bigjava18.shop.biz.ProductBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户首页访问的Action
 * @author zgp
 *
 */
public class IndexAction extends ActionSupport{
	
	//在IndexAction中注入CategoryBiz
	private CategoryBiz categoryBiz;
	
	//创建CategoryBiz的set方法
	public void setCategoryBiz(CategoryBiz categoryBiz) {
		
		this.categoryBiz = categoryBiz;
	}
	
	//在IndexAction中注入ProductBiz
	private ProductBiz productBiz;
	
	//创建ProductBiz的set方法
	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}

	/**
	 * 到用户首页的action
	 * @return
	 */
	public String execute() {
		
		//查询所有一级分类的集合
		List<Category> cList=categoryBiz.findAll();
		//将查询的一级分类保存到Session
		ActionContext.getContext().getSession().put("cList", cList);
		
		//查询热门商品
		List<Product> hotList=productBiz.findHot();
		//将热门商品保存到值栈中
		ActionContext.getContext().getValueStack().set("hotList", hotList);
		
		//查询最新商品
		List<Product> newList=productBiz.findNew();
		System.out.println("最新商品:"+newList);
		//就最新商品保存到值栈中
		ActionContext.getContext().getValueStack().set("newList", newList);
		
		//System.out.println("到商城首页");
		return "index";
	}

}
