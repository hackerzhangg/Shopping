package org.bigjava18.shop.bean;

import java.io.Serializable;

/**
 * 购物项实体类
 * @author zgp
 *
 */
public class CartItem {
	
	private Product product;	//商品的属性
	private int count;			//购买商品的数量
	private double subtotal;	//购买商品的小计

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	//商品的小计：商品的数量*商品的单价(商品的购买价格)
	//product.getShop_price():为商品的单价
	public double getSubtotal() {
		
		return count * product.getShop_price();
	}

//	public void setSubtotal(double subtotal) {
//		this.subtotal = subtotal;
//	}
	
}
