package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.AdminUser;
import org.bigjava18.shop.dao.AdminLoginDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 后台登录数据库访问接口实现类
 * @author zgp
 *
 */
public class AdminLoginDaoImpl extends HibernateDaoSupport implements AdminLoginDao{
	
	/**
	 * 管理员登录
	 */
	@Override
	public AdminUser adminLogin(AdminUser adminUser) {
		
		//编写sql查询语句
		String hql="from AdminUser where username=? and password=?";
		List<AdminUser> adminUsers=this.getHibernateTemplate().find(hql, adminUser.getUsername(),adminUser.getPassword());
		
		//判断adminUsers
		if(adminUsers !=null && adminUsers.size() > 0) {
			
			return adminUsers.get(0);
		}		
		return null;
	}
	
	/**
	 * 通过管理员的uid查询数据
	 */
	@Override
	public AdminUser adminInfoPage(Integer uid) {
		
		return this.getHibernateTemplate().get(AdminUser.class, uid);
	}
	
	/**
	 * 更新管理员信息
	 */
	@Override
	public void updateAdminUser(AdminUser adminUser) {

		this.getHibernateTemplate().update(adminUser);
	}

}
