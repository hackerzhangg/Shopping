package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.common.PageHibernateCallback;
import org.bigjava18.shop.dao.CategorySecondDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ������������ݿ���ʽӿ�ʵ����
 * @author zgp
 *
 */
public class CategorySecondDaoImpl extends HibernateDaoSupport implements CategorySecondDao {
	
	/**
	 * ��ѯ�������������
	 */
	@Override
	public int findCount() {

		String hql = "select count(*) from CategorySecond";
		List<Long> list = this.getHibernateTemplate().find(hql);
		
		if (list != null && list.size() > 0) {
			
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * ��ѯ�������༯��
	 */
	@Override
	public List<CategorySecond> findByPage(int begin, int limit) {
		
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, null, begin,limit));
		return list;
	}
	
	/**
	 * ͨ��csid��ѯ��������
	 */
	@Override
	public CategorySecond findByCsid(Integer csid) {
		
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}
	
	/**
	 * ���¶�������
	 */
	@Override
	public void csUpdate(CategorySecond categorySecond) {
		
		this.getHibernateTemplate().update(categorySecond);
	}
	
	/**
	 * ��Ӷ�������
	 */
	@Override
	public void saveCsData(CategorySecond categorySecond) {

		this.getHibernateTemplate().save(categorySecond);
	}
	
	/**
	 * ��ѯ���еĶ������࣬������ҳ
	 */
	@Override
	public List<CategorySecond> findAllData() {
		
		String hql="from CategorySecond";
		
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * ͨ��csidɾ����������
	 */
	@Override
	public void deleteCategorySecond(CategorySecond categorySecond) {

		this.getHibernateTemplate().delete(categorySecond);
	}

}
