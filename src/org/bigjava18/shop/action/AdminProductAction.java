package org.bigjava18.shop.action;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.CategorySecond;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.Product;
import org.bigjava18.shop.biz.CategorySecondBiz;
import org.bigjava18.shop.biz.ProductBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * ��̨��Ʒ��Action
 * @author zgp
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//����Productʵ������
	private Product product=new Product();
	
	//ʹ��ģ��������װ����ֵ
	@Override
	public Product getModel() {
		
		return product;
	}
	
	//ʹ�����Է�װ����ǰ̨��ҳ��
	private Integer page;

	public void setPage(Integer page) {
		
		this.page = page;
	}
	
	//��AdminProductActionע��productBiz
	private ProductBiz productBiz;

	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}
	
	//��AdminProductAction��ע��CategorySecondBiz
	private CategorySecondBiz categorySecondBiz;
		
	public void setCategorySecondBiz(CategorySecondBiz categorySecondBiz) {
		
		this.categorySecondBiz = categorySecondBiz;
	}
	
	//Struts2�ļ��ϴ���Ҫ����������
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	/**
	 * ��̨��Ʒ�б�
	 * @return
	 */
	public String productListPage() {
		
		//��ѯ������Ʒ������ҳ
		PageBean<Product> pageBean=productBiz.productListPage(page);
		
		//����ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "productListPage";
	}
	
	/**
	 * ��������Ʒҳ��
	 * @return
	 */
	public String updateProductPage() {
		
		//��ѯ���еĶ�������
		List<CategorySecond> categorySeconds=categorySecondBiz.findAllData();
		
		//�����ݷ���ֵջ��
		ActionContext.getContext().getValueStack().set("categorySeconds", categorySeconds);
		
		//ͨ����Ʒ��pid��ѯ��Ʒ,��ʹ��ģ��������Ĭ�ϴ����ֵջֻ��
		product=productBiz.findByPid(product.getPid());
		
		return "updateProductPage";
	}
	
	/**
	 * �޸���Ʒ
	 * @return
	 * @throws IOException
	 */
	public String updateProduct() throws IOException {
		//������Ʒ���ϴ�ʱ��
		product.setPdate(new Date());
		
		//�ж��ϴ��ļ��Ƿ�Ϊ��
		if(upload != null ){
			String delPath = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
			File file = new File(delPath);
			file.delete();
			//�õ��ļ��ϴ��ķ�����·��
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			//�����ļ����Ͷ���
			File diskFile = new File(path + "//" + uploadFileName);
			//�ϴ��ļ�
			FileUtils.copyFile(upload, diskFile);

			product.setImage("products/" + uploadFileName);
		}
		//�ύ����
		productBiz.update(product);
		
		return "updateProduct";
	}
	
	/**
	 * �������Ʒ���б�
	 * @return
	 */
	public String addProductPage() {
		
		//��ѯ���еĶ�������
		List<CategorySecond> categorySeconds=categorySecondBiz.findAllData();
		
		//�����ݷ���ֵջ��
		ActionContext.getContext().getValueStack().set("categorySeconds", categorySeconds);
		
		return "addProductPage";
	}
	
	/**
	 * �����Ʒ
	 * @return
	 * @throws IOException 
	 */
	public String saveProduct() throws IOException {
		
		//����ϴ���Ʒ��ʱ����Ϣ
		product.setPdate(new Date());
		
		//�ж���Ʒ�Ƿ�Ϊ��
		if(upload != null){

			//����ƷͼƬ�ϴ����������ϣ�����ϴ�ͼƬ�ķ�������·��
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			// ����File�ļ����Ͷ���
			File diskFile = new File(path + "//" + uploadFileName);
			
			//�ϴ��ļ�
			FileUtils.copyFile(upload, diskFile);	
			product.setImage("products/" + uploadFileName);
		}
		
		productBiz.saveProduct(product);
		return "saveProduct";
	}
	
	/**
	 * ͨ����Ʒ��pidɾ����Ʒ
	 * @return
	 */
	public String deleteProduct() {
		
		//ͨ����Ʒ��pid��ѯ��Ʒ
		product=productBiz.findByPid(product.getPid());
		
		//ͬʱɾ����Ʒ��ͼƬ
		String path = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
		File file = new File(path);
		file.delete();
		
		//����Ʒ�����ݴ�������ɾ��
		productBiz.deleteProduct(product);
		
		return "deleteProduct";
	}
	
}
