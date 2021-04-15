package org.bigjava18.shop.biz.impl;

import org.bigjava18.shop.bean.AdminUser;
import org.bigjava18.shop.biz.AdminLoginBiz;
import org.bigjava18.shop.dao.AdminLoginDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * ��̨�û���¼ҵ���߼���ӿ�ʵ����
 * @author zgp
 *
 */
@Transactional
public class AdminLoginBizImpl implements AdminLoginBiz{
	
	//��AdminLoginBizImpl��ע��AdminLoginDao
	private AdminLoginDao adminLoginDao;
	
	//����adminLoginDao��set����
	public void setAdminLoginDao(AdminLoginDao adminLoginDao) {
		
		this.adminLoginDao = adminLoginDao;
	}
	
	/**
	 * ����Ա��¼
	 */
	@Override
	public AdminUser adminLogin(AdminUser adminUser) {
		
		return adminLoginDao.adminLogin(adminUser);
	}
	
	/**
	 * ͨ������Ա��uid��ѯ����
	 */
	@Override
	public AdminUser adminInfoPage(Integer uid) {
		
		return adminLoginDao.adminInfoPage(uid);
	}
	
	/**
	 * ���¹���Ա��Ϣ
	 */
	@Override
	public void updateAdminUser(AdminUser adminUser) {

		adminLoginDao.updateAdminUser(adminUser);
	}
	
}
