package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.bean.PageBean;

/**
 * ���������ҵ���߼���ӿ�
 * @author zgp
 *
 */
public interface CategorySecondBiz {
	
	/**
	 * ��ѯ���еĶ������࣬����ҳ
	 * @return
	 */
	public PageBean<CategorySecond> findAll(Integer page);
	
	/**
	 * ͨ��csid��ѯ��������
	 * @param csid
	 * @return
	 */
	public CategorySecond findByCsid(Integer csid);
	
	/**
	 * ���¶�������
	 * @param categorySecond
	 */
	public void csUpdate(CategorySecond categorySecond);
	
	/**
	 * ��Ӷ�������
	 * @param categorySecond
	 */
	public void saveCsData(CategorySecond categorySecond);
	
	/**
	 * ��ѯ���еĶ������࣬������ҳ
	 * @return
	 */
	public List<CategorySecond> findAllData();
	
	/**
	 * ͨ��csidɾ����������
	 * @param categorySecond
	 */
	public void deleteCategorySecond(CategorySecond categorySecond);

}
