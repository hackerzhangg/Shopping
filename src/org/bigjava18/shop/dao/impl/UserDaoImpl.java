package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.User;
import org.bigjava18.shop.common.PageHibernateCallback;
import org.bigjava18.shop.dao.UserDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * �û����ݿ���ʽӿ�ʵ����
 * @author zgp
 *
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	/**
	 * ͨ���û�����ѯ�û�
	 */
	@Override
	public User findByUsername(String username) {
		
		//��дsql���
		String hql="from User where username=?";
		
		//ִ�в�ѯ���
		List<User> users=this.getHibernateTemplate().find(hql,username);
		
		//�ж�list
		if(users !=null && users.size()>0) {
			
			return users.get(0);
		}
		return null;
	}
	
	/**
	 * �ύ�û�ע������
	 */
	@Override
	public void save(User user) {
		
		this.getHibernateTemplate().save(user);
	}
	
	/**
	 * ��¼�û�
	 */
	@Override
	public User login(User user) {
		
		//��дhql��ѯ���
		String hql="from User where username=? and password=? and state=?";
		
		//ִ�в�ѯ���
		List<User> userList=this.getHibernateTemplate().find(hql,user.getUsername(),user.getPassword(),1);
		
		//�ж�userList
		if(userList !=null && userList.size() > 0) {
			
			return userList.get(0);
		}		
		return null;
	}
	
	/**
	 * ͨ���û��ļ������ѯ�û�
	 */
	@Override
	public User findByCode(String code) {
		
		//��д��ѯsql
		String hql="from User where code= ?";
		
		//ִ�в�ѯ�ķ���
		List<User> userList=this.getHibernateTemplate().find(hql,code);
		
		//�ж��û�userList
		if(userList !=null && userList.size() > 0) {
			
			return userList.get(0);
		}		
		return null;
	}
	
	/**
	 * �û����³ɹ��������û�
	 */
	@Override
	public void updateUser(User existUser) {

		this.getHibernateTemplate().update(existUser);
	}
	
	/**
	 * ͨ���û���uid��ѯ�û�
	 */
	@Override
	public User findByUid(Integer uid) {
		
//		//��дsql
//		String hql="from User where uid= ?";
//		
//		//ִ��ͨ���û���uid��ѯ�û�
//		List<User> userList=this.getHibernateTemplate().find(hql,uid);
//		
//		//�ж�userList
//		if(userList !=null && userList.size() > 0) {
//			
//			return userList.get(0);
//		}
//		return null;
		
		return this.getHibernateTemplate().get(User.class, uid);
	}
	
	/**
	 * �ύ��������:���¸�������
	 */
	@Override
	public void updateUserData(User user) {

		this.getHibernateTemplate().update(user);
	}
	
	/**
	 * �ύ��������:���¸������ݣ���Ҫ��������
	 */
	@Override
	public void saveUserUpdate(User user) {
		
		this.getHibernateTemplate().update(user);
	}
	
	/**
	 * ��ѯ�û�������
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
	 * ��ѯ�û����ϴ���ҳ
	 */
	@Override
	public List<User> findByPage(int begin, int limit) {
		
		String hql="from User";
		List<User> list=this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, null, begin, limit));
		
		return list;
	}
	
	/**
	 * ͨ���û���id�����û�
	 */
	@Override
	public void updateUserInfo(User user) {

		this.getHibernateTemplate().update(user);
	}
	
	/**
	 * ͨ���û���uidɾ���û�
	 */
	@Override
	public void deleteUser(User deleteUser) {

		this.getHibernateTemplate().delete(deleteUser);
	}

}
