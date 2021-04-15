package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.biz.CategorySecondBiz;
import org.bigjava18.shop.dao.CategorySecondDao;

/**
 * 二级分类的业务逻辑层接口实现类
 * @author zgp
 *
 */
public class CategorySecondBizImpl implements CategorySecondBiz{
	
	//在CategorySecondBizImpl中注入CategorySecondDao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		
		this.categorySecondDao = categorySecondDao;
	}
	
	/**
	 * 查询所有的二级分类，带分页
	 */
	@Override
	public PageBean<CategorySecond> findAll(Integer page) {
		
		//创建PageBean实例对象
		PageBean<CategorySecond> pageBean=new PageBean<CategorySecond>();
		
		//设置当前的页数
		pageBean.setPage(page);
		
		//每页显示的条数
		int limit=10;
		pageBean.setLimit(limit);
		
		//设置二级分类总条数
		int totalCount=categorySecondDao.findCount();
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
		List<CategorySecond> categorySeconds=categorySecondDao.findByPage(begin,limit);
		pageBean.setList(categorySeconds);
		
		return pageBean;
	}
	
	/**
	 * 通过csid查询二级分类
	 */
	@Override
	public CategorySecond findByCsid(Integer csid) {
		
		return categorySecondDao.findByCsid(csid);
	}
	
	/**
	 * 更新二级分类
	 */
	@Override
	public void csUpdate(CategorySecond categorySecond) {
		
		categorySecondDao.csUpdate(categorySecond);
	}
	
	/**
	 * 添加二级分类
	 */
	@Override
	public void saveCsData(CategorySecond categorySecond) {

		categorySecondDao.saveCsData(categorySecond);
	}
	
	/**
	 * 查询所有的二级分类，不带分页
	 */
	@Override
	public List<CategorySecond> findAllData() {
		
		return categorySecondDao.findAllData();
	}
	
	/**
	 * 通过csid删除二级分类
	 */
	@Override
	public void deleteCategorySecond(CategorySecond categorySecond) {
		
		categorySecondDao.deleteCategorySecond(categorySecond);
	}
	
}
