package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.biz.OrderBiz;
import org.bigjava18.shop.dao.OrderDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户订单的业务逻辑层接口实现类
 * @author zgp
 *
 */
@Transactional
public class OrderBizImpl implements OrderBiz {
	
	//在OrderBizImpl中注入OrderDao
	private OrderDao orderDao;
	
	//创建OrderDao的set方法
	public void setOrderDao(OrderDao orderDao) {
		
		this.orderDao = orderDao;
	}
	
	/**
	 * 保存用户订单
	 */
	@Override
	public void saveUserOrder(Order order) {

		orderDao.saveUserOrder(order);
	}
	
	/**
	 * 通过用户的uid查询用户订单
	 */
	@Override
	public PageBean<Order> findByUid(Integer uid, Integer page) {

		//创建PageBean实例对象
		PageBean<Order> pageBean=new PageBean<Order>();
		
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的大小
		int limit=4;
		pageBean.setLimit(limit);
		
		//设置总记录数
		int totalCount=0;
		//通过用户的uid查询订单的数量
		totalCount=orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		
		//设置总页数
		int totalPage=0;
		
		if(totalCount % limit == 0) {
			totalPage = totalCount / limit;
		}else {
			totalPage = totalCount / limit + 1;
		}		
		pageBean.setTotalPage(totalPage);
		
		//设置每页显示数据集合
		int begin=(page - 1) * limit;
		//通过用户的uid查询订单
		List<Order> list=orderDao.findPageByUid(uid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	
	/**
	 * 根据订单的oid查询订单
	 */
	@Override
	public Order findByOid(Integer oid) {
		
		return orderDao.findByOid(oid);
	}
	
	/**
	 * 修改订单
	 */
	@Override
	public void updateOrder(Order userOrder) {
		
		orderDao.updateOrder(userOrder);
	}
	
	/**
	 * 查询订单列表 带分页
	 */
	@Override
	public PageBean<Order> orderListPage(Integer page) {
		
		//创建实例对象
		PageBean<Order> pageBean=new PageBean<Order>();
		
		//设置当前页面数
		pageBean.setPage(page);
		
		//设置页面显示的大小
		//int limit=3;
		int limit=6;
		pageBean.setLimit(limit);
		
		//设置订单的数量
		int totalCount=0;
		totalCount=orderDao.orderCount();
		pageBean.setTotalCount(totalCount);
		
		//设置页面的显示页数
		int totalPage=0;
		if(totalCount % limit == 0) {
			
			totalPage = totalCount / limit;
		}else {
			
			totalPage = totalCount / limit +1;
		}
		pageBean.setTotalPage(totalPage);
		
		//设置查询订单的集合
		int begin=(page -1) * limit;
		List<Order> list=orderDao.findOrderPage(begin,limit);
		pageBean.setList(list);

		return pageBean;
	}
	
	/**
	 * 通过订单的oid查询订单项
	 */
	@Override
	public List<OrderItem> findByOrderItem(Integer oid) {
		
		return orderDao.findByOrderItem(oid);
	}
	
	/**
	 * 后台根据订单的oid更新订单
	 */
	@Override
	public void updateOrderState(Order orderUpdate) {

		orderDao.updateOrderState(orderUpdate);
	}
	
	/**
	 * 确认收货，更新订单状态
	 */
	@Override
	public void updateState(Order orderUpdate) {

		orderDao.updateState(orderUpdate);
	}
	
	/**
	 * 通过订单的oid删除订单
	 */
	@Override
	public void deleteUserOrder(Order deleteOrder) {
		
		orderDao.deleteUserOrder(deleteOrder);
	}
	
}
