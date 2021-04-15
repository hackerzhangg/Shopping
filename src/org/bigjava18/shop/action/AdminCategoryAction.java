package org.bigjava18.shop.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.Category;
import org.bigjava18.shop.biz.CategoryBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台管理一级分类的Action
 * @author zgp
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	
	//创建Category实例对象
	private Category category=new Category();
	
	//使用模型驱动封装属性值
	@Override
	public Category getModel() {
		
		return category;
	}
	
	//在AdminCategoryAction中注入CategoryBiz
	private CategoryBiz categoryBiz;

	public void setCategoryBiz(CategoryBiz categoryBiz) {
		
		this.categoryBiz = categoryBiz;
	}
	
	/**
	 * 到一级分类的列表页面
	 * @return
	 */
	public String categoryListPage() {
		
		List<Category> categories =categoryBiz.findAll();
		
		//将查询的值放入到值栈中
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		return "categoryListPage";
	}
	
	/**
	 * 到修改一级分类的页面
	 * @return
	 */
	public String updateCategoryPage() {
		
		category=categoryBiz.findByCid(category.getCid());
		
		return "updateCategoryPage";
	}
	
	/**
	 * 更新一级分类
	 * @return
	 */
	public String updateCategory() {
		
		categoryBiz.updateCategory(category);
		
		return "updateCategory";
	}
	
	/**
	 * 到添加一级分类页面
	 * @return
	 */
	public String addCategoryPage() {
		
		return "addCategoryPage";
	}
	
	/**
	 * 添加一级分类
	 * @return
	 */
	public String addCategory() {
		
		categoryBiz.addCategory(category);
		
		return "addCategory";
	}
	
	/**
	 * 通过cid删除一级分类
	 * @return
	 */
	public String deleteCategory() {
		
		category=categoryBiz.findByCid(category.getCid());
		categoryBiz.deleteCategory(category);
		
		return "deleteCategory";
	}
	
	/**
	 * 通过一级分类名称模糊查询一级分类
	 * @return
	 */
	public String findCondition() {
		
		List<Category> categories=categoryBiz.findCondition(category);		
		System.out.println(categories);
		
		//将值放入值栈
		//ServletActionContext.getRequest().getSession().setAttribute("categories", categories);
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		return "findCondition";
	}

}
