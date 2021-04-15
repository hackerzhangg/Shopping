package org.bigjava18.shop.bean;

import java.io.Serializable;

/**
 * ������ʵ����
 * @author zgp
 *
 */
public class CartItem {
	
	private Product product;	//��Ʒ������
	private int count;			//������Ʒ������
	private double subtotal;	//������Ʒ��С��

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
	
	//��Ʒ��С�ƣ���Ʒ������*��Ʒ�ĵ���(��Ʒ�Ĺ���۸�)
	//product.getShop_price():Ϊ��Ʒ�ĵ���
	public double getSubtotal() {
		
		return count * product.getShop_price();
	}

//	public void setSubtotal(double subtotal) {
//		this.subtotal = subtotal;
//	}
	
}
