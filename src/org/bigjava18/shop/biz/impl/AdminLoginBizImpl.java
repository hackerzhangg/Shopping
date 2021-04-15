package org.bigjava18.shop.biz.impl;

import org.bigjava18.shop.bean.AdminUser;
import org.bigjava18.shop.biz.AdminLoginBiz;
import org.bigjava18.shop.dao.AdminLoginDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * 后台用户登录业务逻辑层接口实现类
 * @author zgp
 *
 */
@Transactional
public class AdminLoginBizImpl implements AdminLoginBiz{
	
	//在AdminLoginBizImpl中注入AdminLoginDao
	private AdminLoginDao adminLoginDao;
	
	//创建adminLoginDao的set方法
	public void setAdminLoginDao(AdminLoginDao adminLoginDao) {
		
		this.adminLoginDao = adminLoginDao;
	}
	
	/**
	 * 管理员登录
	 */
	@Override
	public AdminUser adminLogin(AdminUser adminUser) {
		
		return adminLoginDao.adminLogin(adminUser);
	}
	
	/**
	 * 通过管理员的uid查询数据
	 */
	@Override
	public AdminUser adminInfoPage(Integer uid) {
		
		return adminLoginDao.adminInfoPage(uid);
	}
	
	/**
	 * 更新管理员信息
	 */
	@Override
	public void updateAdminUser(AdminUser adminUser) {

		adminLoginDao.updateAdminUser(adminUser);
	}
	
}
