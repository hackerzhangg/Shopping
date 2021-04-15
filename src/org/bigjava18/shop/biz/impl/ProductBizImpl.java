package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.Product;
import org.bigjava18.shop.biz.ProductBiz;
import org.bigjava18.shop.dao.ProductDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * ��Ʒ��ҵ���߼���ӿ�ʵ����
 * @author zgp
 *
 */
@Transactional
public class ProductBizImpl implements ProductBiz{
	
	//��ProductBizImplע��ProductDao
	private ProductDao productDao;
	
	//����ProductDao��set����
	public void setProductDao(ProductDao productDao) {
		
		this.productDao = productDao;
	}
	
	/**
	 * ��ҳ��ѯ������Ʒ
	 */
	@Override
	public List<Product> findHot() {
		
		return productDao.findHot();
	}
	
	/**
	 * ��ҳ��ѯ������Ʒ
	 */
	@Override
	public List<Product> findNew() {
		
		return productDao.findNew();
	}
	
	/**
	 * ͨ����Ʒ��pid��ѯ��Ʒ����ϸ
	 */
	@Override
	public Product findByPid(Integer pid) {
		
		return productDao.findByPid(pid);
	}
	
	/**
	 * ����һ�������cid��ѯ��Ʒ:����ҳ
	 */
	@Override
	public PageBean<Product> findByPageCid(Integer cid, int page) {
		
		//����PageBeanʵ������
		PageBean<Product> pageBean=new PageBean<Product>();
		
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit=8;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount=0;
		//��ѯ��Ʒ������
		totalCount=productDao.findCountCid(cid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage=0;
		//�ж�
		if(totalCount % limit == 0) {
			totalPage=totalCount / limit;
		}else {
			totalPage=totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//ÿҳ��ʾ�����ݼ���
		//�����￪ʼ��ѯ
		int begin= (page-1) * limit;
		List<Product> list=productDao.findByPageCid(cid, begin, limit);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * 
	 */
	@Override
	public PageBean<Product> findByPageCsid(Integer csid, int page) {
		
		//����PageBeanʵ������
		PageBean<Product> pageBean=new PageBean<Product>();
		
		//���õ�ǰҳ��
		pageBean.setPage(page);
		//����ÿҳ��ʾ�ļ�¼��
		int limit=8;
		pageBean.setLimit(limit);
		//�����ܼ�¼��
		int totalCount=0;
		//��ѯ��Ʒ������
		totalCount=productDao.findCountCsid(csid);
		pageBean.setTotalCount(totalCount);
		//������ҳ��
		int totalPage=0;
		//�ж�
		if(totalCount % limit == 0) {
			totalPage=totalCount / limit;
		}else {
			totalPage=totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//ÿҳ��ʾ�����ݼ���
		//�����￪ʼ��ѯ
		int begin= (page-1) * limit;
		List<Product> list=productDao.findByPageCsid(csid, begin, limit);
		pageBean.setList(list);
		
		return pageBean;
	}
	
	/**
	 * ��ѯ������Ʒ������ҳ
	 */
	@Override
	public PageBean<Product> productListPage(Integer page) {
		
		//����PageBeanʵ������
		PageBean<Product> pageBean=new PageBean<Product>();
		
		//���õ�ǰ��ҳ��
		pageBean.setPage(page);
		
		//ÿҳ��ʾ������
		int limit=10;
		pageBean.setLimit(limit);
		
		//������Ʒ������
		int totalCount=productDao.findCount();
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
		List<Product> products=productDao.findByPage(begin,limit);
		pageBean.setList(products);
		
		return pageBean;
	}
	
	/**
	 * �޸���Ʒ
	 */
	@Override
	public void update(Product product) {
		
		productDao.update(product);
	}
	
	/**
	 * �����Ʒ
	 */
	@Override
	public void saveProduct(Product product) {

		productDao.saveProduct(product);
	}
	
	/**
	 * ɾ����Ʒ
	 */
	@Override
	public void deleteProduct(Product product) {

		productDao.deleteProduct(product);
	}
	
	/**
	 * ��̨��ѯ��Ʒ������
	 */
	@Override
	public int adminProductCount() {
		
		return productDao.findCount();
	}
	
	/**
	 * ͨ����Ʒ������ģ����ѯ��Ʒ
	 */
	@Override
	public List<Product> findCondition(Product product) {
		
		return productDao.findCondition(product);
	}
	
}
