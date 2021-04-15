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
 * ��̨���������Action
 * @author zgp
 *
 */
public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{
	
	//����CategorySecondʵ������
	private CategorySecond categorySecond=new CategorySecond();
	
	@Override
	public CategorySecond getModel() {
		
		return categorySecond;
	}
	
	//��AdminCategorySecond��ע��CategorySecondBiz
	private CategorySecondBiz categorySecondBiz;

	public void setCategorySecondBiz(CategorySecondBiz categorySecondBiz) {
		
		this.categorySecondBiz = categorySecondBiz;
	}
	
	//��AdminCategorySecond��ע��categoryBiz
	private CategoryBiz categoryBiz;
	
	public void setCategoryBiz(CategoryBiz categoryBiz) {
		
		this.categoryBiz = categoryBiz;
	}

	//��ǰҳ��
	private Integer page;
	
	public void setPage(Integer page) {
		
		this.page = page;
	}

	/**
	 * ������������б�ҳ��
	 * @return
	 */
	public String csListPage() {
		
		//�����������б�ҳ���ͬʱ����ѯ���еĶ�������
		PageBean<CategorySecond> pageBean=categorySecondBiz.findAll(page);
		
		System.out.println(">>:"+pageBean);
		
		//�����ݴ��뵽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "csListPage";
	}
	
	/**
	 * �������������ҳ��
	 * @return
	 */
	public String csUpdatePage() {
		
		//ͨ��csid��ѯ��������
		categorySecond=categorySecondBiz.findByCsid(categorySecond.getCsid());
		
		//��ѯ���е�һ������
		List<Category> categories=categoryBiz.findAll();
		//���浽ֵջ
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		return "csUpdatePage";
	}
	
	/**
	 * ���¶�������
	 * @return
	 */
	public String csUpdate() {
		
		categorySecondBiz.csUpdate(categorySecond);
		return "csUpdate";
	}
	
	/**
	 * ����Ӷ��������ҳ��
	 * @return
	 */
	public String addCsPage() {
		
		//��ѯ���е�һ������
		List<Category> categories=categoryBiz.findAll();
		//���浽ֵջ
		ActionContext.getContext().getValueStack().set("categories", categories);
		
		return "addCsPage";
	}
	
	/**
	 * ��Ӷ�������
	 * @return
	 */
	public String saveCsData() {
		
		categorySecondBiz.saveCsData(categorySecond);
		
		return "saveCsData";
	}
	
	/**
	 * ͨ��csidɾ����������
	 * @return
	 */
	public String deleteCategorySecond() {
		
		categorySecond=categorySecondBiz.findByCsid(categorySecond.getCsid());
		categorySecondBiz.deleteCategorySecond(categorySecond);
		
		return "deleteCategorySecond";
	}
	
}
