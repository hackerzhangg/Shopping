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
 * �û�������Action
 * @author zgp
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	
	//����Orderʵ������
	private Order order=new Order();
	
	//ʹ��ģ��������װ����������ֵ
	@Override
	public Order getModel() {
		
		return order;
	}
	
	//ʹ�����Է�װ����page
	private Integer page;
	
	//����page��set����
	public void setPage(Integer page) {
		
		this.page = page;
	}

	//��OrderActionע��OrderBiz
	private OrderBiz orderBiz;
	
	//����OrderBiz��set����
	public void setOrderBiz(OrderBiz orderBiz) {
		
		this.orderBiz = orderBiz;
	}
	
	/**
	 * ���ɶ�����orderҳ��
	 * @return
	 */
	public String saveOrderPage() {
		
		//���ù��ﳵ��session����session�л�ȡ���ﳵ����Ϣ
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		//�жϹ��ﳵ���Ƿ�Ϊ��
		if(cart == null) {
			
			this.addActionMessage("�ף��㻹û�й������ȥ���");
			return "cartMsg";
		}
		
		//���ö������ܼ�
		order.setTotal(cart.getTotal());		
		//���ö�����״̬��1��ʾ�û�δ����
		order.setState(1);		
		//���ö�����ʱ��
		order.setOrdertime(new Date());
		
		//���ö����������û����ж��û��Ƿ��¼
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		
		//�ж��û��Ƿ��¼
		if(user == null) {
			
			this.addActionMessage("�ף� �㻹û�е�¼������ȥ��¼��");
			return "userMsg";
		}
		order.setUser(user);
		
		//���ö������
		for(CartItem cartItem: cart.getCartItems()) {
			//�ڹ��ﳵ������ѭ����ù�������ö�����
			OrderItem orderItem=new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setProduct(cartItem.getProduct());
			
			order.getOrderItems().add(orderItem);			
		}
		
		//����Biz���涩��
		orderBiz.saveUserOrder(order);
		
		//���涩���󣬽���չ��ﳵ
		cart.clearCart();
		
		//OrderAction��ʹ��ģ�����������Է�װ������Ҫ�ڴ���ֵջ��session��
		
		return "saveOrderPage";
	}
	
	/**
	 * ͨ���û���uid��ѯ�û�����
	 * @return
	 */
	public String findByUid() {
		
		//���û���session�л���û���uid
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		
		//����û�uid
		Integer uid=user.getUid();
		
		//ͨ���û���uid��ѯ�û�����
		PageBean<Order> pageBean=orderBiz.findByUid(uid,page);
		
		//����ѯ�������ݱ��浽ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findByUid";
	}
	
	/**
	 * ���ݶ�����oid��ѯ����
	 * @return
	 */
	public String findByOid() {
		
		order=orderBiz.findByOid(order.getOid());
		//ʹ��ģ��������װOrder Ĭ����ֵջ��
		return "findByOid";
	}
	
	/**
	 * ��������
	 * @return
	 */
	public String payOrderPage() {
		
		//�޸��û��������ݣ�����û�����name address phone
		Order userOrder=orderBiz.findByOid(order.getOid());
		
		//��ֵ����ֵջ��
		//ActionContext.getContext().getValueStack().set("userOrder", userOrder);
		
		userOrder.setAddress(order.getAddress());
		userOrder.setName(order.getName());
		userOrder.setPhone(order.getPhone());
		
		//����OrderBiz�޸Ķ�������
		orderBiz.updateOrder(userOrder);
		
		//���û��Ķ�����Ϣ���Ե�ҳ��
		Order uOrders=orderBiz.findByOid(order.getOid());
		
		ActionContext.getContext().getValueStack().set("uOrders", uOrders);
		
		return "payOrderPage";
	}
	
	/**
	 * ����ɹ���תҳ��
	 * @return
	 */
	public String callBackPage() {
		
		//�޸��û��������ݣ��޸Ķ���״̬Ϊ2
		Order userOrder=orderBiz.findByOid(order.getOid());
		userOrder.setState(2);
		
		//����OrderBiz�޸Ķ�������
		orderBiz.updateOrder(userOrder);
		return "callBackPage";
	}
	
	/**
	 * ȷ���ջ������¶���״̬
	 * @return
	 */
	public String updateState() {
		
		Order orderUpdate=orderBiz.findByOid(order.getOid());
		orderUpdate.setState(4);
		orderBiz.updateState(orderUpdate);
		
		return "updateState";
	}
}
