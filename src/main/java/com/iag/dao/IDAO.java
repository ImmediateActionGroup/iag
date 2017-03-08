package com.iag.dao;


import com.iag.exception.ex.DataBaseException;
import com.iag.util.db.Conditions;
import com.iag.util.db.DataPage;

import java.io.Serializable;
import java.util.List;


public interface IDAO<T> {
	Integer save(T bean) throws DataBaseException;
	void delete(T bean) throws DataBaseException;
	void update(T bean) throws DataBaseException;
	void saveOrUpdate(T bean) throws DataBaseException;
	List<T> queryAll(Class<T> clazz) throws DataBaseException;
	
	Object queryByName(Class<T> clazz, String queryName, String value) throws DataBaseException;
	Object queryById(Class<T> clazz, Serializable id) throws DataBaseException;
	
	List<T> queryByConditions(Class<T> clazz, Conditions conditions) throws DataBaseException;
	
	void saveAll(List<Object> list) throws DataBaseException;
	
	int page(final DataPage<T> page, Class<T> clazz, Conditions conditions) throws DataBaseException;
	
	int countRows(Class<T> clazz) throws DataBaseException;

	int countRows(Class<T> clazz, Conditions conditions) throws DataBaseException;

	void evit(T bean) throws DataBaseException;
}
