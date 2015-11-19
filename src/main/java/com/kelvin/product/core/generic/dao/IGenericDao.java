package com.kelvin.product.core.generic.dao;

import org.hibernate.Session;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IGenericDao {

	Session getSession();

	public <T> Serializable save(T entity);

	public <T> void batchSave(List<T> entitys);

	public <T> void saveOrUpdate(T entity);

	/**
	 * 删除实体
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * @param entitie
	 */
	public <T> void delete(T entitie);

	/**
	 * 根据实体名字获取唯一记录
	 * 
	 * @param entityClass
	 * @param map
	 * @return
	 */
	public <T> T findUniqueByPropertys(Class<T> entityClass,Map<String,Object> map);
	
	/**
	 * 按属性查找对象列表.
	 */
	public <T> List<T> findByPropertys(Class<T> entityClass,
			Map<String,Object> map);

	/**
	 * 根据属性查找对象分页列表
	 * @param entityClass
	 * @param map
	 * @param firstResult
	 * @param maxResult
	 * @param <T>
	 * @return
	 */
	public <T> List<T> findByPropertysForPage(Class<T> entityClass,
											  Map<String,Object> map, int firstResult, int maxResult);

	/**
	 * 按属性查找对象列表加排序.
	 */
	public <T> List<T> findByPropertysForOrder(Class<T> entityClass,
			Map<String,Object> map, String order, boolean isAsc);

	/**
	 * 根据属性查询对象分页
	 * @param entityClass
	 * @param map
	 * @param order
	 * @param isAsc
	 * @param page
	 * @param pageSize
	 * @param <T>
	 * @return
	 */
	public <T> List<T> findByPropertysForOrderAndPage(Class<T> entityClass,
													  Map<String,Object> map, String order, boolean isAsc, int page, int pageSize);

	/**
	 * 加载全部实体
	 * 
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	public <T> List<T> loadAll(final Class<T> entityClass);

	/**
	 * 根据实体名称和主键获取实体
	 * 
	 * @param <T>
	 * 
	 * @param <T>
	 * @param entityName
	 * @param id
	 * @return
	 */
	public <T> T getEntity(Class<T> entityName, Serializable id);

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

	public <T> void updateEntityById(Class<T> entityName, Serializable id);

	/**
	 * 通过hql 查询语句查找对象
	 * 
	 * @param <T>
	 * @param hql
	 * @return
	 */
	public <T> List<T> findByQueryString(String hql);

	/**
	 * 通过hql查询唯一对象
	 * 
	 * @param <T>
	 * @param hql
	 * @return
	 */
	public <T> T singleResult(String hql);

	/**
	 * 根据sql查询数据列表
	 * @param map
	 * @return
	 */
	List<Map<String,Object>> findListBySql(String sql, Map<String, Object> map);

	void excute(String sql, Map<String,Object> paramMap);

	void excute1(String sql);
}
