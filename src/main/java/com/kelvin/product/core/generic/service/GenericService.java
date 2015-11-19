package com.kelvin.product.core.generic.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface GenericService {

	public <T> Serializable save(T entity);
	public <T> void saveOrUpdate(T entity);
	public <T> void delete(T entity);
	public <T> void batchSave(List<T> entitys);
	
	/**
	 * 根据实体名称和主键获取实体
	 * 
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> class1, Serializable id);
	
	/**
	 * 根据实体名称和字段名称和字段值获取唯一记录
	 * 
	 * @param <T>
	 * @param entityClass
	 * @param propertyName
	 * @param value
	 * @return
	 */
	public <T> T findUniqueByPropertys(Class<T> entityClass,
			Map<String,Object> map);
	
	/**
	 * 按属性查找对象列表.
	 */
	public <T> List<T> findByPropertys(Class<T> entityClass,
			Map<String,Object> map);
	
	/**
	 * 按属性查找对象列表加排序.
	 */
	public <T> List<T> findByPropertysForOrder(Class<T> entityClass,
			Map<String,Object> map, String order, boolean isAsc) ;
	
	/**
	 * 加载全部实体
	 * 
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> loadAll(final Class<T> entityClass);
	
	/**
	 * 删除实体主键删除
	 * 
	 * @param <T>
	 * @param entities
	 */
	public <T> void deleteEntityById(Class<T> entityName, Serializable id);
	
	/**
	 * 删除实体集合
	 * 
	 * @param <T>
	 * @param entities
	 */
	public <T> void deleteAllEntitie(Collection<T> entities);
	
	/**
	 * 更新指定的实体
	 * 
	 * @param <T>
	 * @param pojo
	 */
	public <T> void updateEntitie(T pojo);
	
	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param hql
	 * @return
	 */
	public <T> List<T> findByQueryString(String hql);
	
	/**
	 * 通过hql 查询语句查找单个对象
	 * 
	 * @param <T>
	 * @param hql
	 * @return
	 */
	public <T> List<T> findSingleByQueryString(String hql);

	/**
	 *
	 * @param sql
	 * @return
	 */
	public List<Map<String,Object>> findListBySql(String sql, Map<String,Object> map);

}
