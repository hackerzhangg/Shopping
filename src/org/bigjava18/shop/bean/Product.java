package org.bigjava18.shop.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * ��Ʒ��ʵ�������
 * @author zgp
 *
 */
public class Product implements Serializable{
	
	private Integer pid;				//��Ʒ��id
	private String pname;				//��Ʒ������
	private Double market_price;		//��Ʒ���г���
	private Double shop_price;			//��Ʒ�ļ۸�
	private String image;				//��Ʒ��ͼƬ
	private String pdesc;				//��Ʒ������
	private Integer is_hot;				//��Ʒ�Ƿ����ţ�������Ʒis_host = 1
	private Date pdate;					//��Ʒ������
	
	//��Ʒ����������ö����������
	private CategorySecond categorySecond;
	
	public CategorySecond getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getMarket_price() {
		return market_price;
	}

	public void setMarket_price(Double market_price) {
		this.market_price = market_price;
	}

	public Double getShop_price() {
		return shop_price;
	}

	public void setShop_price(Double shop_price) {
		this.shop_price = shop_price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Integer getIs_hot() {
		return is_hot;
	}

	public void setIs_hot(Integer is_hot) {
		this.is_hot = is_hot;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
				+ shop_price + ", image=" + image + ", pdesc=" + pdesc + ", is_hot=" + is_hot + ", pdate=" + pdate
				+ "]";
	}
	
}
