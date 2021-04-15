package org.bigjava18.shop.action;

import java.util.List;

import org.bigjava18.shop.bean.Category;
import org.bigjava18.shop.bean.Product;
import org.bigjava18.shop.biz.CategoryBiz;
import org.bigjava18.shop.biz.ProductBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �û���ҳ���ʵ�Action
 * @author zgp
 *
 */
public class IndexAction extends ActionSupport{
	
	//��IndexAction��ע��CategoryBiz
	private CategoryBiz categoryBiz;
	
	//����CategoryBiz��set����
	public void setCategoryBiz(CategoryBiz categoryBiz) {
		
		this.categoryBiz = categoryBiz;
	}
	
	//��IndexAction��ע��ProductBiz
	private ProductBiz productBiz;
	
	//����ProductBiz��set����
	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}

	/**
	 * ���û���ҳ��action
	 * @return
	 */
	public String execute() {
		
		//��ѯ����һ������ļ���
		List<Category> cList=categoryBiz.findAll();
		//����ѯ��һ�����ౣ�浽Session
		ActionContext.getContext().getSession().put("cList", cList);
		
		//��ѯ������Ʒ
		List<Product> hotList=productBiz.findHot();
		//��������Ʒ���浽ֵջ��
		ActionContext.getContext().getValueStack().set("hotList", hotList);
		
		//��ѯ������Ʒ
		List<Product> newList=productBiz.findNew();
		System.out.println("������Ʒ:"+newList);
		//��������Ʒ���浽ֵջ��
		ActionContext.getContext().getValueStack().set("newList", newList);
		
		//System.out.println("���̳���ҳ");
		return "index";
	}

}
