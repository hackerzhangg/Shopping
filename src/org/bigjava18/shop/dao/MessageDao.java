package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.Message;

/**
 * �û��������ݿ���ʽӿ�
 * @author zgp
 *
 */
public interface MessageDao {
	
	/**
	 * ��ѯ�����û�������Ϣ
	 * @return
	 */
	public List<Message> findAllMessage();

}
