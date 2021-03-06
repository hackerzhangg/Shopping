package org.bigjava18.shop.dao;

import org.bigjava18.shop.bean.AdminUser;

/**
 * 后台登录数据库访问接口
 * @author zgp
 *
 */
public interface AdminLoginDao {
	
	/**
	 * 管理员登录
	 * @param adminUser
	 * @return
	 */
	public AdminUser adminLogin(AdminUser adminUser);
	
	/**
	 * 通过管理员的uid查询数据
	 * @param uid
	 * @return
	 */
	public AdminUser adminInfoPage(Integer uid);
	
	/**
	 * 更新管理员信息
	 * @param adminUser
	 */
	public void updateAdminUser(AdminUser adminUser);

}
