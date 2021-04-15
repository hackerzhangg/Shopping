package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.AdminUser;
import org.bigjava18.shop.dao.AdminLoginDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * ��̨��¼���ݿ���ʽӿ�ʵ����
 * @author zgp
 *
 */
public class AdminLoginDaoImpl extends HibernateDaoSupport implements AdminLoginDao{
	
	/**
	 * ����Ա��¼
	 */
	@Override
	public AdminUser adminLogin(AdminUser adminUser) {
		
		//��дsql��ѯ���
		String hql="from AdminUser where username=? and password=?";
		List<AdminUser> adminUsers=this.getHibernateTemplate().find(hql, adminUser.getUsername(),adminUser.getPassword());
		
		//�ж�adminUsers
		if(adminUsers !=null && adminUsers.size() > 0) {
			
			return adminUsers.get(0);
		}		
		return null;
	}
	
	/**
	 * ͨ������Ա��uid��ѯ����
	 */
	@Override
	public AdminUser adminInfoPage(Integer uid) {
		
		return this.getHibernateTemplate().get(AdminUser.class, uid);
	}
	
	/**
	 * ���¹���Ա��Ϣ
	 */
	@Override
	public void updateAdminUser(AdminUser adminUser) {

		this.getHibernateTemplate().update(adminUser);
	}

}
