package org.bigjava18.shop.biz;

import java.util.List;

import org.bigjava18.shop.bean.Message;

/**
 * 用户留言业务逻辑层访问接口
 * @author zgp
 *
 */
public interface MessageBiz {
	
	/**
	 * 查询所有用户留言信息
	 * @return
	 */
	public List<Message> findAllMessage();

}
