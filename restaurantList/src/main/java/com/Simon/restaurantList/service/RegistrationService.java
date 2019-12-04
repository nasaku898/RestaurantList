package com.Simon.restaurantList.service;

import com.Simon.restaurantList.exceptions.InvalidEmailException;
import com.Simon.restaurantList.model.UserModel;

public interface RegistrationService {
	
	public boolean createNewUser(UserModel newUser);
	public boolean validateEmail(String email) throws InvalidEmailException;
}
