package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;

/**
 * ������������ݿ���ʽӿ�
 * @author zgp
 *
 */
public interface CategorySecondDao {
	
	/**
	 * ��ѯ�������������
	 * @return
	 */
	public int findCount();
	
	/**
	 * ��ѯ�������༯��
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<CategorySecond> findByPage(int begin, int limit);
	
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
