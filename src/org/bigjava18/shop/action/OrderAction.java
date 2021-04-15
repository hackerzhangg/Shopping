package org.bigjava18.shop.action;

import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.Cart;
import org.bigjava18.shop.bean.CartItem;
import org.bigjava18.shop.bean.Order;
import org.bigjava18.shop.bean.OrderItem;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.User;
import org.bigjava18.shop.biz.OrderBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户订单的Action
 * @author zgp
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	
	//创建Order实例对象
	private Order order=new Order();
	
	//使用模型驱动封装订单的属性值
	@Override
	public Order getModel() {
		
		return order;
	}
	
	//使用属性封装接收page
	private Integer page;
	
	//创建page的set方法
	public void setPage(Integer page) {
		
		this.page = page;
	}

	//在OrderAction注入OrderBiz
	private OrderBiz orderBiz;
	
	//创建OrderBiz的set方法
	public void setOrderBiz(OrderBiz orderBiz) {
		
		this.orderBiz = orderBiz;
	}
	
	/**
	 * 生成订单到order页面
	 * @return
	 */
	public String saveOrderPage() {
		
		//调用购物车的session，在session中获取购物车的信息
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		//判断购物车中是否为空
		if(cart == null) {
			
			this.addActionMessage("亲！你还没有购物，请先去购物！");
			return "cartMsg";
		}
		
		//设置订单的总价
		order.setTotal(cart.getTotal());		
		//设置订单的状态：1表示用户未付款
		order.setState(1);		
		//设置订单的时间
		order.setOrdertime(new Date());
		
		//设置订单所属的用户并判断用户是否登录
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		
		//判断用户是否登录
		if(user == null) {
			
			this.addActionMessage("亲！ 你还没有登录，请先去登录！");
			return "userMsg";
		}
		order.setUser(user);
		
		//设置订单项集合
		for(CartItem cartItem: cart.getCartItems()) {
			//在购物车集合中循环获得购物项并设置订单项
			OrderItem orderItem=new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			
			order.getOrderItems().add(orderItem);			
		}
		
		//调用Biz保存订单
		orderBiz.saveUserOrder(order);
		
		//保存订单后，将清空购物车
		cart.clearCart();
		
		//OrderAction中使用模型驱动做属性封装，不需要在存入值栈或session中
		
		return "saveOrderPage";
	}
	
	/**
	 * 通过用户的uid查询用户订单
	 * @return
	 */
	public String findByUid() {
		
		//从用户的session中获得用户的uid
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		
		//获得用户uid
		Integer uid=user.getUid();
		
		//通过用户的uid查询用户订单
		PageBean<Order> pageBean=orderBiz.findByUid(uid,page);
		
		//将查询到的数据保存到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findByUid";
	}
	
	/**
	 * 根据订单的oid查询订单
	 * @return
	 */
	public String findByOid() {
		
		order=orderBiz.findByOid(order.getOid());
		//使用模型驱动封装Order 默认在值栈中
		return "findByOid";
	}
	
	/**
	 * 订单付款
	 * @return
	 */
	public String payOrderPage() {
		
		//修改用户订单数据，添加用户订单name address phone
		Order userOrder=orderBiz.findByOid(order.getOid());
		
		//将值放入值栈中
		//ActionContext.getContext().getValueStack().set("userOrder", userOrder);
		
		userOrder.setAddress(order.getAddress());
		userOrder.setName(order.getName());
		userOrder.setPhone(order.getPhone());
		
		//调用OrderBiz修改订单数据
		orderBiz.updateOrder(userOrder);
		
		//将用户的订单信息回显到页面
		Order uOrders=orderBiz.findByOid(order.getOid());
		
		ActionContext.getContext().getValueStack().set("uOrders", uOrders);
		
		return "payOrderPage";
	}
	
	/**
	 * 付款成功跳转页面
	 * @return
	 */
	public String callBackPage() {
		
		//修改用户订单数据，修改订单状态为2
		Order userOrder=orderBiz.findByOid(order.getOid());
		userOrder.setState(2);
		
		//调用OrderBiz修改订单数据
		orderBiz.updateOrder(userOrder);
		return "callBackPage";
	}
	
	/**
	 * 确认收货，更新订单状态
	 * @return
	 */
	public String updateState() {
		
		Order orderUpdate=orderBiz.findByOid(order.getOid());
		orderUpdate.setState(4);
		orderBiz.updateState(orderUpdate);
		
		return "updateState";
	}
}
