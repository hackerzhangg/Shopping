package org.bigjava18.shop.bean;

/**
 * ������ά����:��������Ʒ�Ĺ�����ϵ�Ƕ�Զ�
 * @author zgp
 *
 */
public class OrderItem {
	
	private Integer itemid;		//�������itemid
	private Integer count;		//�����������
	private Double subtotal;	//�������С��
	
	//���ö���������pid(���������Ʒ�Ĺ�����ϵ��һ�Զ�)
	private Product product;
	
	//���ö���������oid(�����Ͷ�����Ĺ�����ϵ��һ�Զ�)
	private Order order;

	public Integer getItemid() {
		return itemid;
	}

	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Double subtotal) {
		this.subtotal = subtotal;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
}
