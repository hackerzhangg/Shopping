package org.bigjava18.shop.biz;

import org.bigjava18.shop.bean.AdminUser;

/**
 * ��̨�û���¼ҵ���߼���ӿ�
 * @author zgp
 *
 */
public interface AdminLoginBiz {
	
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
