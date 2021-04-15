package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.Product;

/**
 * 商品的业务逻辑层接口
 * @author zgp
 *
 */
public interface ProductBiz {
	
	/**
	 * 首页查询热门商品
	 * @return
	 */
	public List<Product> findHot();
	
	/**
	 * 首页查询最新商品
	 * @return
	 */
	public List<Product> findNew();
	
	/**
	 * 通过商品的pid查询商品的详细
	 * @param pid
	 * @return
	 */
	public Product findByPid(Integer pid);
	
	/**
	 * 根据一级分类的cid查询商品:带分页
	 * @param cid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findByPageCid(Integer cid, int page);
	
	/**
	 * 根据二级分类的csid查询商品:带分页
	 * @param csid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findByPageCsid(Integer csid, int page);
	
	/**
	 * 查询所有商品，带分页
	 * @param page
	 * @return
	 */
	public PageBean<Product> productListPage(Integer page);
	
	/**
	 * 修改商品
	 * @param product
	 */
	public void update(Product product);
	
	/**
	 * 添加商品
	 * @param product
	 */
	public void saveProduct(Product product);
	
	/**
	 * 删除商品
	 * @param product
	 */
	public void deleteProduct(Product product);
	
	/**
	 * 后台查询商品的数量
	 * @return
	 */
	public int adminProductCount();
	
	/**
	 * 通过商品的名称模糊查询商品
	 * @param product
	 * @return
	 */
	public List<Product> findCondition(Product product);

}
