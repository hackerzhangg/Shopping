package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;
import org.bigjava18.shop.common.PageHibernateCallback;
import org.bigjava18.shop.dao.OrderDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * �û��������ݿ���ʽӿ�ʵ����
 * @author zgp
 *
 */
public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao{
	
	/**
	 * �����û�����
	 */
	@Override
	public void saveUserOrder(Order order) {

		this.getHibernateTemplate().save(order);
	}
	
	/**
	 * ͨ���û���uid��ѯ�û�����������
	 */
	@Override
	public int findCountByUid(Integer uid) {
		
		//��д��ѯsql
		String hql="select count(*) from Order o where o.user.uid=?";		
		List<Long> list=this.getHibernateTemplate().find(hql,uid);
		
		//�ж�list����
		if(list != null && list.size() > 0) {
			
			return list.get(0).intValue();
		}		
		return 0;
	}
	
	/**
	 * ͨ���û���uid��ѯ�û��Ķ���������ҳ
	 */
	@Override
	public List<Order> findPageByUid(Integer uid, int begin, int limit) {
		
		//��д��ѯsql
		String hql="from Order o where o.user.uid=? order by o.ordertime desc";		
		List<Order> list=this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, new Object[] {uid}, begin, limit));
		
		//�ж�list����
		if(list != null && list.size() > 0) {
			
			return list;
		}		
		return null;
	}
	
	/**
	 * ���ݶ�����oid��ѯ����
	 */
	@Override
	public Order findByOid(Integer oid) {
		
		return this.getHibernateTemplate().get(Order.class, oid);
	}
	
	/**
	 * �޸Ķ���
	 */
	@Override
	public void updateOrder(Order userOrder) {

		this.getHibernateTemplate().update(userOrder);
	}
	
	/**
	 * ��ѯ����������
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
	 * ��ѯ�����ļ���
	 */
	@Override
	public List<Order> findOrderPage(int begin, int limit) {
		
		String hql = "from Order order by ordertime desc";
		List<Order> list = this.getHibernateTemplate().execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
		
		return list;
	}
	
	/**
	 * ͨ��������oid��ѯ������
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
	 * ��̨���ݶ�����oid���¶���
	 */
	@Override
	public void updateOrderState(Order orderUpdate) {

		this.getHibernateTemplate().update(orderUpdate);
	}
	
	/**
	 * ȷ���ջ������¶���״̬
	 */
	@Override
	public void updateState(Order orderUpdate) {

		this.getHibernateTemplate().update(orderUpdate);
	}
	
	/**
	 * ͨ��������oidɾ������
	 */
	@Override
	public void deleteUserOrder(Order deleteOrder) {
		
		this.getHibernateTemplate().delete(deleteOrder);
	}

}
