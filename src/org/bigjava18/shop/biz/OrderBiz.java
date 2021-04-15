package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;
import org.bigjava18.shop.bean.PageBean;

/**
 * 用户订单的业务逻辑层接口
 * @author zgp
 *
 */
public interface OrderBiz {
	
	/**
	 * 保存用户订单
	 * @param order
	 */
	public void saveUserOrder(Order order);
	
	/**
	 * 通过用户的uid查询用户订单
	 * @param uid
	 * @param page
	 * @return
	 */
	public PageBean<Order> findByUid(Integer uid, Integer page);
	
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
	 * 查询订单列表 带分页
	 * @param page
	 * @return
	 */
	public PageBean<Order> orderListPage(Integer page);
	
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
