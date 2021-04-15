package org.bigjava18.shop.dao.impl;

import java.util.List;

import org.bigjava18.shop.bean.Message;
import org.bigjava18.shop.dao.MessageDao;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * 用户留言数据库访问接口实现类
 * @author zgp
 *
 */
public class MessageDaoImpl extends HibernateDaoSupport implements MessageDao {
	
	/**
	 * 查询所有用户留言信息
	 */
	@Override
	public List<Message> findAllMessage() {
		
		//编写sql语句
		//String sql="select * from message"; 	//hibernate3: 错误写法
		String sql="from Message";
		
		//执行查询语句
		List<Message> mList=this.getHibernateTemplate().find(sql);
		
		//判断mList
		//if(mList !=null && mList.size() > 0) {
			
			//return (List<Message>) mList.get(0);
		//}
		
		return mList;
	}

}
