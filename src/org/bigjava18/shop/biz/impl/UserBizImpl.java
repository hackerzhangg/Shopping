package org.bigjava18.shop.biz.impl;

import java.util.List;
import java.util.UUID;

import org.bigjava18.shop.bean.PageBean;
import org.bigjava18.shop.bean.User;
import org.bigjava18.shop.biz.UserBiz;
import org.bigjava18.shop.common.SendEmailCommon;
import org.bigjava18.shop.common.UUIDUtils;
import org.bigjava18.shop.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * �û�ҵ���߼���ӿ�ʵ����
 * @author zgp
 *
 */
@Transactional
public class UserBizImpl implements UserBiz{
	
	//��UserBizImpl��ע��UserDao
	private UserDao userDao;
	
	//����UserDao��set����
	public void setUserDao(UserDao userDao) {
		
		this.userDao = userDao;
	}
	
	/**
	 * ͨ���û�����ѯ�û�
	 */
	@Override
	public User findByUsername(String username) {
		
		return userDao.findByUsername(username);
	}
	
	/**
	 * ����û�
	 */
	@Override
	public void save(User user) {
		//�ֶ������ݴ��뵽Userʵ����
		user.setState(0); 	// 0:�����û�δ���� 1:�����û��Ѿ�����
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		
		//�����ݴ��뵽���ݿ�
		userDao.save(user);
		
		//���ͼ����ʼ�
		String activeLink = "http://localhost:8080/Shopping/user_active.action?code=" + user.getCode();
		String html = "��ӭ"+user.getUsername()+"ע�Ṻ���̳ǣ��� <a href=\"" + activeLink+ "\">���</a> �����ʺ�";
		System.out.println("����:" + html);
		SendEmailCommon.sendMail(user.getEmail(), html);
	}
	
	/**
	 * ��¼�û�
	 */
	@Override
	public User login(User user) {
		
		return userDao.login(user);
	}
	
	/**
	 * ͨ���û��ļ������ѯ�û�
	 */
	@Override
	public User findByCode(String code) {
		
		return userDao.findByCode(code);
	}
	
	/**
	 * �û����³ɹ��������û�
	 */
	@Override
	public void updateUser(User existUser) {
		
		userDao.updateUser(existUser);
	}
	
	/**
	 * ͨ���û���uid��ѯ�û�
	 */
	@Override
	public User findByUid(Integer uid) {
		
		return userDao.findByUid(uid);
	}
	
	/**
	 * �ύ��������:���¸�������
	 */
	@Override
	public void updateUserData(User user) {

		userDao.updateUserData(user);
	}
	
	/**
	 * �ύ��������:���¸������ݣ���Ҫ��������
	 */
	@Override
	public void saveUserUpdate(User user) {
		//�ֶ������ݴ��뵽Userʵ����
		user.setState(0); 	// 0:�����û�δ���� 1:�����û��Ѿ�����
		String code=UUIDUtils.getUUID()+UUIDUtils.getUUID();
		user.setCode(code);
		
		//�����������ύ�����ݿ�
		userDao.saveUserUpdate(user);
		
		//���ͼ����ʼ�
		String activeLink = "http://localhost:8080/Shopping/user_active.action?code=" + user.getCode();
		String html = "��ӭ"+user.getUsername()+"ע�Ṻ���̳ǣ��� <a href=\"" + activeLink+ "\">���</a> �����ʺ�";
		System.out.println("����:" + html);
		SendEmailCommon.sendMail(user.getEmail(), html);
	}
	
	/**
	 * ��̨��ѯ�����û�����ҳ
	 */
	@Override
	public PageBean<User> findAllUser(Integer page) {
		
		//����PagenBeanʵ������
		PageBean<User> pageBean=new PageBean<User>();
		
		//���õ�ǰҳ��
		pageBean.setPage(page);
		
		//����ҳ�����ʾ�Ĵ�С
		int limit=5;
		pageBean.setLimit(limit);
		
		//�����û�������
		int userTotalCount=userDao.findUserCount();
		pageBean.setTotalCount(userTotalCount);
		
		//����ҳ�����ҳ��
		int totalPage=0;
		
		//�ж���ҳ��
		if(userTotalCount % limit == 0) {
			totalPage = userTotalCount / limit ;
		}else {
			totalPage = userTotalCount /limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//����ÿҳ��ʾ���ݵļ���
		int begin=(page - 1)*limit;		
		List<User> userList=userDao.findByPage(begin,limit);
		pageBean.setList(userList);
		
		return pageBean;
	}
	
	/**
	 * ͨ���û���id�����û�
	 */
	@Override
	public void updateUserInfo(User user) {
		
		userDao.updateUserInfo(user);
	}
	
	/**
	 * ��̨��ѯ�û�������
	 */
	@Override
	public int adminUserCount() {
		
		return userDao.findUserCount();
	}
	
	/**
	 * ͨ���û���uidɾ���û�
	 */
	@Override
	public void deleteUser(User deleteUser) {

		userDao.deleteUser(deleteUser);
	}
	
}
