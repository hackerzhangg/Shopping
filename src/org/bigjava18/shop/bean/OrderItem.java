package org.bigjava18.shop.bean;

/**
 * 订单项维护表:订单和商品的关联关系是多对多
 * @author zgp
 *
 */
public class OrderItem {
	
	private Integer itemid;		//订单项的itemid
	private Integer count;		//订单项的数量
	private Double subtotal;	//订单项的小计
	
	//配置订单项的外键pid(订单项和商品的关联关系是一对多)
	private Product product;
	
	//配置订单项的外键oid(订单和订单项的关联关系是一对多)
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
