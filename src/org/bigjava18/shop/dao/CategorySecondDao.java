package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;

/**
 * 二级分类的数据库访问接口
 * @author zgp
 *
 */
public interface CategorySecondDao {
	
	/**
	 * 查询二级分类的条数
	 * @return
	 */
	public int findCount();
	
	/**
	 * 查询二级分类集合
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<CategorySecond> findByPage(int begin, int limit);
	
	/**
	 * 通过csid查询二级分类
	 * @param csid
	 * @return
	 */
	public CategorySecond findByCsid(Integer csid);
	
	/**
	 * 更新二级分类
	 * @param categorySecond
	 */
	public void csUpdate(CategorySecond categorySecond);
	
	/**
	 * 添加二级分类
	 * @param categorySecond
	 */
	public void saveCsData(CategorySecond categorySecond);
	
	/**
	 * 查询所有的二级分类，不带分页
	 * @return
	 */
	public List<CategorySecond> findAllData();
	
	/**
	 * 通过csid删除二级分类
	 * @param categorySecond
	 */
	public void deleteCategorySecond(CategorySecond categorySecond);

}
