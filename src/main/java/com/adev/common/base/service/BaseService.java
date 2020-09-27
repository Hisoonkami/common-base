package com.adev.common.base.service;

import java.io.Serializable;
import java.util.Optional;

public interface BaseService<T, ID extends Serializable> {
	/**
	 * 统计数量
	 * @return
	 */
	long count();
	
	/**
	 * 判断id是否存在
	 * @param id
	 * @return
	 */
	boolean existsById(ID id);
	
	/**
	 * 查询所有
	 * @return
	 */
	Iterable<T> findAll();
	
	/**
	 * 根据多个id查询
	 * @param ids
	 * @return
	 */
	Iterable<T> findAllById(Iterable<ID> ids);
	
	/**
	 * 根据指定id查询
	 * @param id
	 * @return
	 */
	Optional<T> findById(ID id);
	
	/**
	 * 保存实体对象
	 * @param <S>
	 * @param entity
	 * @return
	 */
	<S extends T> S save(S entity);
	
	/**
	 * 批量保存
	 * @param <S>
	 * @param entities
	 * @return
	 */
	<S extends T> Iterable<S> saveAll(Iterable<S> entities);
	
	/**
	 * 根据id删除
	 * @param id
	 */
	void deleteById(ID id);
	
	/**
	 * 删除实体
	 * @param entity
	 */
	void delete(T entity);
	
	/**
	 * 批量删除实体
	 * @param entities
	 */
	void deleteAll(Iterable<? extends T> entities);
	
	/**
	 * 批量删除（慎用）
	 */
	void deleteAll();
}
