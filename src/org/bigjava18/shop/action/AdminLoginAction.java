package org.bigjava18.shop.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.AdminUser;
import org.bigjava18.shop.bean.Message;
import org.bigjava18.shop.biz.AdminLoginBiz;
import org.bigjava18.shop.biz.MessageBiz;
import org.bigjava18.shop.biz.ProductBiz;
import org.bigjava18.shop.biz.UserBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 商城后台管理员登录Action
 * @author zgp
 *
 */
public class AdminLoginAction extends ActionSupport implements ModelDriven<AdminUser>{
	
	//创建AdminUser实例对象
	private AdminUser adminUser=new AdminUser();
	
	//使用模型驱动接收前台的表单值
	@Override
	public AdminUser getModel() {
		
		return adminUser;
	}
	
	//在AdminLoginAction中注入AdminLoginBiz
	private AdminLoginBiz adminLoginBiz;

	//创建adminLoginBiz的set方法
	public void setAdminLoginBiz(AdminLoginBiz adminLoginBiz) {
		
		this.adminLoginBiz = adminLoginBiz;
	}
	
	private UserBiz userBiz;
	
	public void setUserBiz(UserBiz userBiz) {
		
		this.userBiz = userBiz;
	}
	
	private ProductBiz productBiz;
	
	public void setProductBiz(ProductBiz productBiz) {
		
		this.productBiz = productBiz;
	}
	
	//在AdminLoginAction注入messageBiz
	private MessageBiz messageBiz;
	
	public void setMessageBiz(MessageBiz messageBiz) {
		
		this.messageBiz = messageBiz;
	}

	/**
	 * 到后台用户登录页面
	 * @return
	 */
	public String adminUserLoginPage() {
		
		//后台查询商品的数量
		int productCount=productBiz.adminProductCount();
		
		//放入值栈
		ActionContext.getContext().getSession().put("productCount", productCount);
		
		//后台查询用户的数量
		int userCount=userBiz.adminUserCount();
		
		//放入值栈
		ActionContext.getContext().getSession().put("userCount", userCount);
		
		//后台查询所有用户留言信息
		List<Message> messages=messageBiz.findAllMessage();
		System.out.println("用户留言信息为："+messages);
		
		//放入值栈
		ActionContext.getContext().getSession().put("messages", messages);
		
		return "adminUserLoginPage";
	}
	
	/**
	 * 管理员用户登录
	 * @return
	 */
	public String adminLogin() {
		
		//调用Biz实现管理员登录
		AdminUser admin=adminLoginBiz.adminLogin(adminUser);
		
		if(admin == null) {
			
			this.addActionError("管理员用户不存在，请重新输入！");
			return "adminFile";
		}else {
			
			//管理员用户登录成功，将用户放入到session值域中
			ServletActionContext.getRequest().getSession().setAttribute("admin", admin);			
			return "adminLogin";
		}
	}
	
	/**
	 * 到管理员的信息页面
	 * @return
	 */
	public String adminInfoPage() {
		
		//通过管理员的uid查询数据
		AdminUser admin=adminLoginBiz.adminInfoPage(adminUser.getUid());
		
		//放入值栈中
		ActionContext.getContext().getValueStack().set("admin", admin);
		
		return "adminInfoPage";
	}
	
	/**
	 * 更新管理员信息
	 * @return
	 */
	public String updateAdminUser() {
		
		adminLoginBiz.updateAdminUser(adminUser);	
		
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		
		return "updateAdminUser";
	}
	
	/**
	 * 管理员退出登录
	 * @return
	 */
	public String adminQuitLogin() {
		
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		
		//回到登录页面
		return "adminQuitLogin";
	}
	
}
