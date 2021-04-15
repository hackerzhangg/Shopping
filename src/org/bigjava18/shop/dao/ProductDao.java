package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.Product;

/**
 * 商品的数据库访问接口
 * @author zgp
 *
 */
public interface ProductDao {
	
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
	 * 根据一级分类的cid查询商品数量
	 * @param cid
	 * @return
	 */
	public int findCountCid(Integer cid);
	
	/**
	 * 根据一级分类的cid查询商品集合
	 * @param cid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPageCid(Integer cid, int begin, int limit);
	
	/**
	 * 根据二级分类的csid查询商品数量
	 * @param csid
	 * @return
	 */
	public int findCountCsid(Integer csid);
	
	/**
	 * 根据二级分类的csid查询商品集合
	 * @param csid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPageCsid(Integer csid, int begin, int limit);
	
	/**
	 * 商品总条数
	 * @return
	 */
	public int findCount();
	
	/**
	 * 商品的集合
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPage(int begin, int limit);
	
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
	 * 通过商品的名称模糊查询商品
	 * @param product
	 * @return
	 */
	public List<Product> findCondition(Product product);
	
}
