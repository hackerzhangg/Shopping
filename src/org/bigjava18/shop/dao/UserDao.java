package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.User;

/**
 * �û����ݿ���ʽӿ�
 * @author zgp
 *
 */
public interface UserDao {
	
	/**
	 * ͨ���û�����ѯ�û�
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
	
	/**
	 * �ύ�û�ע������
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
	 * @param existUser
	 */
	public void updateUser(User existUser);
	
	/**
	 * ͨ���û���uid��ѯ�û�
	 * @param uid
	 * @return
	 */
	public User findByUid(Integer uid);
	
	/**
	 * �ύ��������:���¸�������
	 * @param user
	 */
	public void updateUserData(User user);
	
	/**
	 * �ύ��������:���¸������ݣ���Ҫ��������
	 * @param user
	 */
	public void saveUserUpdate(User user);
	
	/**
	 * ��ѯ�û�������
	 * @return
	 */
	public int findUserCount();
	
	/**
	 * ��ѯ�û����ϴ���ҳ
	 * @param begin
	 * @param limit
	 * @return
	 */
	public List<User> findByPage(int begin, int limit);
	
	/**
	 * ͨ���û���id�����û�
	 * @param user
	 */
	public void updateUserInfo(User user);
	
	/**
	 * ͨ���û���uidɾ���û�
	 * @param deleteUser
	 */
	public void deleteUser(User deleteUser);

}
