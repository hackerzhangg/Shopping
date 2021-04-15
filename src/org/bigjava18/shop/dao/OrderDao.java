package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;

/**
 * �û��������ݿ���ʽӿ�
 * @author zgp
 *
 */
public interface OrderDao {
	
	/**
	 * �����û�����
	 * @param order
	 */
	public void saveUserOrder(Order order);
	
	/**
	 * ͨ���û���uid��ѯ����������
	 * @param uid
	 * @return
	 */
	public int findCountByUid(Integer uid);
	
	/**
	 * ͨ���û���uid��ѯ�û�����������ҳ
	 * @param uid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Order> findPageByUid(Integer uid, int begin, int limit);
	
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
	 * ��ѯ����������
	 * @return
	 */
	public int orderCount();
	
	/**
	 * ��ѯ�����ļ��� ����ҳ
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Order> findOrderPage(int begin, int limit);
	
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
