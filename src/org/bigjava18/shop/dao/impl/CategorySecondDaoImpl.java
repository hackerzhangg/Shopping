package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.common.PageHibernateCallback;
import org.bigjava18.shop.dao.CategorySecondDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 二级分类的数据库访问接口实现类
 * @author zgp
 *
 */
public class CategorySecondDaoImpl extends HibernateDaoSupport implements CategorySecondDao {
	
	/**
	 * 查询二级分类的条数
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
	 * 查询二级分类集合
	 */
	@Override
	public List<CategorySecond> findByPage(int begin, int limit) {
		
		String hql = "from CategorySecond order by csid desc";
		List<CategorySecond> list = this.getHibernateTemplate().execute(new PageHibernateCallback<CategorySecond>(hql, null, begin,limit));
		return list;
	}
	
	/**
	 * 通过csid查询二级分类
	 */
	@Override
	public CategorySecond findByCsid(Integer csid) {
		
		return this.getHibernateTemplate().get(CategorySecond.class, csid);
	}
	
	/**
	 * 更新二级分类
	 */
	@Override
	public void csUpdate(CategorySecond categorySecond) {
		
		this.getHibernateTemplate().update(categorySecond);
	}
	
	/**
	 * 添加二级分类
	 */
	@Override
	public void saveCsData(CategorySecond categorySecond) {

		this.getHibernateTemplate().save(categorySecond);
	}
	
	/**
	 * 查询所有的二级分类，不带分页
	 */
	@Override
	public List<CategorySecond> findAllData() {
		
		String hql="from CategorySecond";
		
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * 通过csid删除二级分类
	 */
	@Override
	public void deleteCategorySecond(CategorySecond categorySecond) {

		this.getHibernateTemplate().delete(categorySecond);
	}

}
