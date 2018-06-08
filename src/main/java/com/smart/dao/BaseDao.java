package com.smart.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Statement;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class BaseDao<T> {
	private Class<T> entityClass;
	@Autowired
	private HibernateTemplate hibernateTemplate;
	//通过反射获取子类确定的泛型类
	public BaseDao() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}
	//根据id加载po实例
	public T load(Serializable id) {
		return (T) getHibernateTemplate().load(entityClass,id);
	}
	/*
	 * 保存po
	 */
	public void save(T entity) {
		getHibernateTemplate().save(entity);
	}
	/**
	 * 删除po
	 * @return
	 */
	public void remove(T entity) {
		getHibernateTemplate().delete(entity);
	}
	/*
	 * 删除tableNames数据
	 */
	public void removeAll(String tableName) {
		getSession().createSQLQuery("truncate TABLE"+tableName+"").executeUpdate();
	}
	
	
	
	
	
	
	private Session getSession() {
		return hibernateTemplate.getSessionFactory().getCurrentSession();
	}
	private HibernateTemplate getHibernateTemplate() {
		// TODO Auto-generated method stub
		return hibernateTemplate;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
