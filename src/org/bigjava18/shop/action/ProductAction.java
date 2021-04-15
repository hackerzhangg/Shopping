package org.bigjava18.shop.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.Product;
import org.bigjava18.shop.biz.CategoryBiz;
import org.bigjava18.shop.biz.ProductBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��Ʒ��Action
 * @author zgp
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//����Productʵ������
	private Product product=new Product();
	
	//ʹ��ģ��������װ����ֵ
	@Override
	public Product getModel() {
		
		return product;
	}
	
	//��ProductActionע��ProductBiz
	private ProductBiz productBiz;
	
	//����ProductBiz��set����
	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}
	
	//ʹ�����Է�װ���յ�ǰ����ҳ��
	private int page;
	
	//����page��set����
	public void setPage(int page) {
		
		this.page = page;
	}
	
	//ʹ�����Է�װ����һ�������cid
	private Integer cid;
	
	//����cid��get/set����
	public Integer getCid() {

		return cid;
	}
	
	public void setCid(Integer cid) {
		
		this.cid = cid;
	}
	
	//ʹ�����Է�װ���ն��������csid
	private Integer csid;
	
	//����csid��get/set����
	public Integer getCsid() {

		return csid;
	}
	
	public void setCsid(Integer csid) {
		
		this.csid = csid;
	}
	
	/**
	 * ͨ����Ʒ��pid��ѯ��Ʒ����ϸ
	 * @return
	 */
	public String findByPid() {
		
		//����biz��ѯ��Ʒ����
		//Product:Ϊģ��������װ��ֱ�Ӵ���ֵջ
		product=productBiz.findByPid(product.getPid());
		return "findByPid";
	}
	
	/**
	 * ����һ�������cid��ѯ��Ʒ:����ҳ
	 * @return
	 */
	public String findByCid() {
		
		//����biz����һ�������cid��ѯ��Ʒ:����ҳ
		PageBean<Product> pageBean=productBiz.findByPageCid(cid,page);
		
		//����ѯ��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findByCid";
	}
	
	/**
	 * ���ݶ��������csid��ѯ��Ʒ:����ҳ
	 * @return
	 */
	public String findByCsid() {
		
		//����biz���ݶ��������csid��ѯ��Ʒ:����ҳ
		PageBean<Product> pageBean=productBiz.findByPageCsid(csid,page);
				
		//����ѯ��pageBean����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findByCsid";
	}
	
	/**
	 * ͨ����Ʒ������ģ����ѯ��Ʒ
	 * @return
	 */
	public String findConditionProduct() {
		
		List<Product> products=productBiz.findCondition(product);
		
		//����ѯ�����ݷ���ֵջ
		ActionContext.getContext().getValueStack().set("products", products);
		//ServletActionContext.getRequest().getSession().setAttribute("products", products);
		System.out.println(products);
		
		return "findConditionProduct";
	}
	
}
