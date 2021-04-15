package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;
import org.bigjava18.shop.bean.PageBean;

/**
 * �û�������ҵ���߼���ӿ�
 * @author zgp
 *
 */
public interface OrderBiz {
	
	/**
	 * �����û�����
	 * @param order
	 */
	public void saveUserOrder(Order order);
	
	/**
	 * ͨ���û���uid��ѯ�û�����
	 * @param uid
	 * @param page
	 * @return
	 */
	public PageBean<Order> findByUid(Integer uid, Integer page);
	
	/**
	 * ���ݶ�����oid��ѯ����
	 * @param oid
	 * @return
	 */
	public Order findByOid(Integer oid);
	
	/**
	 * �޸Ķ���
	 * @param userOrder
	 */
	public void updateOrder(Order userOrder);
	
	/**
	 * ��ѯ�����б� ����ҳ
	 * @param page
	 * @return
	 */
	public PageBean<Order> orderListPage(Integer page);
	
	/**
	 * ͨ��������oid��ѯ������
	 * @param oid
	 * @return
	 */
	public List<OrderItem> findByOrderItem(Integer oid);
	
	/**
	 * ��̨���ݶ�����oid���¶���
	 * @param order
	 */
	public void updateOrderState(Order orderUpdate);
	
	/**
	 * ȷ���ջ������¶���״̬
	 * @param orderUpdate
	 */
	public void updateState(Order orderUpdate);
	
	/**
	 * ͨ��������oidɾ������
	 * @param deleteOrder
	 */
	public void deleteUserOrder(Order deleteOrder);

}
