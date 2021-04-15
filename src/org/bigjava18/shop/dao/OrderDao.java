package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;

/**
 * 用户订单数据库访问接口
 * @author zgp
 *
 */
public interface OrderDao {
	
	/**
	 * 保存用户订单
	 * @param order
	 */
	public void saveUserOrder(Order order);
	
	/**
	 * 通过用户的uid查询订单的数量
	 * @param uid
	 * @return
	 */
	public int findCountByUid(Integer uid);
	
	/**
	 * 通过用户的uid查询用户订单：带分页
	 * @param uid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Order> findPageByUid(Integer uid, int begin, int limit);
	
	/**
	 * 根据订单的oid查询订单
	 * @param oid
	 * @return
	 */
	public Order findByOid(Integer oid);
	
	/**
	 * 修改订单
	 * @param userOrder
	 */
	public void updateOrder(Order userOrder);
	
	/**
	 * 查询订单的数量
	 * @return
	 */
	public int orderCount();
	
	/**
	 * 查询订单的集合 带分页
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Order> findOrderPage(int begin, int limit);
	
	/**
	 * 通过订单的oid查询订单项
	 * @param oid
	 * @return
	 */
	public List<OrderItem> findByOrderItem(Integer oid);
	
	/**
	 * 后台根据订单的oid更新订单
	 * @param order
	 */
	public void updateOrderState(Order orderUpdate);
	
	/**
	 * 确认收货，更新订单状态
	 * @param orderUpdate
	 */
	public void updateState(Order orderUpdate);
	
	/**
	 * 通过订单的oid删除订单
	 * @param deleteOrder
	 */
	public void deleteUserOrder(Order deleteOrder);

}
