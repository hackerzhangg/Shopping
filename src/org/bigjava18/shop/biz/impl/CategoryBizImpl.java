package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.Category;
import org.bigjava18.shop.biz.CategoryBiz;
import org.bigjava18.shop.dao.CategoryDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * һ������ҵ���߼���ӿ�ʵ����
 * @author zgp
 *
 */
@Transactional
public class CategoryBizImpl implements CategoryBiz{
	
	//��CategoryBizImpl��ע��CategoryDao
	private CategoryDao categoryDao;
	
	//����CategoryDao��set����
	public void setCategoryDao(CategoryDao categoryDao) {
		
		this.categoryDao = categoryDao;
	}
	
	/**
	 * ��ѯ����һ������
	 */
	@Override
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}
	
	/**
	 * ͨ��cid��ѯһ������
	 */
	@Override
	public Category findByCid(Integer cid) {
		
		return categoryDao.findByCid(cid);
	}
	
	/**
	 *  ����һ������
	 */
	@Override
	public void updateCategory(Category category) {
		
		categoryDao.updateCategory(category);
	}
	
	/**
	 * ���һ������
	 */
	@Override
	public void addCategory(Category category) {
		
		categoryDao.addCategory(category);
	}
	
	/**
	 * ͨ��cidɾ��һ������
	 */
	@Override
	public void deleteCategory(Category category) {

		categoryDao.deleteCategory(category);
	}
	
	/**
	 * ģ����ѯһ������
	 */
	@Override
	public List<Category> findCondition(Category category) {
		
		return categoryDao.findCondition(category);
	}
	
}
