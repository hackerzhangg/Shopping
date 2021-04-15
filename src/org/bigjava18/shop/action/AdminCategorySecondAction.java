package org.bigjava18.shop.action;

import java.util.List;

import javax.servlet.ServletContext;

import org.bigjava18.shop.bean.Category;
import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.biz.CategoryBiz;
import org.bigjava18.shop.biz.CategorySecondBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台二级分类的Action
 * @author zgp
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	
	//创建CategorySecond实例对象
	private CategorySecond categorySecond=new CategorySecond();
	
	@Override
	public CategorySecond getModel() {
		
		return categorySecond;
	}
	
	//在AdminCategorySecond中注入CategorySecondBiz
	private CategorySecondBiz categorySecondBiz;

	public void setCategorySecondBiz(CategorySecondBiz categorySecondBiz) {
		
		this.categorySecondBiz = categorySecondBiz;
	}
	
	//在AdminCategorySecond中注入categoryBiz
	private CategoryBiz categoryBiz;
	
	public void setCategoryBiz(CategoryBiz categoryBiz) {
		
		this.categoryBiz = categoryBiz;
	}

	//当前页面
	private Integer page;
	
	public void setPage(Integer page) {
		
		this.page = page;
	}

	/**
	 * 到二级分类的列表页面
	 * @return
	 */
	public String csListPage() {
		
		//到二级分类列表页面的同时，查询所有的二级分类
		PageBean<CategorySecond> pageBean=categorySecondBiz.findAll(page);
		
		System.out.println(">>:"+pageBean);
		
		//将数据存入到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "csListPage";
	}
	
	/**
	 * 到二级分类更新页面
	 * @return
	 */
	public String csUpdatePage() {
		
		//通过csid查询二级分类
		categorySecond=categorySecondBiz.findByCsid(categorySecond.getCsid());
		
		//查询所有的一级分类
		List<Category> categories=categoryBiz.findAll();
		//保存到值栈
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		return "csUpdatePage";
	}
	
	/**
	 * 更新二级分类
	 * @return
	 */
	public String csUpdate() {
		
		categorySecondBiz.csUpdate(categorySecond);
		return "csUpdate";
	}
	
	/**
	 * 到添加二级分类的页面
	 * @return
	 */
	public String addCsPage() {
		
		//查询所有的一级分类
		List<Category> categories=categoryBiz.findAll();
		//保存到值栈
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		return "addCsPage";
	}
	
	/**
	 * 添加二级分类
	 * @return
	 */
	public String saveCsData() {
		
		categorySecondBiz.saveCsData(categorySecond);
		
		return "saveCsData";
	}
	
	/**
	 * 通过csid删除二级分类
	 * @return
	 */
	public String deleteCategorySecond() {
		
		categorySecond=categorySecondBiz.findByCsid(categorySecond.getCsid());
		categorySecondBiz.deleteCategorySecond(categorySecond);
		
		return "deleteCategorySecond";
	}
	
}
