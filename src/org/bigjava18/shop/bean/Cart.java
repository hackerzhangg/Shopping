package org.bigjava18.shop.bean;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ���ﳵʵ�������
 * @author zgp
 *
 */
public class Cart implements Serializable{
	
	//������ϣ����У�Map�е�key������Ʒ��pid,value���ǹ�����
	Map<Integer, CartItem> map=new LinkedHashMap<Integer, CartItem>();
	
	//Cart��������һ�����Խ�cartItems����
	public Collection<CartItem> getCartItems(){
		
		return map.values();
	}
	
	//���ﳵ���ܼ�
	public double total;

	public double getTotal() {
		
		return total;
	}
	
	/**
	 * ���ﳵ���ܣ�����������ӵ����ﳵ
	 * @param cartItem
	 */
	public void addCart(CartItem cartItem) {
		
		// �жϹ��ﳵ���Ƿ��Ѿ����ڸù�����
		/*
		 *  * �������:
		 *  	* ��������
		 *  	* �ܼ� = �ܼ� + ������С��
		 *  * ���������:
		 *  	* ��map����ӹ�����
		 *  	* �ܼ� = �ܼ� + ������С��
		 */
		//�����Ʒpid
		Integer pid=cartItem.getProduct().getPid();
		
		//ͨ����Ʒ��pid�жϹ��ﳵ���Ƿ��Ѿ����ڸù�����
		if(map.containsKey(pid)) {
			
			//���ڹ�����:ͨ��pid��ȡ�����еĹ�����
			CartItem item=map.get(pid);
			item.setCount(item.getCount()+cartItem.getCount());			
		}else {
			//�����ڹ�����
			map.put(pid, cartItem);
		}
		//�����ܼƵļ۸�
		total += cartItem.getSubtotal();
	}
	
	/**
	 * �ӹ��ﳵ���Ƴ�������
	 * @param pid
	 */
	public void removeCart(Integer pid) {
		//��������ӹ��ﳵ���Ƴ�
		CartItem cartItem=map.remove(pid);
		//�ܼƣ� �ܼ�=�ܼ�-�Ƴ��������С��
		total -= cartItem.getSubtotal();
	}
	
	/**
	 * ��չ��ﳵ�еĹ�����
	 */
	public void clearCart() {
		
		//�����еĹ��������
		map.clear();
		//��պ��ܼ�total����Ϊ0
		total = 0;
	}
}
