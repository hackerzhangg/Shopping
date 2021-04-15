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
 * ��̨����һ�������Action
 * @author zgp
 *
 */
public class AdminCategoryAction extends ActionSupport implements ModelDriven<Category>{
	
	//����Categoryʵ������
	private Category category=new Category();
	
	//ʹ��ģ��������װ����ֵ
	@Override
	public Category getModel() {
		
		return category;
	}
	
	//��AdminCategoryAction��ע��CategoryBiz
	private CategoryBiz categoryBiz;

	public void setCategoryBiz(CategoryBiz categoryBiz) {
		
		this.categoryBiz = categoryBiz;
	}
	
	/**
	 * ��һ��������б�ҳ��
	 * @return
	 */
	public String categoryListPage() {
		
		List<Category> categories =categoryBiz.findAll();
		
		//����ѯ��ֵ���뵽ֵջ��
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		return "categoryListPage";
	}
	
	/**
	 * ���޸�һ�������ҳ��
	 * @return
	 */
	public String updateCategoryPage() {
		
		category=categoryBiz.findByCid(category.getCid());
		
		return "updateCategoryPage";
	}
	
	/**
	 * ����һ������
	 * @return
	 */
	public String updateCategory() {
		
		categoryBiz.updateCategory(category);
		
		return "updateCategory";
	}
	
	/**
	 * �����һ������ҳ��
	 * @return
	 */
	public String addCategoryPage() {
		
		return "addCategoryPage";
	}
	
	/**
	 * ���һ������
	 * @return
	 */
	public String addCategory() {
		
		categoryBiz.addCategory(category);
		
		return "addCategory";
	}
	
	/**
	 * ͨ��cidɾ��һ������
	 * @return
	 */
	public String deleteCategory() {
		
		category=categoryBiz.findByCid(category.getCid());
		categoryBiz.deleteCategory(category);
		
		return "deleteCategory";
	}
	
	/**
	 * ͨ��һ����������ģ����ѯһ������
	 * @return
	 */
	public String findCondition() {
		
		List<Category> categories=categoryBiz.findCondition(category);		
		System.out.println(categories);
		
		//��ֵ����ֵջ
		//ServletActionContext.getRequest().getSession().setAttribute("categories", categories);
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		return "findCondition";
	}

}
