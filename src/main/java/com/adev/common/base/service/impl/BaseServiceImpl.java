package com.adev.common.base.service.impl;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.adev.common.base.service.BaseService;

public class BaseServiceImpl<T, ID extends Serializable> implements BaseService<T, ID> {

	protected CrudRepository<T, ID> baseRepository;
	
	public BaseServiceImpl() {
		
	}
	
	public BaseServiceImpl(CrudRepository<T, ID> baseRepository) {
		this.baseRepository=baseRepository;
	}
	
	@Override
	public long count() {
		return baseRepository.count();
	}

	@Override
	public boolean existsById(ID id) {
		return baseRepository.existsById(id);
	}

	@Override
	public Iterable<T> findAll() {
		return baseRepository.findAll();
	}

	@Override
	public Iterable<T> findAllById(Iterable<ID> ids) {
		return baseRepository.findAllById(ids);
	}

	@Override
	public Optional<T> findById(ID id) {
		return baseRepository.findById(id);
	}

	@Override
	public <S extends T> S save(S entity) {
		return baseRepository.save(entity);
	}

	@Override
	public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
		return baseRepository.saveAll(entities);
	}

	@Override
	public void deleteById(ID id) {
		baseRepository.deleteById(id);
	}

	@Override
	public void delete(T entity) {
		baseRepository.delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		baseRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		baseRepository.deleteAll();
	}

}
