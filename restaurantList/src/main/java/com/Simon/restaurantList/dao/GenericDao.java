package com.Simon.restaurantList.dao;

import java.util.List;

public interface GenericDao<Object> {
	List<Object> getAll();

	void save(Object object);

	int update(Object object);

	void delete(Object object);
}
