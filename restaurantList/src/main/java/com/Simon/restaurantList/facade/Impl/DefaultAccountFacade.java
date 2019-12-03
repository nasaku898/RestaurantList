package com.Simon.restaurantList.facade.Impl;

import org.springframework.beans.factory.annotation.Qualifier;

import com.Simon.restaurantList.exceptions.InvalidEmailException;
import com.Simon.restaurantList.facade.AccountFacade;
import com.Simon.restaurantList.model.UserModel;
import com.Simon.restaurantList.service.UserService;

public class DefaultAccountFacade implements AccountFacade {

	UserService userService;

	public DefaultAccountFacade(@Qualifier("UserService") UserService userService) {
		this.userService = userService;
	}

	@Override
	public int updateEmail(String newEmail, UserModel currentUser) {
		currentUser.setEmailAdress(newEmail);
		try {
			return userService.updateEmail(currentUser);
		} catch (InvalidEmailException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	@Override
	public int updateName(String newFirstName, String newLastName, UserModel currentUser) {
		currentUser.setFirstName(newFirstName);
		currentUser.setLastName(newLastName);
		return userService.updateName(currentUser);
	}

	@Override
	public int updatePassword(String newPassword, UserModel currentUser) {
		currentUser.setPassword(newPassword);
		return userService.updatePassword(currentUser);
	}

}
