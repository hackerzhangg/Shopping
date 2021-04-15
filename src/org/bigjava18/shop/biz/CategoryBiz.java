package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.Category;

/**
 * һ������ҵ���߼���ӿ�
 * @author zgp
 *
 */
public interface CategoryBiz {
	
	/**
	 * ��ѯ����һ������
	 * @return
	 */
	public List<Category> findAll();
	
	/**
	 * ͨ��cid��ѯһ������
	 * @param cid
	 * @return
	 */
	public Category findByCid(Integer cid);
	
	/**
	 *  ����һ������
	 * @param category
	 */
	public void updateCategory(Category category);
	
	/**
	 * ���һ������
	 * @param category
	 */
	public void addCategory(Category category);
	
	/**
	 * ͨ��cidɾ��һ������
	 * @param category
	 */
	public void deleteCategory(Category category);
	
	/**
	 * ģ����ѯһ������
	 * @param category
	 * @return
	 */
	public List<Category> findCondition(Category category);

}
