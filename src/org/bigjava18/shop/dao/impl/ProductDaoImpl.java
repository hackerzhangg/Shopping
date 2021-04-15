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
 * 商品的数据库访问接口实现类
 * @author zgp
 *
 */
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao{
	
	/**
	 * 首页查询热门商品
	 */
	@Override
	public List<Product> findHot() {
		//使用离线条件查询
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		//查询热门的商品,条件就是is_host = 1
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序排序输出
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);	
		return list;
	}
	
	/**
	 * 首页查询最新商品
	 */
	@Override
	public List<Product> findNew() {
		//使用离线条件查询
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		//按商品日期进行倒序排序
		criteria.addOrder(Order.desc("pdate"));
		//执行查询
		List<Product> list = this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}
	
	/**
	 * 通过商品的pid查询商品的详细
	 */
	@Override
	public Product findByPid(Integer pid) {
		
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	
	/**
	 * 根据一级分类的cid查询商品数量
	 */
	@Override
	public int findCountCid(Integer cid) {
		
		String hql = "select count(*) from Product p where p.categorySecond.category.cid = ?";		
		List<Long> list = this.getHibernateTemplate().find(hql,cid);
		
		if(list != null && list.size() > 0){
			
			//list.get(0).intValue():将Long转int类型
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * 根据一级分类的cid查询商品集合
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
	 * 根据二级分类的csid查询商品数量
	 */
	@Override
	public int findCountCsid(Integer csid) {
		
		String hql = "select count(*) from Product p where p.categorySecond.csid = ?";
		List<Long> list = this.getHibernateTemplate().find(hql, csid);
		
		if(list != null && list.size() > 0){
			
			//list.get(0).intValue():将Long转int类型
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * 根据二级分类的csid查询商品集合
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
	 * 商品的条数
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
	 * 商品集合
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
	 * 修改商品
	 */
	@Override
	public void update(Product product) {
		
		this.getHibernateTemplate().update(product);
	}
	
	/**
	 * 添加商品
	 */
	@Override
	public void saveProduct(Product product) {

		this.getHibernateTemplate().save(product);
	}
	
	/**
	 * 删除商品
	 */
	@Override
	public void deleteProduct(Product product) {

		this.getHibernateTemplate().delete(product);
	}
	
	/**
	 * 通过商品的名称模糊查询商品
	 */
	@Override
	public List<Product> findCondition(Product product) {
		
		//创建离线对象，设置对哪个实体类进行操作
		DetachedCriteria criteria=DetachedCriteria.forClass(Product.class);
		
		//设置对实体类的哪个属性
		criteria.add(Restrictions.like("pname", "%"+product.getPname()+"%"));
		
		//调用方法得到list集合
		List<Product> list=this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}
	
}
