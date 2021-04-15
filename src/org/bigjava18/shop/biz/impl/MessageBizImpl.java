package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.Message;
import org.bigjava18.shop.biz.MessageBiz;
import org.bigjava18.shop.dao.MessageDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * �û�����ҵ���߼���ӿ�ʵ����
 * @author zgp
 *
 */
@Transactional
public class MessageBizImpl implements MessageBiz {
	
	//��MessageBizImpl��ע��messageDao
	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		
		this.messageDao = messageDao;
	}
	
	/**
	 * ��ѯ�����û�������Ϣ
	 */
	@Override
	public List<Message> findAllMessage() {
		
		return messageDao.findAllMessage();
	}
	
}
