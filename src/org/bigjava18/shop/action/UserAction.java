package org.bigjava18.shop.action;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.bigjava18.shop.bean.User;
import org.bigjava18.shop.biz.UserBiz;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 用户的Action
 * @author zgp
 *
 */
public class UserAction extends ActionSupport implements ModelDriven<User>{
	
	//创建User实例对象
	private User user=new User();
	
	//使用模型驱动封装前台的属性值
	@Override
	public User getModel() {
		
		return user;
	}
	
	//在UserAction中注入UserBiz
	private UserBiz userBiz;
	
	//创建UserBiz的set方法
	public void setUserBiz(UserBiz userBiz) {
		
		this.userBiz = userBiz;
	}
	
	//使用属性封装的方式获取前台输入的验证码
	private String checkcode;
	
	//创建checkcode属性的set方法
	public void setCheckcode(String checkcode) {
		
		this.checkcode = checkcode;
	}
	
	/**
	 * 到用户注册页面
	 * @return
	 */
	public String registerPage() {
		
		return "registerPage";
	}
	
	/**
	 * 利用Ajax异步校验用户名是否存在的执行方法
	 * @return
	 * @throws IOException
	 */
	public String findByName() throws IOException{
		
		//在后台中对传递的参数进行URLDecoder解码
		String username = URLDecoder.decode(user.getUsername(),"UTF-8");
		
		//调用Biz进行查询
		User existUser = userBiz.findByUsername(username);
		
		//获得response对象,向页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		
		//判断用户名是否存在
		if(existUser !=null) {
			//查询到该用户:用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}else {
			//没查询到该用户:用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		
		return NONE;
	}
	
	/**
	 * 提交用户注册数据
	 * @return
	 */
	public String register() {
		
		//判断验证码
		//从Session中获得验证码的随机值
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		
		//判断验证码是否相等
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			
			this.addActionError("验证码输入错误!");
			return "checkCodeFailRegister";
		}
		
		//保存注册用户
		userBiz.save(user);
		this.addActionMessage("注册成功!请去邮箱激活!");
		return "msg";
	}
	
	/**
	 * 用户注册激活的方法
	 * @return
	 */
	public String active() {
		
		//通过激活码查询用户
		User existUser=userBiz.findByCode(user.getCode());
		
		//判断用户existUser是否存在
		if(existUser == null) {
			//用户激活码错误
			this.addActionMessage("亲 ! 激活失败:激活码错误!");
		}else {
			//用户激活成功：修改用户状态为1
			existUser.setState(1);
			//修改用户的激活码为null
			existUser.setCode(null);
			userBiz.updateUser(existUser);
			this.addActionMessage("亲 ! 激活成功:请去登录!");
		}		
		return "msgActive";
	}
	
	/**
	 * 到用户登录页面
	 * @return
	 */
	public String loginPage() {
		
		return "loginPage";
	}
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login() {
		
		//判断验证码
		//从Session中获得验证码的随机值
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
				
		//判断验证码是否相等
		if(!checkcode.equalsIgnoreCase(checkcode1)){
			
			this.addActionError("验证码输入错误!");
			return "checkCodeFailLogin";
		}
		
		//调用Biz查询用户
		User existUser=userBiz.login(user);
		
		if(existUser == null) {
			// 登录失败
			this.addActionError("登录失败:用户名或密码错误或用户未激活!");
			return "login";
		}else {
			//登录成功
			//将用户的信息存入到session中
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			// 页面跳转
			return "loginSuccess";
		}
	}
	
	/**
	 * 用户退出登录：销毁session
	 * @return
	 */
	public String userQuit() {
		
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		
		return "userQuit";
	}
	
	/**
	 * 通过用户的uid查询用户
	 * @return
	 */
	public String updateUserInformationPage() {
		
		System.out.println("修改用户uid为:"+user.getUid());
		
		//通过用户的uid查询用户
		User existUser=userBiz.findByUid(user.getUid());
		System.out.println("通过用户uid查询数据为:"+existUser);
		
		if(existUser == null) {		//用户不存在
			
			//回到商城首页
			return "NofindUser";
		}else {			
			//将用户的信息保存到session
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			
			//到修改用户信息页面
			return "updateUserInformationPage";
		}
	}
	
	/**
	 * 用户更新数据：个人注册信息
	 * @return
	 */
	public String updateUserInformation() {
			
		System.out.println("用户提交更新数据为："+user);
		
		//从session中获取值
		User userSession=(User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		System.out.println("session中的取值为："+userSession);
		
		//判断邮箱是否更新：和session中的邮箱是否一致
		if(user.getEmail().equals(userSession.getEmail())) {
			
			System.out.println("用户邮箱是否一致："+user.getEmail().equals(userSession.getEmail()));
			//用户邮箱未修改更新即可登录
			user.setState(1);
			user.setCode(null);
			
			//提交更新数据
			userBiz.updateUserData(user);
			
			//销毁session:重新回到登录页面
			ServletActionContext.getRequest().getSession().invalidate();
			
			return "updateUserDataSuccess";
		}else {
			System.out.println("false:"+false);
			
			//用户邮箱修改：需要重新激活邮箱
			userBiz.saveUserUpdate(user);
			this.addActionMessage("亲：用户邮箱更新成功 请先去邮箱激活!");
			
			//销毁session:重新回到登录页面
			ServletActionContext.getRequest().getSession().invalidate();
			
			//到更新成功信息页面
			return "updateUserMsg";
		}
	}
	
}
