package org.bigjava18.shop.biz.impl;

import java.util.List;

import org.bigjava18.shop.bean.Message;
import org.bigjava18.shop.biz.MessageBiz;
import org.bigjava18.shop.dao.MessageDao;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户留言业务逻辑层接口实现类
 * @author zgp
 *
 */
@Transactional
public class MessageBizImpl implements MessageBiz {
	
	//在MessageBizImpl中注入messageDao
	private MessageDao messageDao;

	public void setMessageDao(MessageDao messageDao) {
		
		this.messageDao = messageDao;
	}
	
	/**
	 * 查询所有用户留言信息
	 */
	@Override
	public List<Message> findAllMessage() {
		
		return messageDao.findAllMessage();
	}
	
}
