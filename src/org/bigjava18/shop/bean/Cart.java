package org.bigjava18.shop.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 购物车实体类对象
 * @author zgp
 *
 */
public class Cart implements Serializable{
	
	//购物项集合：其中：Map中的key就是商品的pid,value就是购物项
	Map<Integer, CartItem> map=new LinkedHashMap<Integer, CartItem>();
	
	//Cart对象中有一个属性叫cartItems属性
	public Collection<CartItem> getCartItems(){
		
		return map.values();
	}
	
	//购物车的总计
	public double total;

	public double getTotal() {
		
		return total;
	}
	
	/**
	 * 购物车功能：将购物项添加到购物车
	 * @param cartItem
	 */
	public void addCart(CartItem cartItem) {
		
		// 判断购物车中是否已经存在该购物项
		/*
		 *  * 如果存在:
		 *  	* 数量增加
		 *  	* 总计 = 总计 + 购物项小计
		 *  * 如果不存在:
		 *  	* 向map中添加购物项
		 *  	* 总计 = 总计 + 购物项小计
		 */
		//获得商品pid
		Integer pid=cartItem.getProduct().getPid();
		
		//通过商品的pid判断购物车中是否已经存在该购物项
		if(map.containsKey(pid)) {
			
			//存在购物项:通过pid获取集合中的购物项
			CartItem item=map.get(pid);
			item.setCount(item.getCount()+cartItem.getCount());			
		}else {
			//不存在购物项
			map.put(pid, cartItem);
		}
		//计算总计的价格
		total += cartItem.getSubtotal();
	}
	
	/**
	 * 从购物车中移除购物项
	 * @param pid
	 */
	public void removeCart(Integer pid) {
		//将购物项从购物车中移除
		CartItem cartItem=map.remove(pid);
		//总计： 总计=总计-移除购物项的小计
		total -= cartItem.getSubtotal();
	}
	
	/**
	 * 清空购物车中的购物项
	 */
	public void clearCart() {
		
		//将所有的购物项清空
		map.clear();
		//清空后总计total设置为0
		total = 0;
	}
}
