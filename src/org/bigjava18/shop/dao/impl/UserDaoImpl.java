package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.User;
import org.bigjava18.shop.common.PageHibernateCallback;
import org.bigjava18.shop.dao.UserDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 用户数据库访问接口实现类
 * @author zgp
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	/**
	 * 通过用户名查询用户
	 */
	@Override
	public User findByUsername(String username) {
		
		//编写sql语句
		String hql="from User where username=?";
		
		//执行查询语句
		List<User> users=this.getHibernateTemplate().find(hql,username);
		
		//判断list
		if(users !=null && users.size()>0) {
			
			return users.get(0);
		}
		return null;
	}
	
	/**
	 * 提交用户注册数据
	 */
	@Override
	public void save(User user) {
		
		this.getHibernateTemplate().save(user);
	}
	
	/**
	 * 登录用户
	 */
	@Override
	public User login(User user) {
		
		//编写hql查询语句
		String hql="from User where username=? and password=? and state=?";
		
		//执行查询语句
		List<User> userList=this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword(),1);
		
		//判断userList
		if(userList !=null && userList.size() > 0) {
			
			return userList.get(0);
		}		
		return null;
	}
	
	/**
	 * 通过用户的激活码查询用户
	 */
	@Override
	public User findByCode(String code) {
		
		//编写查询sql
		String hql="from User where code= ?";
		
		//执行查询的方法
		List<User> userList=this.getHibernateTemplate().find(hql,code);
		
		//判断用户userList
		if(userList !=null && userList.size() > 0) {
			
			return userList.get(0);
		}		
		return null;
	}
	
	/**
	 * 用户更新成功，激活用户
	 */
	@Override
	public void updateUser(User existUser) {

		this.getHibernateTemplate().update(existUser);
	}
	
	/**
	 * 通过用户的uid查询用户
	 */
	@Override
	public User findByUid(Integer uid) {
		
//		//编写sql
//		String hql="from User where uid= ?";
//		
//		//执行通过用户的uid查询用户
//		List<User> userList=this.getHibernateTemplate().find(hql,uid);
//		
//		//判断userList
//		if(userList !=null && userList.size() > 0) {
//			
//			return userList.get(0);
//		}
//		return null;
		
		return this.getHibernateTemplate().get(User.class, uid);
	}
	
	/**
	 * 提交更新数据:更新个人数据
	 */
	@Override
	public void updateUserData(User user) {

		this.getHibernateTemplate().update(user);
	}
	
	/**
	 * 提交更新数据:更新个人数据，需要激活邮箱
	 */
	@Override
	public void saveUserUpdate(User user) {
		
		this.getHibernateTemplate().update(user);
	}
	
	/**
	 * 查询用户的数量
	 */
	@Override
	public int findUserCount() {
		
		String hql="select count(*) from User";
		List<Long> count = this.getHibernateTemplate().find(hql);
		
		if(count != null && count.size() > 0) {
			
			return count.get(0).intValue();
		}		
		return 0;
	}
	
	/**
	 * 查询用户集合带分页
	 */
	@Override
	public List<User> findByPage(int begin, int limit) {
		
		String hql="from User";
		List<User> list=this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, null, begin, limit));
		
		return list;
	}
	
	/**
	 * 通过用户的id更新用户
	 */
	@Override
	public void updateUserInfo(User user) {

		this.getHibernateTemplate().update(user);
	}
	
	/**
	 * 通过用户的uid删除用户
	 */
	@Override
	public void deleteUser(User deleteUser) {

		this.getHibernateTemplate().delete(deleteUser);
	}

}
