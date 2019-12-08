package com.Simon.restaurantList.facade;

import java.util.List;

import com.Simon.restaurantList.model.UserModel;

public interface AccountFacade {
	public int updateEmail(String newEmail);

	public int updateName(String newUserName, String newLastName);

	public int updatePassword(String newPassword);

	public boolean createNewUser(UserModel newUser);

	public UserModel getUserByEmail(String email);

	public List<UserModel> getAllUsers();

	public UserModel getCurrentUser();

}
