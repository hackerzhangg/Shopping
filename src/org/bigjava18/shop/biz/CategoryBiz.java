package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.Category;

/**
 * 一级分类业务逻辑层接口
 * @author zgp
 *
 */
public interface CategoryBiz {
	
	/**
	 * 查询所有一级分类
	 * @return
	 */
	public List<Category> findAll();
	
	/**
	 * 通过cid查询一级分类
	 * @param cid
	 * @return
	 */
	public Category findByCid(Integer cid);
	
	/**
	 *  更新一级分类
	 * @param category
	 */
	public void updateCategory(Category category);
	
	/**
	 * 添加一级分类
	 * @param category
	 */
	public void addCategory(Category category);
	
	/**
	 * 通过cid删除一级分类
	 * @param category
	 */
	public void deleteCategory(Category category);
	
	/**
	 * 模糊查询一级分类
	 * @param category
	 * @return
	 */
	public List<Category> findCondition(Category category);

}
