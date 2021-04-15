package org.bigjava18.shop.action;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.User;
import org.bigjava18.shop.biz.UserBiz;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 后台用户管理Action
 * @author zgp
 *
 */
public class AdminUserAction extends ActionSupport implements ModelDriven<User>{
	
	//创建User实例对象
	private User user=new User();

	//使用模型驱动封装属性值
	public User getModel() {
		
		return user;
	}
	
	//在AdminUserAction中注入UserBiz
	private UserBiz userBiz;

	public void setUserBiz(UserBiz userBiz) {
		
		this.userBiz = userBiz;
	}
	
	//使用属性封装接收前台page
	private Integer page;
	
	public void setPage(Integer page) {
		
		this.page = page;
	}

	/**
	 * 到用户列表页面
	 * @return
	 */
	public String userListPage() {
		
		//查询所有用户
		PageBean<User> pageBean=userBiz.findAllUser(page);
		
		//将查询到的用户保存到值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		
		return "userListPage";
	}
	
	/**
	 * 到用户更新页面
	 * @return
	 */
	public String updateUserPage() {
		
		User userData=userBiz.findByUid(user.getUid());
		
		//将用户数据保存到值域中
		ServletActionContext.getRequest().getSession().setAttribute("userData", userData);
		return "updateUserPage";
	}
	
	/**
	 * 通过用户的id更新用户
	 * @return
	 */
	public String updateUser() {
		
		userBiz.updateUserInfo(user);
		
		return "updateUser";
	}
	
	/**
	 * 通过用户的uid删除用户
	 * @return
	 */
	public String deleteUser() {
		
		User deleteUser=userBiz.findByUid(user.getUid());
		userBiz.deleteUser(deleteUser);
		
		return "deleteUser";
	}
	
}
