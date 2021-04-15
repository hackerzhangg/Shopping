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
 *��̨��������Action
 * @author zgp
 *
 */
public class AdminOrderAction extends ActionSupport implements ModelDriven<Order> {
	
	//����Orderʵ������
	private Order order=new Order();
	
	//ʹ��ģ��������װ����
	@Override
	public Order getModel() {
		
		return order;
	}
	
	//���Է�װ���յ�ǰҳ
	private Integer page;

	public void setPage(Integer page) {
		
		this.page = page;
	}
	
	//��AdminOrderAction��ע��orderBiz
	private OrderBiz orderBiz;

	public void setOrderBiz(OrderBiz orderBiz) {
		
		this.orderBiz = orderBiz;
	}
	
	/**
	 * �������б�ҳ��
	 * @return
	 */
	public String orderListPage() {
		
		//����Biz��ѯ�����б� ����ҳ
		PageBean<Order> pageBean=orderBiz.orderListPage(page);
		
		System.out.println(pageBean);
		
		//��ֵ����ֵջ�� 
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "orderListPage";
	}
	
	/**
	 * ͨ��������oid��ѯ������
	 * @return
	 */
	public String findByOrderItem() {
		
		List<OrderItem> orderItems=orderBiz.findByOrderItem(order.getOid());
		
		//��ֵ����ֵջ��
		ActionContext.getContext().getValueStack().set("orderItems", orderItems);
		
		return "findByOrderItem";
	}
	
	/**
	 * ���¶�����״̬
	 * @return
	 */
	public String updateOrderState() {
		
		//���ݶ�����oid��ѯ����
		Order orderUpdate=orderBiz.findByOid(order.getOid());
		orderUpdate.setState(3);
		
		//�ύ����
		orderBiz.updateOrderState(orderUpdate);
		
		return "updateOrderState";
	}
	
	/**
	 * ͨ��������oidɾ������
	 * @return
	 */
	public String deleteUserOrder() {
		
		//ͨ��oid��ѯ�û�����
		Order deleteOrder=orderBiz.findByOid(order.getOid());
		
		System.out.println("�û�����oidΪ��"+order.getOid());
		
		//���ö�����oidɾ���û�����
		orderBiz.deleteUserOrder(deleteOrder);
		
		return "deleteUserOrder";
	}
	
}
