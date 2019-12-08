package com.Simon.restaurantList.facade.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.Simon.restaurantList.exceptions.InvalidEmailException;
import com.Simon.restaurantList.facade.AccountFacade;
import com.Simon.restaurantList.model.UserModel;
import com.Simon.restaurantList.service.RegistrationService;
import com.Simon.restaurantList.service.UserService;

@Component("defaultAccountFacade")
public class DefaultAccountFacade implements AccountFacade {

	UserService userService;
	RegistrationService registrationService;

	@Autowired
	public DefaultAccountFacade(@Qualifier("defaultUserService") UserService userService,
			@Qualifier("defaultRegistrationService") RegistrationService registrationService) {
		this.userService = userService;
		this.registrationService = registrationService;
	}

	@Override
	public int updateEmail(String newEmail) {
		UserModel currentUser = getCurrentUser();

		currentUser.setEmailAdress(newEmail);
		try {
			return userService.updateEmail(currentUser);
		} catch (InvalidEmailException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	@Override
	public int updateName(String newFirstName, String newLastName) {
		UserModel currentUser = getCurrentUser();
		
		if(newFirstName == null || newLastName == null)
		{
			throw new IllegalStateException("firstName or lastName field is empty");
		}
		currentUser.setFirstName(newFirstName);
		currentUser.setLastName(newLastName);
		return userService.updateName(currentUser);
	}
	
	//add password encoder
	@Override
	public int updatePassword(String newPassword) {
		UserModel currentUser = getCurrentUser();
		currentUser.setPassword(newPassword);
		return userService.updatePassword(currentUser);
	}

	@Override
	public boolean createNewUser(UserModel newUser) {
		return registrationService.createNewUser(newUser);
	}

	@Override
	public UserModel getUserByEmail(String email) {
		return userService.getUserByEmail(email);
	}

	@Override
	public List<UserModel> getAllUsers() {
		return userService.getAllUsers();
	}

	@Override
	public UserModel getCurrentUser() {
		return userService.getCurrentUser();
	}

}
