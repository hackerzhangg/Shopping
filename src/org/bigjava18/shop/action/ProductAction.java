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
 * 商品的Action
 * @author zgp
 *
 */
public class ProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//创建Product实例对象
	private Product product=new Product();
	
	//使用模型驱动封装属性值
	@Override
	public Product getModel() {
		
		return product;
	}
	
	//在ProductAction注入ProductBiz
	private ProductBiz productBiz;
	
	//生成ProductBiz的set方法
	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}
	
	//使用属性封装接收当前所在页数
	private int page;
	
	//创建page的set方法
	public void setPage(int page) {
		
		this.page = page;
	}
	
	//使用属性封装接收一级分类的cid
	private Integer cid;
	
	//创建cid的get/set方法
	public Integer getCid() {

		return cid;
	}
	
	public void setCid(Integer cid) {
		
		this.cid = cid;
	}
	
	//使用属性封装接收二级分类的csid
	private Integer csid;
	
	//创建csid的get/set方法
	public Integer getCsid() {

		return csid;
	}
	
	public void setCsid(Integer csid) {
		
		this.csid = csid;
	}
	
	/**
	 * 通过商品的pid查询商品的详细
	 * @return
	 */
	public String findByPid() {
		
		//调用biz查询商品数据
		//Product:为模型驱动封装，直接存入值栈
		product=productBiz.findByPid(product.getPid());
		return "findByPid";
	}
	
	/**
	 * 根据一级分类的cid查询商品:带分页
	 * @return
	 */
	public String findByCid() {
		
		//调用biz根据一级分类的cid查询商品:带分页
		PageBean<Product> pageBean=productBiz.findByPageCid(cid,page);
		
		//将查询的pageBean放入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findByCid";
	}
	
	/**
	 * 根据二级分类的csid查询商品:带分页
	 * @return
	 */
	public String findByCsid() {
		
		//调用biz根据二级分类的csid查询商品:带分页
		PageBean<Product> pageBean=productBiz.findByPageCsid(csid,page);
				
		//将查询的pageBean放入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "findByCsid";
	}
	
	/**
	 * 通过商品的名称模糊查询商品
	 * @return
	 */
	public String findConditionProduct() {
		
		List<Product> products=productBiz.findCondition(product);
		
		//将查询的数据放入值栈
		ActionContext.getContext().getValueStack().set("products", products);
		//ServletActionContext.getRequest().getSession().setAttribute("products", products);
		System.out.println(products);
		
		return "findConditionProduct";
	}
	
}
