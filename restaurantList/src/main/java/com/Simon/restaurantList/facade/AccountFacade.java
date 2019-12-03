package com.Simon.restaurantList.facade;

import com.Simon.restaurantList.model.UserModel;

public interface AccountFacade {
	public int updateEmail(String newEmail, UserModel currentUser);

	public int updateName(String newUserName, String newLastName, UserModel currentUser);

	public int updatePassword(String newPassword, UserModel currentUser);
}
