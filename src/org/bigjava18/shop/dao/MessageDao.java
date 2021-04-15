package org.bigjava18.shop.dao;

import java.util.List;

import org.bigjava18.shop.bean.Message;

/**
 * 用户留言数据库访问接口
 * @author zgp
 *
 */
public interface MessageDao {
	
	/**
	 * 查询所有用户留言信息
	 * @return
	 */
	public List<Message> findAllMessage();

}
