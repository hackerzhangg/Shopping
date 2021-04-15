package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.Product;
import org.bigjava18.shop.biz.ProductBiz;
import org.bigjava18.shop.dao.ProductDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * 商品的业务逻辑层接口实现类
 * @author zgp
 *
 */
@Transactional
public class ProductBizImpl implements ProductBiz{
	
	//在ProductBizImpl注入ProductDao
	private ProductDao productDao;
	
	//创建ProductDao的set方法
	public void setProductDao(ProductDao productDao) {
		
		this.productDao = productDao;
	}
	
	/**
	 * 首页查询热门商品
	 */
	@Override
	public List<Product> findHot() {
		
		return productDao.findHot();
	}
	
	/**
	 * 首页查询最新商品
	 */
	@Override
	public List<Product> findNew() {
		
		return productDao.findNew();
	}
	
	/**
	 * 通过商品的pid查询商品的详细
	 */
	@Override
	public Product findByPid(Integer pid) {
		
		return productDao.findByPid(pid);
	}
	
	/**
	 * 根据一级分类的cid查询商品:带分页
	 */
	@Override
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		
		//创建PageBean实例对象
		PageBean<Product> pageBean=new PageBean<Product>();
		
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit=8;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount=0;
		//查询商品的数量
		totalCount=productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
		//判断
		if(totalCount % limit == 0) {
			totalPage=totalCount / limit;
		}else {
			totalPage=totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//每页显示的数据集合
		//从哪里开始查询
		int begin= (page-1) * limit;
		List<Product> list=productDao.findByPageCid(cid, begin, limit);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * 
	 */
	@Override
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		
		//创建PageBean实例对象
		PageBean<Product> pageBean=new PageBean<Product>();
		
		//设置当前页数
		pageBean.setPage(page);
		//设置每页显示的记录数
		int limit=8;
		pageBean.setLimit(limit);
		//设置总记录数
		int totalCount=0;
		//查询商品的数量
		totalCount=productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage=0;
		//判断
		if(totalCount % limit == 0) {
			totalPage=totalCount / limit;
		}else {
			totalPage=totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//每页显示的数据集合
		//从哪里开始查询
		int begin= (page-1) * limit;
		List<Product> list=productDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * 查询所有商品，带分页
	 */
	@Override
	public PageBean<Product> productListPage(Integer page) {
		
		//创建PageBean实例对象
		PageBean<Product> pageBean=new PageBean<Product>();
		
		//设置当前的页数
		pageBean.setPage(page);
		
		//每页显示的条数
		int limit=10;
		pageBean.setLimit(limit);
		
		//设置商品总条数
		int totalCount=productDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//设置显示页数
		int totalPage=0;
		if(totalCount % limit == 0) {
			
			totalPage = totalCount / limit;
		}else {
			
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//设置集合
		int begin=(page -1) * limit;
		List<Product> products=productDao.findByPage(begin,limit);
		pageBean.setList(products);
		
		return pageBean;
	}
	
	/**
	 * 修改商品
	 */
	@Override
	public void update(Product product) {
		
		productDao.update(product);
	}
	
	/**
	 * 添加商品
	 */
	@Override
	public void saveProduct(Product product) {

		productDao.saveProduct(product);
	}
	
	/**
	 * 删除商品
	 */
	@Override
	public void deleteProduct(Product product) {

		productDao.deleteProduct(product);
	}
	
	/**
	 * 后台查询商品的数量
	 */
	@Override
	public int adminProductCount() {
		
		return productDao.findCount();
	}
	
	/**
	 * 通过商品的名称模糊查询商品
	 */
	@Override
	public List<Product> findCondition(Product product) {
		
		return productDao.findCondition(product);
	}
	
}
