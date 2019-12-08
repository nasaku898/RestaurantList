package com.Simon.restaurantList.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.Simon.restaurantList.dao.GenericDao;


public abstract class GenericDaoImpl<Object> implements GenericDao<Object> {
	
	protected List<Object> list;
	
	public GenericDaoImpl()
	{
		list = new ArrayList<Object>();
	}
	
	@Override
	public List<Object> getAll() {
		return list;
	}

	@Override
	public void save(Object object) {
		list.add(object);
	}

	@Override
	public void delete(Object object) {
		list.remove(object);
	}
	
}
