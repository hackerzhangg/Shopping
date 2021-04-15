package org.bigjava18.shop.action;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.Cart;
import org.bigjava18.shop.bean.CartItem;
import org.bigjava18.shop.bean.Product;
import org.bigjava18.shop.biz.ProductBiz;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 购物车的Action
 * @author zgp
 *
 */
public class CartAction extends ActionSupport{
	
	//在CartAction注入ProductBiz
	private ProductBiz productBiz;
	
	//创建productBiz的set方法
	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}
	
	//使用属性封装接收商品的pid
	private Integer pid;
	
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	//使用属性封装接收商品购买的数量
	private Integer count;
	
	public void setCount(Integer count) {
		
		this.count = count;
	}
	
	/**
	 * 将购物项添加到购物车
	 * @return
	 */
	public String addCart() {
		
		//创建CartItem实例对象
		CartItem cartItem=new CartItem();
		
		//封装购买商品数量
		cartItem.setCount(count);
		
		//通过商品的pid查询商品
		Product product=productBiz.findByPid(pid);
		
		//设置商品
		cartItem.setProduct(product);
		
		//将购物项添加到购物车中，购物车存放在session中
		Cart cart = getCart();
		cart.addCart(cartItem);
		
		return "addCart";
	}

	/**
	 * 移除购物车中的购物项
	 * @return
	 */
	public String removeCart() {
		
		//获得购物车对象
		Cart cart=getCart();
		
		//调用购物车中的方法移除购物项
		cart.removeCart(pid);
		
		return "removeCart";
	}
	
	/**
	 * 清空购物车
	 * @return
	 */
	public String clearCart() {
		
		//获得购物车对象
		Cart cart=getCart();
		
		//调用购物车中的方法清空购物车
		cart.clearCart();
		
		return "clearCart";
	}

	/**
	 * 到我的购物车页面
	 * @return
	 */
	public String MyCart() {
		
		return "MyCart";
	}
	
	/**
	 * 获得购物车：从session中获得购物车
	 * @return
	 */
	public Cart getCart() {
		
		//在session中获得
		Cart cart=(Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		
		//判断购物车中是否为空
		if(cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		
		return cart;
	}

}
