package org.bigjava18.shop.action;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.Cart;
import org.bigjava18.shop.bean.CartItem;
import org.bigjava18.shop.bean.Product;
import org.bigjava18.shop.biz.ProductBiz;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ���ﳵ��Action
 * @author zgp
 *
 */
public class CartAction extends ActionSupport{
	
	//��CartActionע��ProductBiz
	private ProductBiz productBiz;
	
	//����productBiz��set����
	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}
	
	//ʹ�����Է�װ������Ʒ��pid
	private Integer pid;
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	//ʹ�����Է�װ������Ʒ���������
	private Integer count;
	
	public void setCount(Integer count) {
		
		this.count = count;
	}
	
	/**
	 * ����������ӵ����ﳵ
	 * @return
	 */
	public String addCart() {
		
		//����CartItemʵ������
		CartItem cartItem=new CartItem();
		
		//��װ������Ʒ����
		cartItem.setCount(count);
		
		//ͨ����Ʒ��pid��ѯ��Ʒ
		Product product=productBiz.findByPid(pid);
		
		//������Ʒ
		cartItem.setProduct(product);
		
		//����������ӵ����ﳵ�У����ﳵ�����session��
		Cart cart = getCart();
		cart.addCart(cartItem);
		
		return "addCart";
	}

	/**
	 * �Ƴ����ﳵ�еĹ�����
	 * @return
	 */
	public String removeCart() {
		
		//��ù��ﳵ����
		Cart cart=getCart();
		
		//���ù��ﳵ�еķ����Ƴ�������
		cart.removeCart(pid);
		
		return "removeCart";
	}
	
	/**
	 * ��չ��ﳵ
	 * @return
	 */
	public String clearCart() {
		
		//��ù��ﳵ����
		Cart cart=getCart();
		
		//���ù��ﳵ�еķ�����չ��ﳵ
		cart.clearCart();
		
		return "clearCart";
	}

	/**
	 * ���ҵĹ��ﳵҳ��
	 * @return
	 */
	public String MyCart() {
		
		return "MyCart";
	}
	
	/**
	 * ��ù��ﳵ����session�л�ù��ﳵ
	 * @return
	 */
	public Cart getCart() {
		
		//��session�л��
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		//�жϹ��ﳵ���Ƿ�Ϊ��
		if(cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		
		return cart;
	}

}
