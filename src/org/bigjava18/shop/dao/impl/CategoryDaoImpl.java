package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.Category;
import org.bigjava18.shop.dao.CategoryDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 一级分类数据库访问接口实现类
 * @author zgp
 *
 */
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao{
	
	/**
	 * 查询所有一级分类
	 */
	@Override
	public List<Category> findAll() {
		
		List<Category> cList=this.getHibernateTemplate().find("from Category");			
		return cList;
	}
	
	/**
	 * 通过cid查询一级分类
	 */
	@Override
	public Category findByCid(Integer cid) {
		
		return this.getHibernateTemplate().get(Category.class, cid);
	}
	
	/**
	 * 更新一级分类
	 */
	@Override
	public void updateCategory(Category category) {
		
		this.getHibernateTemplate().update(category);
	}
	
	/**
	 * 添加一级分类
	 */
	@Override
	public void addCategory(Category category) {

		this.getHibernateTemplate().save(category);
	}
	
	/**
	 * 通过cid删除一级分类
	 */
	@Override
	public void deleteCategory(Category category) {

		this.getHibernateTemplate().delete(category);
	}
	
	/**
	 * 模糊查询一级分类
	 */
	@Override
	public List<Category> findCondition(Category category) {
		
		//创建离线对象，设置对哪个实体类进行操作
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Category.class);
		
		//设置对哪个实体类进行操作
		detachedCriteria.add(Restrictions.like("cname", "%"+category.getCname()+"%"));
		
		//调用方法得到List集合
		List<Category> list=this.getHibernateTemplate().findByCriteria(detachedCriteria);
		
		return list;
	}

}
