package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.Product;

/**
 * ��Ʒ�����ݿ���ʽӿ�
 * @author zgp
 *
 */
public interface ProductDao {
	
	/**
	 * ��ҳ��ѯ������Ʒ
	 * @return
	 */
	public List<Product> findHot();
	
	/**
	 * ��ҳ��ѯ������Ʒ
	 * @return
	 */
	public List<Product> findNew();
	
	/**
	 * ͨ����Ʒ��pid��ѯ��Ʒ����ϸ
	 * @param pid
	 * @return
	 */
	public Product findByPid(Integer pid);
	
	/**
	 * ����һ�������cid��ѯ��Ʒ����
	 * @param cid
	 * @return
	 */
	public int findCountCid(Integer cid);
	
	/**
	 * ����һ�������cid��ѯ��Ʒ����
	 * @param cid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPageCid(Integer cid, int begin, int limit);
	
	/**
	 * ���ݶ��������csid��ѯ��Ʒ����
	 * @param csid
	 * @return
	 */
	public int findCountCsid(Integer csid);
	
	/**
	 * ���ݶ��������csid��ѯ��Ʒ����
	 * @param csid
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPageCsid(Integer csid, int begin, int limit);
	
	/**
	 * ��Ʒ������
	 * @return
	 */
	public int findCount();
	
	/**
	 * ��Ʒ�ļ���
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<Product> findByPage(int begin, int limit);
	
	/**
	 * �޸���Ʒ
	 * @param product
	 */
	public void update(Product product);
	
	/**
	 * �����Ʒ
	 * @param product
	 */
	public void saveProduct(Product product);
	
	/**
	 * ɾ����Ʒ
	 * @param product
	 */
	public void deleteProduct(Product product);
	
	/**
	 * ͨ����Ʒ������ģ����ѯ��Ʒ
	 * @param product
	 * @return
	 */
	public List<Product> findCondition(Product product);
	
}
