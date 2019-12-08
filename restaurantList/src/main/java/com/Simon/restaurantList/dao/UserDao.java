package com.Simon.restaurantList.dao;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.Simon.restaurantList.model.UserModel;


public interface UserDao extends GenericDao<UserModel> {
	public Optional<UserModel> getUser(String email);
}
