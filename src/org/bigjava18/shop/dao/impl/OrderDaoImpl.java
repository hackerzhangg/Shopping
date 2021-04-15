package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;
import org.bigjava18.shop.common.PageHibernateCallback;
import org.bigjava18.shop.dao.OrderDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 用户订单数据库访问接口实现类
 * @author zgp
 *
 */
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao{
	
	/**
	 * 保存用户订单
	 */
	@Override
	public void saveUserOrder(Order order) {

		this.getHibernateTemplate().save(order);
	}
	
	/**
	 * 通过用户的uid查询用户订单的数量
	 */
	@Override
	public int findCountByUid(Integer uid) {
		
		//编写查询sql
		String hql="select count(*) from Order o where o.user.uid=?";		
		List<Long> list=this.getHibernateTemplate().find(hql,uid);
		
		//判断list集合
		if(list != null && list.size() > 0) {
			
			return list.get(0).intValue();
		}		
		return 0;
	}
	
	/**
	 * 通过用户的uid查询用户的订单：带分页
	 */
	@Override
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		
		//编写查询sql
		String hql="from Order o where o.user.uid=? order by o.ordertime desc";		
		List<Order> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[] {uid}, begin, limit));
		
		//判断list集合
		if(list != null && list.size() > 0) {
			
			return list;
		}		
		return null;
	}
	
	/**
	 * 根据订单的oid查询订单
	 */
	@Override
	public Order findByOid(Integer oid) {
		
		return this.getHibernateTemplate().get(Order.class, oid);
	}
	
	/**
	 * 修改订单
	 */
	@Override
	public void updateOrder(Order userOrder) {

		this.getHibernateTemplate().update(userOrder);
	}
	
	/**
	 * 查询订单的数量
	 */
	@Override
	public int orderCount() {
		
		String hql="select count(*) from Order";
		List<Long> list=this.getHibernateTemplate().find(hql);		
		
		if(list !=null && list.size() > 0) {
			
			return list.get(0).intValue();
		}
		return 0;
	}
	
	/**
	 * 查询订单的集合
	 */
	@Override
	public List<Order> findOrderPage(int begin, int limit) {
		
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
		
		return list;
	}
	
	/**
	 * 通过订单的oid查询订单项
	 */
	@Override
	public List<OrderItem> findByOrderItem(Integer oid) {
		
		String sql="from OrderItem o where o.order.oid = ?";
		List<OrderItem> items=this.getHibernateTemplate().find(sql,oid);
		
		if(items !=null && items.size() > 0) {
			
			return items;
		}		
		return null;
	}
	
	/**
	 * 后台根据订单的oid更新订单
	 */
	@Override
	public void updateOrderState(Order orderUpdate) {

		this.getHibernateTemplate().update(orderUpdate);
	}
	
	/**
	 * 确认收货，更新订单状态
	 */
	@Override
	public void updateState(Order orderUpdate) {

		this.getHibernateTemplate().update(orderUpdate);
	}
	
	/**
	 * 通过订单的oid删除订单
	 */
	@Override
	public void deleteUserOrder(Order deleteOrder) {
		
		this.getHibernateTemplate().delete(deleteOrder);
	}

}
