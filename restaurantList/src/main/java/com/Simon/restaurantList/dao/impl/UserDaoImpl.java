package com.Simon.restaurantList.dao.impl;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.Simon.restaurantList.dao.UserDao;
import com.Simon.restaurantList.model.UserModel;

@Repository("userDaoImpl")
public class UserDaoImpl extends GenericDaoImpl<UserModel> implements UserDao {

	public Optional<UserModel> getUser(String email) {
		return list.stream().filter(user -> user.getEmailAdress().equals(email)).findFirst();
	}

	@Override
	public int update(UserModel updatedUser) {
		return getUser(updatedUser.getEmailAdress()).map(user -> {
			int indexOfPersonToDelete = list.indexOf(user);
			if (indexOfPersonToDelete >= 0) {
				list.set(indexOfPersonToDelete, updatedUser);
				return 1;
			}
			return 0;
		}).orElse(0);
	}
}
