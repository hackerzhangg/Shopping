package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.Product;
import org.bigjava18.shop.common.PageHibernateCallback;
import org.bigjava18.shop.dao.ProductDao;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ��Ʒ�����ݿ���ʽӿ�ʵ����
 * @author zgp
 *
 */
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{
	
	/**
	 * ��ҳ��ѯ������Ʒ
	 */
	@Override
	public List<Product> findHot() {
		//ʹ������������ѯ
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//��ѯ���ŵ���Ʒ,��������is_host = 1
		criteria.add(Restrictions.eq("is_hot", 1));
		//�����������
		criteria.addOrder(Order.desc("pdate"));
		//ִ�в�ѯ
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);	
		return list;
	}
	
	/**
	 * ��ҳ��ѯ������Ʒ
	 */
	@Override
	public List<Product> findNew() {
		//ʹ������������ѯ
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//����Ʒ���ڽ��е�������
		criteria.addOrder(Order.desc("pdate"));
		//ִ�в�ѯ
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}
	
	/**
	 * ͨ����Ʒ��pid��ѯ��Ʒ����ϸ
	 */
	@Override
	public Product findByPid(Integer pid) {
		
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	
	/**
	 * ����һ�������cid��ѯ��Ʒ����
	 */
	@Override
	public int findCountCid(Integer cid) {
		
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";		
		List<Long> list = this.getHibernateTemplate().find(hql,cid);
		
		if(list != null && list.size() > 0){
			
			//list.get(0).intValue():��Longתint����
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * ����һ�������cid��ѯ��Ʒ����
	 */
	@Override
	public List<Product> findByPageCid(Integer cid, int begin, int limit) {
		
		String hql = "select p from Product p join p.categorySecond cs join cs.category c where c.cid = ?";		
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{cid}, begin, limit));
		
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}
	
	/**
	 * ���ݶ��������csid��ѯ��Ʒ����
	 */
	@Override
	public int findCountCsid(Integer csid) {
		
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		
		if(list != null && list.size() > 0){
			
			//list.get(0).intValue():��Longתint����
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * ���ݶ��������csid��ѯ��Ʒ����
	 */
	@Override
	public List<Product> findByPageCsid(Integer csid, int begin, int limit) {

		String hql = "select p from Product p join p.categorySecond cs where cs.csid = ?";
		List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, new Object[]{csid}, begin, limit));
		
		if(list != null && list.size() > 0){
			return list;
		}
		return null;
	}
	
	/**
	 * ��Ʒ������
	 */
	@Override
	public int findCount() {
		
		String hql="select count(*) from Product";
		List<Long> count=this.getHibernateTemplate().find(hql);
		
		if(count !=null && count.size() > 0) {
			
			return count.get(0).intValue();
		}		
		return 0;
	}
	
	/**
	 * ��Ʒ����
	 */
	@Override
	public List<Product> findByPage(int begin, int limit) {
		
		String hql = "from Product order by pdate desc";
		List<Product> list =  this.getHibernateTemplate().execute(new PageHibernateCallback<Product>(hql, null, begin, limit));
		
		if(list != null && list.size() > 0){
			
			return list;
		}
		return null;
	}
	
	/**
	 * �޸���Ʒ
	 */
	@Override
	public void update(Product product) {
		
		this.getHibernateTemplate().update(product);
	}
	
	/**
	 * �����Ʒ
	 */
	@Override
	public void saveProduct(Product product) {

		this.getHibernateTemplate().save(product);
	}
	
	/**
	 * ɾ����Ʒ
	 */
	@Override
	public void deleteProduct(Product product) {

		this.getHibernateTemplate().delete(product);
	}
	
	/**
	 * ͨ����Ʒ������ģ����ѯ��Ʒ
	 */
	@Override
	public List<Product> findCondition(Product product) {
		
		//�������߶������ö��ĸ�ʵ������в���
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		
		//���ö�ʵ������ĸ�����
		criteria.add(Restrictions.like("pname", "%"+product.getPname()+"%"));
		
		//���÷����õ�list����
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	
}
