package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.Message;
import org.bigjava18.shop.dao.MessageDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * �û��������ݿ���ʽӿ�ʵ����
 * @author zgp
 *
 */
public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {
	
	/**
	 * ��ѯ�����û�������Ϣ
	 */
	@Override
	public List<Message> findAllMessage() {
		
		//��дsql���
		//String sql="select * from message"; 	//hibernate3: ����д��
		String sql="from Message";
		
		//ִ�в�ѯ���
		List<Message> mList=this.getHibernateTemplate().find(sql);
		
		//�ж�mList
		//if(mList !=null && mList.size() > 0) {
			
			//return (List<Message>) mList.get(0);
		//}
		
		return mList;
	}

}
