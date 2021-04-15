package org.bigjava18.shop.action;

import java.util.List;

import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.biz.OrderBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *后台订单管理Action
 * @author zgp
 *
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
	
	//创建Order实例对象
	private Order order=new Order();
	
	//使用模型驱动封装属性
	@Override
	public Order getModel() {
		
		return order;
	}
	
	//属性封装接收当前页
	private Integer page;

	public void setPage(Integer page) {
		
		this.page = page;
	}
	
	//在AdminOrderAction中注入orderBiz
	private OrderBiz orderBiz;

	public void setOrderBiz(OrderBiz orderBiz) {
		
		this.orderBiz = orderBiz;
	}
	
	/**
	 * 到订单列表页面
	 * @return
	 */
	public String orderListPage() {
		
		//调用Biz查询订单列表 带分页
		PageBean<Order> pageBean=orderBiz.orderListPage(page);
		
		System.out.println(pageBean);
		
		//将值存入值栈中 
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "orderListPage";
	}
	
	/**
	 * 通过订单的oid查询订单项
	 * @return
	 */
	public String findByOrderItem() {
		
		List<OrderItem> orderItems=orderBiz.findByOrderItem(order.getOid());
		
		//将值存入值栈中
		ActionContext.getContext().getValueStack().set("orderItems", orderItems);
		
		return "findByOrderItem";
	}
	
	/**
	 * 更新订单的状态
	 * @return
	 */
	public String updateOrderState() {
		
		//根据订单的oid查询订单
		Order orderUpdate=orderBiz.findByOid(order.getOid());
		orderUpdate.setState(3);
		
		//提交更新
		orderBiz.updateOrderState(orderUpdate);
		
		return "updateOrderState";
	}
	
	/**
	 * 通过订单的oid删除订单
	 * @return
	 */
	public String deleteUserOrder() {
		
		//通过oid查询用户订单
		Order deleteOrder=orderBiz.findByOid(order.getOid());
		
		System.out.println("用户订单oid为："+order.getOid());
		
		//利用订单的oid删除用户订单
		orderBiz.deleteUserOrder(deleteOrder);
		
		return "deleteUserOrder";
	}
	
}
