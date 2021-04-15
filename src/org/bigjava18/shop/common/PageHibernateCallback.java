package org.bigjava18.shop.common;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * 使用泛型：分页HibernateCallback工具类
 * @author zgp
 *
 * @param <T>
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>>{
	
	private String hql;					//sql语句
	private Object[] params;			//params数组
	private int startIndex;				//分页的开始值
	private int pageSize;				//每页显示的大小
	
	//定义PageHibernateCallback构造函数为成员属性赋值
	public PageHibernateCallback(String hql, Object[] params,
			int startIndex, int pageSize) {
		super();
		this.hql = hql;
		this.params = params;
		this.startIndex = startIndex;
		this.pageSize = pageSize;
	}

	public List<T> doInHibernate(Session session) throws HibernateException,
			SQLException {
		//1 执行hql语句
		Query query = session.createQuery(hql);
		//2 实际参数
		if(params != null){
			for(int i = 0 ; i < params.length ; i ++){
				query.setParameter(i, params[i]);
			}
		}
		//3 分页
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		
		return query.list();
	}

}
