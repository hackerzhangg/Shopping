package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.biz.CategorySecondBiz;
import org.bigjava18.shop.dao.CategorySecondDao;

/**
 * ���������ҵ���߼���ӿ�ʵ����
 * @author zgp
 *
 */
public class CategorySecondBizImpl implements CategorySecondBiz{
	
	//��CategorySecondBizImpl��ע��CategorySecondDao
	private CategorySecondDao categorySecondDao;

	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		
		this.categorySecondDao = categorySecondDao;
	}
	
	/**
	 * ��ѯ���еĶ������࣬����ҳ
	 */
	@Override
	public PageBean<CategorySecond> findAll(Integer page) {
		
		//����PageBeanʵ������
		PageBean<CategorySecond> pageBean=new PageBean<CategorySecond>();
		
		//���õ�ǰ��ҳ��
		pageBean.setPage(page);
		
		//ÿҳ��ʾ������
		int limit=10;
		pageBean.setLimit(limit);
		
		//���ö�������������
		int totalCount=categorySecondDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//������ʾҳ��
		int totalPage=0;
		if(totalCount % limit == 0) {
			
			totalPage = totalCount / limit;
		}else {
			
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//���ü���
		int begin=(page -1) * limit;
		List<CategorySecond> categorySeconds=categorySecondDao.findByPage(begin,limit);
		pageBean.setList(categorySeconds);
		
		return pageBean;
	}
	
	/**
	 * ͨ��csid��ѯ��������
	 */
	@Override
	public CategorySecond findByCsid(Integer csid) {
		
		return categorySecondDao.findByCsid(csid);
	}
	
	/**
	 * ���¶�������
	 */
	@Override
	public void csUpdate(CategorySecond categorySecond) {
		
		categorySecondDao.csUpdate(categorySecond);
	}
	
	/**
	 * ��Ӷ�������
	 */
	@Override
	public void saveCsData(CategorySecond categorySecond) {

		categorySecondDao.saveCsData(categorySecond);
	}
	
	/**
	 * ��ѯ���еĶ������࣬������ҳ
	 */
	@Override
	public List<CategorySecond> findAllData() {
		
		return categorySecondDao.findAllData();
	}
	
	/**
	 * ͨ��csidɾ����������
	 */
	@Override
	public void deleteCategorySecond(CategorySecond categorySecond) {
		
		categorySecondDao.deleteCategorySecond(categorySecond);
	}
	
}
