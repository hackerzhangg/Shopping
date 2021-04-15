package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.biz.OrderBiz;
import org.bigjava18.shop.dao.OrderDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * �û�������ҵ���߼���ӿ�ʵ����
 * @author zgp
 *
 */
@Transactional
public class OrderBizImpl implements OrderBiz {
	
	//��OrderBizImpl��ע��OrderDao
	private OrderDao orderDao;
	
	//����OrderDao��set����
	public void setOrderDao(OrderDao orderDao) {
		
		this.orderDao = orderDao;
	}
	
	/**
	 * �����û�����
	 */
	@Override
	public void saveUserOrder(Order order) {

		orderDao.saveUserOrder(order);
	}
	
	/**
	 * ͨ���û���uid��ѯ�û�����
	 */
	@Override
	public PageBean<Order> findByUid(Integer uid, Integer page) {

		//����PageBeanʵ������
		PageBean<Order> pageBean=new PageBean<Order>();
		
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�Ĵ�С
		int limit=4;
		pageBean.setLimit(limit);
		
		//�����ܼ�¼��
		int totalCount=0;
		//ͨ���û���uid��ѯ����������
		totalCount=orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		
		//������ҳ��
		int totalPage=0;
		
		if(totalCount % limit == 0) {
			totalPage = totalCount / limit;
		}else {
			totalPage = totalCount / limit + 1;
		}		
		pageBean.setTotalPage(totalPage);
		
		//����ÿҳ��ʾ���ݼ���
		int begin=(page - 1) * limit;
		//ͨ���û���uid��ѯ����
		List<Order> list=orderDao.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * ���ݶ�����oid��ѯ����
	 */
	@Override
	public Order findByOid(Integer oid) {
		
		return orderDao.findByOid(oid);
	}
	
	/**
	 * �޸Ķ���
	 */
	@Override
	public void updateOrder(Order userOrder) {
		
		orderDao.updateOrder(userOrder);
	}
	
	/**
	 * ��ѯ�����б� ����ҳ
	 */
	@Override
	public PageBean<Order> orderListPage(Integer page) {
		
		//����ʵ������
		PageBean<Order> pageBean=new PageBean<Order>();
		
		//���õ�ǰҳ����
		pageBean.setPage(page);
		
		//����ҳ����ʾ�Ĵ�С
		//int limit=3;
		int limit=6;
		pageBean.setLimit(limit);
		
		//���ö���������
		int totalCount=0;
		totalCount=orderDao.orderCount();
		pageBean.setTotalCount(totalCount);
		
		//����ҳ�����ʾҳ��
		int totalPage=0;
		if(totalCount % limit == 0) {
			
			totalPage = totalCount / limit;
		}else {
			
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		
		//���ò�ѯ�����ļ���
		int begin=(page -1) * limit;
		List<Order> list=orderDao.findOrderPage(begin,limit);
		pageBean.setList(list);

		return pageBean;
	}
	
	/**
	 * ͨ��������oid��ѯ������
	 */
	@Override
	public List<OrderItem> findByOrderItem(Integer oid) {
		
		return orderDao.findByOrderItem(oid);
	}
	
	/**
	 * ��̨���ݶ�����oid���¶���
	 */
	@Override
	public void updateOrderState(Order orderUpdate) {

		orderDao.updateOrderState(orderUpdate);
	}
	
	/**
	 * ȷ���ջ������¶���״̬
	 */
	@Override
	public void updateState(Order orderUpdate) {

		orderDao.updateState(orderUpdate);
	}
	
	/**
	 * ͨ��������oidɾ������
	 */
	@Override
	public void deleteUserOrder(Order deleteOrder) {
		
		orderDao.deleteUserOrder(deleteOrder);
	}
	
}
