package org.bigjava18.shop.biz;

import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.User;

/**
 * �û�ҵ���߼���ӿ�
 * @author zgp
 *
 */
public interface UserBiz {
	
	/**
	 * ͨ���û�����ѯ�û�
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	
	/**
	 * ����û�
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * ��¼�û�
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * ͨ���û��ļ������ѯ�û�
	 * @param code
	 * @return
	 */
	public User findByCode(String code);
	
	/**
	 * �û����³ɹ��������û�
	 * @param user
	 */
	public void updateUser(User existUser);
	
	/**
	 * ͨ���û���uid��ѯ�û�
	 * @param uid
	 * @return
	 */
	public User findByUid(Integer uid);
	
	/**
	 *  �ύ��������:���¸�������
	 * @param user
	 */
	public void updateUserData(User user);
	
	/**
	 * �ύ��������:���¸������ݣ���Ҫ��������
	 * @param user
	 */
	public void saveUserUpdate(User user);
	
	/**
	 * ��̨��ѯ�����û�����ҳ
	 * @return
	 */
	public PageBean<User> findAllUser(Integer page);
	
	/**
	 * ͨ���û���id�����û�
	 * @param user
	 */
	public void updateUserInfo(User user);
	
	/**
	 * ��̨��ѯ�û�������
	 * @return
	 */
	public int adminUserCount();
	
	/**
	 * ͨ���û���uidɾ���û�
	 * @param deleteUser
	 */
	public void deleteUser(User deleteUser);

}
