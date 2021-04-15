package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.Category;
import org.bigjava18.shop.biz.CategoryBiz;
import org.bigjava18.shop.dao.CategoryDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * 一级分类业务逻辑层接口实现类
 * @author zgp
 *
 */
@Transactional
public class CategoryBizImpl implements CategoryBiz{
	
	//在CategoryBizImpl中注入CategoryDao
	private CategoryDao categoryDao;
	
	//创建CategoryDao的set方法
	public void setCategoryDao(CategoryDao categoryDao) {
		
		this.categoryDao = categoryDao;
	}
	
	/**
	 * 查询所有一级分类
	 */
	@Override
	public List<Category> findAll() {
		
		return categoryDao.findAll();
	}
	
	/**
	 * 通过cid查询一级分类
	 */
	@Override
	public Category findByCid(Integer cid) {
		
		return categoryDao.findByCid(cid);
	}
	
	/**
	 *  更新一级分类
	 */
	@Override
	public void updateCategory(Category category) {
		
		categoryDao.updateCategory(category);
	}
	
	/**
	 * 添加一级分类
	 */
	@Override
	public void addCategory(Category category) {
		
		categoryDao.addCategory(category);
	}
	
	/**
	 * 通过cid删除一级分类
	 */
	@Override
	public void deleteCategory(Category category) {

		categoryDao.deleteCategory(category);
	}
	
	/**
	 * 模糊查询一级分类
	 */
	@Override
	public List<Category> findCondition(Category category) {
		
		return categoryDao.findCondition(category);
	}
	
}
