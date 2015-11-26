package com.kelvin.product.core.generic.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.transaction.spi.LocalStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.kelvin.product.core.generic.dao.IGenericDao;

import javax.annotation.Resource;

@Repository
public class GenericDao implements IGenericDao {

	/**
	 * 初始化Log4j的一个实例
	 */
	private static final Logger logger = Logger
			.getLogger(GenericDao.class);
	/**
	 * 注入一个sessionFactory属性,并注入到父类(HibernateDaoSupport)
	 * **/
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	@Resource
	@Qualifier("namedParameterJdbcTemplate")
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Resource
	@Qualifier("jdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	public Session getSession() {
		// 事务必须是开启的(Required)，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	@Override
	public <T> Serializable save(T entity) {
		try{
			Serializable id = getSession().save(entity);
//			getSession().flush();
			return id;
		}catch(Exception e){
			logger.error("保存实体异常");
			throw e;
		}
	}

	@Override
	public <T> void batchSave(List<T> entitys) {
		for (int i = 0; i < entitys.size(); i++) {
			getSession().save(entitys.get(i));
			if (i % 20 == 0) {
				// 20个对象后才清理缓存，写入数据库
				getSession().flush();
				getSession().clear();
			}
		}
		// 最后清理一下----防止大于20小于40的不保存
		getSession().flush();
		getSession().clear();
	}

	@Override
	public <T> void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		try {
			getSession().saveOrUpdate(entity);
			getSession().flush();
		} catch (RuntimeException e) {
			logger.error("添加或更新异常", e);
			throw e;
		}
	}

	@Override
	public <T> void delete(T entity) {
		// TODO Auto-generated method stub
		try {
			getSession().delete(entity);
			getSession().flush();
		} catch (RuntimeException e) {
			logger.error("删除异常", e);
			throw e;
		}
	}

	@Override
	public <T> T findUniqueByPropertys(Class<T> entityClass,Map<String,Object> map) {
		Criteria criteria = createCriteria(entityClass);
		for(String key:map.keySet()){
			Assert.hasText(key);
			criteria.add(Restrictions.eq(key, map.get(key)));
		}
		return (T) criteria.uniqueResult();
	}

	@Override
	public <T> List<T> findByPropertys(Class<T> entityClass,
			Map<String,Object> map) {
		Criteria criteria = createCriteria(entityClass);
		for(String key:map.keySet()){
			Assert.hasText(key);
			criteria.add(Restrictions.eq(key, map.get(key)));
		}
		return criteria.list();
	}

	@Override
	public <T> List<T> findByPropertysForPage(Class<T> entityClass,
									   Map<String,Object> map, int page, int pageSize) {
		Criteria criteria = createCriteria(entityClass);
		for(String key:map.keySet()){
			Assert.hasText(key);
			criteria.add(Restrictions.eq(key, map.get(key)));
		}
		int firstResult = (page - 1) * pageSize;
		criteria.setFirstResult(firstResult).setMaxResults(pageSize);
		return criteria.list();
	}
	
	@Override
	public <T> List<T> findByPropertysForOrder(Class<T> entityClass,
			Map<String,Object> map, String order, boolean isAsc){
		Criteria criteria = createCriteria(entityClass);
		for(String key:map.keySet()){
			Assert.hasText(key);
			criteria.add(Restrictions.eq(key, map.get(key)));
		}
		if(isAsc){
			criteria.addOrder(Order.asc(order));
		}else{
			criteria.addOrder(Order.desc(order));
		}
		return criteria.list();
	}

	@Override
	public <T> List<T> findByPropertysForOrderAndPage(Class<T> entityClass,
											   Map<String,Object> map, String order, boolean isAsc, int page, int pageSize){
		Criteria criteria = createCriteria(entityClass);
		for(String key:map.keySet()){
			Assert.hasText(key);
			criteria.add(Restrictions.eq(key, map.get(key)));
		}
		if(isAsc){
			criteria.addOrder(Order.asc(order));
		}else{
			criteria.addOrder(Order.desc(order));
		}
		int firstResult = (page - 1) * pageSize;
		criteria.setFirstResult(firstResult).setMaxResults(pageSize);
		return criteria.list();
	}

	@Override
	public <T> List<T> loadAll(Class<T> entityClass) {
		Criteria criteria = createCriteria(entityClass);
		return criteria.list();
	}

	@Override
	public <T> T getEntity(Class<T> entityClass, Serializable id) {
		Assert.notNull(id);
		return (T) getSession().get(entityClass, id);
	}

	@Override
	public <T> void deleteEntityById(Class<T> entityName, Serializable id) {
		Assert.notNull(id);
		delete(getEntity(entityName, id));
		getSession().flush();
	}

	@Override
	public <T> void deleteAllEntitie(Collection<T> entities) {
		// TODO Auto-generated method stub
		for(T entity:entities){
			delete(entity);
			getSession().flush();
		}
		
	}

	@Override
	public <T> void updateEntitie(T pojo) {
		// TODO Auto-generated method stub
		getSession().update(pojo);
	}

	@Override
	public <T> void updateEntityById(Class<T> entityName, Serializable id) {
		// TODO Auto-generated method stub
		updateEntitie(getEntity(entityName, id));
	}

	@Override
	public <T> List<T> findByQueryString(String hql) {
		Query queryObject = getSession().createQuery(hql);
		List<T> list = queryObject.list();
		if (list.size() > 0) {
			getSession().flush();
		}
		return list;
	}

	@Override
	public <T> T singleResult(String hql) {
		T t = null;
		Query queryObject = getSession().createQuery(hql);
		List<T> list = queryObject.list();
		if (list.size() == 1) {
			getSession().flush();
			t = list.get(0);
		} else if (list.size() > 0) {
			return list.get(0);
		}
		return t;
	}
	
	/**
	 * 创建单一Criteria对象
	 * 
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	public <T> Criteria createCriteria(Class<T> entityClass) {
		Criteria criteria = getSession().createCriteria(entityClass);
		return criteria;
	}

	@Override
	public List<Map<String, Object>> findListBySql(String sql, Map<String, Object> map) {
		return namedParameterJdbcTemplate.queryForList(sql, map);
	}

	@Override
	public void excute(String sql, Map<String,Object> paramMap){
		this.namedParameterJdbcTemplate.update(sql, paramMap);
	}

	@Override
	public void excute1(String sql){
		this.jdbcTemplate.update(sql);
	}
}
