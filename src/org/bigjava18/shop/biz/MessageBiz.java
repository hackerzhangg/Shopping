package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.Message;

/**
 * �û�����ҵ���߼�����ʽӿ�
 * @author zgp
 *
 */
public interface MessageBiz {
	
	/**
	 * ��ѯ�����û�������Ϣ
	 * @return
	 */
	public List<Message> findAllMessage();

}
