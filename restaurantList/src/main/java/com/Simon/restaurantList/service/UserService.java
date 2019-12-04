package com.Simon.restaurantList.service;

import com.Simon.restaurantList.exceptions.InvalidEmailException;
import com.Simon.restaurantList.model.UserModel;

public interface UserService {
	
	public int updateEmail(UserModel updatedUser) throws InvalidEmailException;
	public int updateName(UserModel updatedUser);
	public int updatePassword(UserModel updatedUser);
	public void deleteUser(UserModel userToDelete);
}
