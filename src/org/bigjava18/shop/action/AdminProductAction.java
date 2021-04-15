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
 * 后台商品的Action
 * @author zgp
 *
 */
public class AdminProductAction extends ActionSupport implements ModelDriven<Product>{
	
	//创建Product实例对象
	private Product product=new Product();
	
	//使用模型驱动封装属性值
	@Override
	public Product getModel() {
		
		return product;
	}
	
	//使用属性封装接收前台的页数
	private Integer page;

	public void setPage(Integer page) {
		
		this.page = page;
	}
	
	//在AdminProductAction注入productBiz
	private ProductBiz productBiz;

	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}
	
	//在AdminProductAction中注入CategorySecondBiz
	private CategorySecondBiz categorySecondBiz;
		
	public void setCategorySecondBiz(CategorySecondBiz categorySecondBiz) {
		
		this.categorySecondBiz = categorySecondBiz;
	}
	
	//Struts2文件上传需要的三个属性
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
	 * 后台商品列表
	 * @return
	 */
	public String productListPage() {
		
		//查询所有商品，带分页
		PageBean<Product> pageBean=productBiz.productListPage(page);
		
		//存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "productListPage";
	}
	
	/**
	 * 到更新商品页面
	 * @return
	 */
	public String updateProductPage() {
		
		//查询所有的二级分类
		List<CategorySecond> categorySeconds=categorySecondBiz.findAllData();
		
		//将数据放入值栈中
		ActionContext.getContext().getValueStack().set("categorySeconds", categorySeconds);
		
		//通过商品的pid查询商品,因使用模型驱动，默认存放在值栈只中
		product=productBiz.findByPid(product.getPid());
		
		return "updateProductPage";
	}
	
	/**
	 * 修改商品
	 * @return
	 * @throws IOException
	 */
	public String updateProduct() throws IOException {
		//更新商品的上传时间
		product.setPdate(new Date());
		
		//判断上传文件是否为空
		if(upload != null ){
			String delPath = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
			File file = new File(delPath);
			file.delete();
			//得到文件上传的服务器路径
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			//创建文件类型对象
			File diskFile = new File(path + "//" + uploadFileName);
			//上传文件
			FileUtils.copyFile(upload, diskFile);

			product.setImage("products/" + uploadFileName);
		}
		//提交更新
		productBiz.update(product);
		
		return "updateProduct";
	}
	
	/**
	 * 到添加商品的列表
	 * @return
	 */
	public String addProductPage() {
		
		//查询所有的二级分类
		List<CategorySecond> categorySeconds=categorySecondBiz.findAllData();
		
		//将数据放入值栈中
		ActionContext.getContext().getValueStack().set("categorySeconds", categorySeconds);
		
		return "addProductPage";
	}
	
	/**
	 * 添加商品
	 * @return
	 * @throws IOException 
	 */
	public String saveProduct() throws IOException {
		
		//添加上传商品的时间信息
		product.setPdate(new Date());
		
		//判断商品是否为空
		if(upload != null){

			//将商品图片上传到服务器上，获得上传图片的服务器端路径
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			// 创建File文件类型对象
			File diskFile = new File(path + "//" + uploadFileName);
			
			//上传文件
			FileUtils.copyFile(upload, diskFile);	
			product.setImage("products/" + uploadFileName);
		}
		
		productBiz.saveProduct(product);
		return "saveProduct";
	}
	
	/**
	 * 通过商品的pid删除商品
	 * @return
	 */
	public String deleteProduct() {
		
		//通过商品的pid查询商品
		product=productBiz.findByPid(product.getPid());
		
		//同时删除商品的图片
		String path = ServletActionContext.getServletContext().getRealPath("/" + product.getImage());
		File file = new File(path);
		file.delete();
		
		//将商品的数据从数据中删掉
		productBiz.deleteProduct(product);
		
		return "deleteProduct";
	}
	
}
