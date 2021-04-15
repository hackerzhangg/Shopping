package org.bigjava18.shop.dao;

import org.bigjava18.shop.bean.AdminUser;

/**
 * ��̨��¼���ݿ���ʽӿ�
 * @author zgp
 *
 */
public interface AdminLoginDao {
	
	/**
	 * ����Ա��¼
	 * @param adminUser
	 * @return
	 */
	public AdminUser adminLogin(AdminUser adminUser);
	
	/**
	 * ͨ������Ա��uid��ѯ����
	 * @param uid
	 * @return
	 */
	public AdminUser adminInfoPage(Integer uid);
	
	/**
	 * ���¹���Ա��Ϣ
	 * @param adminUser
	 */
	public void updateAdminUser(AdminUser adminUser);

}
