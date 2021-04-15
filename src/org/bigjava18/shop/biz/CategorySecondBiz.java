package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.bean.PageBean;

/**
 * 二级分类的业务逻辑层接口
 * @author zgp
 *
 */
public interface CategorySecondBiz {
	
	/**
	 * 查询所有的二级分类，带分页
	 * @return
	 */
	public PageBean<CategorySecond> findAll(Integer page);
	
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
