package com.kelvin.product.core.generic.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kelvin.product.core.generic.dao.IGenericDao;
import com.kelvin.product.core.generic.service.GenericService;

@Service("genericService")
@Transactional
public class GenericServiceImpl implements GenericService {

	@Autowired
	IGenericDao genericDao;

	@Override
	public <T> Serializable save(T entity) {
		// TODO Auto-generated method stub
		return genericDao.save(entity);
	}

	@Override
	public <T> void saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		genericDao.saveOrUpdate(entity);
	}

	@Override
	public <T> void delete(T entity) {
		// TODO Auto-generated method stub
		genericDao.delete(entity);
	}

	@Override
	public <T> void batchSave(List<T> entitys) {
		// TODO Auto-generated method stub
		genericDao.batchSave(entitys);
	}

	@Override
	public <T> T get(Class<T> class1, Serializable id) {
		// TODO Auto-generated method stub
		return genericDao.getEntity(class1, id);
	}

	@Override
	public <T> T findUniqueByPropertys(Class<T> entityClass,
			Map<String,Object> map) {
		// TODO Auto-generated method stub
		return genericDao.findUniqueByPropertys(entityClass, map);
	}

	@Override
	public <T> List<T> findByPropertys(Class<T> entityClass,
			Map<String,Object> map) {
		// TODO Auto-generated method stub
		return genericDao.findByPropertys(entityClass, map);
	}
	
	@Override
	public <T> List<T> findByPropertysForOrder(Class<T> entityClass,
			Map<String,Object> map, String order, boolean isAsc) {
		// TODO Auto-generated method stub
		return genericDao.findByPropertys(entityClass, map);
	}

	@Override
	public <T> List<T> loadAll(Class<T> entityClass) {
		// TODO Auto-generated method stub
		return genericDao.loadAll(entityClass);
	}

	@Override
	public <T> void deleteEntityById(Class<T> entityName, Serializable id) {
		// TODO Auto-generated method stub
		genericDao.deleteEntityById(entityName, id);
	}

	@Override
	public <T> void deleteAllEntitie(Collection<T> entities) {
		// TODO Auto-generated method stub
		genericDao.deleteAllEntitie(entities);
	}

	@Override
	public <T> void updateEntitie(T pojo) {
		// TODO Auto-generated method stub
		genericDao.updateEntitie(pojo);
	}

	@Override
	public <T> List<T> findByQueryString(String hql) {
		// TODO Auto-generated method stub
		return genericDao.findByQueryString(hql);
	}

	@Override
	public <T> List<T> findSingleByQueryString(String hql){
		return genericDao.singleResult(hql);
	}

	@Override
	public List<Map<String,Object>> findListBySql(String sql, Map<String, Object> paramMap){

		return genericDao.findListBySql(sql, paramMap);
	}
}
