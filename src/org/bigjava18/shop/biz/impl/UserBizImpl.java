package org.bigjava18.shop.biz.impl;

import java.util.List;
import java.util.UUID;

import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.User;
import org.bigjava18.shop.biz.UserBiz;
import org.bigjava18.shop.common.SendEmailCommon;
import org.bigjava18.shop.common.UUIDUtils;
import org.bigjava18.shop.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户业务逻辑层接口实现类
 * @author zgp
 *
 */
@Transactional
public class UserBizImpl implements UserBiz{
	
	//在UserBizImpl中注入UserDao
	private UserDao userDao;
	
	//创建UserDao的set方法
	public void setUserDao(UserDao userDao) {
		
		this.userDao = userDao;
	}
	
	/**
	 * 通过用户名查询用户
	 */
	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public void save(User user) {
		//手动将数据存入到User实体中
		user.setState(0); 	// 0:代表用户未激活 1:代表用户已经激活
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		
		//将数据存入到数据库
		userDao.save(user);
		
		//发送激活邮件
		String activeLink = "http://localhost:8080/Shopping/user_active.action?code=" + user.getCode();
		String html = "欢迎"+user.getUsername()+"注册购物商城，请 <a href=\"" + activeLink+ "\">点击</a> 激活帐号";
		System.out.println("激活:" + html);
		SendEmailCommon.sendMail(user.getEmail(), html);
	}
	
	/**
	 * 登录用户
	 */
	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}
	
	/**
	 * 通过用户的激活码查询用户
	 */
	@Override
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}
	
	/**
	 * 用户更新成功，激活用户
	 */
	@Override
	public void updateUser(User existUser) {
		
		userDao.updateUser(existUser);
	}
	
	/**
	 * 通过用户的uid查询用户
	 */
	@Override
	public User findByUid(Integer uid) {
		
		return userDao.findByUid(uid);
	}
	
	/**
	 * 提交更新数据:更新个人数据
	 */
	@Override
	public void updateUserData(User user) {

		userDao.updateUserData(user);
	}
	
	/**
	 * 提交更新数据:更新个人数据，需要激活邮箱
	 */
	@Override
	public void saveUserUpdate(User user) {
		//手动将数据存入到User实体中
		user.setState(0); 	// 0:代表用户未激活 1:代表用户已经激活
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		
		//将更新数据提交到数据库
		userDao.saveUserUpdate(user);
		
		//发送激活邮件
		String activeLink = "http://localhost:8080/Shopping/user_active.action?code=" + user.getCode();
		String html = "欢迎"+user.getUsername()+"注册购物商城，请 <a href=\"" + activeLink+ "\">点击</a> 激活帐号";
		System.out.println("激活:" + html);
		SendEmailCommon.sendMail(user.getEmail(), html);
	}
	
	/**
	 * 后台查询所有用户带分页
	 */
	@Override
	public PageBean<User> findAllUser(Integer page) {
		
		//创建PagenBean实例对象
		PageBean<User> pageBean=new PageBean<User>();
		
		//设置当前页数
		pageBean.setPage(page);
		
		//设置页面的显示的大小
		int limit=5;
		pageBean.setLimit(limit);
		
		//设置用户的总数
		int userTotalCount=userDao.findUserCount();
		pageBean.setTotalCount(userTotalCount);
		
		//设置页面的总页数
		int totalPage=0;
		
		//判断总页数
		if(userTotalCount % limit == 0) {
			totalPage = userTotalCount / limit ;
		}else {
			totalPage = userTotalCount /limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//设置每页显示数据的集合
		int begin=(page - 1)*limit;		
		List<User> userList=userDao.findByPage(begin,limit);
		pageBean.setList(userList);
		
		return pageBean;
	}
	
	/**
	 * 通过用户的id更新用户
	 */
	@Override
	public void updateUserInfo(User user) {
		
		userDao.updateUserInfo(user);
	}
	
	/**
	 * 后台查询用户的数量
	 */
	@Override
	public int adminUserCount() {
		
		return userDao.findUserCount();
	}
	
	/**
	 * 通过用户的uid删除用户
	 */
	@Override
	public void deleteUser(User deleteUser) {

		userDao.deleteUser(deleteUser);
	}
	
}
