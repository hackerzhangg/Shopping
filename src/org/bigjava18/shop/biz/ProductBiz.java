package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.Product;

/**
 * ��Ʒ��ҵ���߼���ӿ�
 * @author zgp
 *
 */
public interface ProductBiz {
	
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
	 * ����һ�������cid��ѯ��Ʒ:����ҳ
	 * @param cid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findByPageCid(Integer cid, int page);
	
	/**
	 * ���ݶ��������csid��ѯ��Ʒ:����ҳ
	 * @param csid
	 * @param page
	 * @return
	 */
	public PageBean<Product> findByPageCsid(Integer csid, int page);
	
	/**
	 * ��ѯ������Ʒ������ҳ
	 * @param page
	 * @return
	 */
	public PageBean<Product> productListPage(Integer page);
	
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
	 * ��̨��ѯ��Ʒ������
	 * @return
	 */
	public int adminProductCount();
	
	/**
	 * ͨ����Ʒ������ģ����ѯ��Ʒ
	 * @param product
	 * @return
	 */
	public List<Product> findCondition(Product product);

}
