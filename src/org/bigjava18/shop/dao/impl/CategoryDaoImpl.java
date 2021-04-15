package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.Category;
import org.bigjava18.shop.dao.CategoryDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * һ���������ݿ���ʽӿ�ʵ����
 * @author zgp
 *
 */
public class CategoryDaoImpl extends HibernateDaoSupport implements CategoryDao{
	
	/**
	 * ��ѯ����һ������
	 */
	@Override
	public List<Category> findAll() {
		
		List<Category> cList=this.getHibernateTemplate().find("from Category");			
		return cList;
	}
	
	/**
	 * ͨ��cid��ѯһ������
	 */
	@Override
	public Category findByCid(Integer cid) {
		
		return this.getHibernateTemplate().get(Category.class, cid);
	}
	
	/**
	 * ����һ������
	 */
	@Override
	public void updateCategory(Category category) {
		
		this.getHibernateTemplate().update(category);
	}
	
	/**
	 * ���һ������
	 */
	@Override
	public void addCategory(Category category) {

		this.getHibernateTemplate().save(category);
	}
	
	/**
	 * ͨ��cidɾ��һ������
	 */
	@Override
	public void deleteCategory(Category category) {

		this.getHibernateTemplate().delete(category);
	}
	
	/**
	 * ģ����ѯһ������
	 */
	@Override
	public List<Category> findCondition(Category category) {
		
		//�������߶������ö��ĸ�ʵ������в���
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Category.class);
		
		//���ö��ĸ�ʵ������в���
		detachedCriteria.add(Restrictions.like("cname", "%"+category.getCname()+"%"));
		
		//���÷����õ�List����
		List<Category> list=this.getHibernateTemplate().findByCriteria(detachedCriteria);
		
		return list;
	}

}
