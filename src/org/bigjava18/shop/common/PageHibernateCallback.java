package org.bigjava18.shop.common;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

/**
 * ʹ�÷��ͣ���ҳHibernateCallback������
 * @author zgp
 *
 * @param <T>
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>>{
	
	private String hql;					//sql���
	private Object[] params;			//params����
	private int startIndex;				//��ҳ�Ŀ�ʼֵ
	private int pageSize;				//ÿҳ��ʾ�Ĵ�С
	
	//����PageHibernateCallback���캯��Ϊ��Ա���Ը�ֵ
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
		//1 ִ��hql���
		Query query = session.createQuery(hql);
		//2 ʵ�ʲ���
		if(params != null){
			for(int i = 0 ; i < params.length ; i ++){
				query.setParameter(i, params[i]);
			}
		}
		//3 ��ҳ
		query.setFirstResult(startIndex);
		query.setMaxResults(pageSize);
		
		return query.list();
	}

}
