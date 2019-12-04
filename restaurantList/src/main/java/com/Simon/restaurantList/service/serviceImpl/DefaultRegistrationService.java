package com.Simon.restaurantList.service.serviceImpl;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.Simon.restaurantList.dao.UserDao;
import com.Simon.restaurantList.exceptions.InvalidEmailException;
import com.Simon.restaurantList.model.UserModel;
import com.Simon.restaurantList.service.RegistrationService;

//Added password validation in future and email
public class DefaultRegistrationService implements RegistrationService {

	UserDao userDao;

	@Autowired
	public DefaultRegistrationService(@Qualifier("UserDao") UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean createNewUser(UserModel newUser) {
		try {
			validateEmail(newUser.getEmailAdress());
			userDao.save(newUser);
			return true;
		} catch (InvalidEmailException e) {
			throw new IllegalArgumentException(e.getMessage());
		}

	}

	//Add validation for repeated email already in DB
	@Override
	public boolean validateEmail(String email) throws InvalidEmailException {
		String regex = "\\w+\\@\\w+\\.[A-Za-z]+";
		return Pattern.matches(regex, email);
	}

}
