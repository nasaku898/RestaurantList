package com.Simon.restaurantList.service.serviceImpl;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.Simon.restaurantList.dao.UserDao;
import com.Simon.restaurantList.exceptions.InvalidEmailException;
import com.Simon.restaurantList.model.UserModel;
import com.Simon.restaurantList.service.RegistrationService;

//Added password validation in future and email
@Service("defaultRegistrationService")
public class DefaultRegistrationService implements RegistrationService {

	UserDao userDao;
	PasswordEncoder passwordEncoder;
	@Autowired
	public DefaultRegistrationService(@Qualifier("userDaoImpl") UserDao userDao, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public boolean createNewUser(UserModel newUser) {
		try {
			validateEmail(newUser.getEmailAdress());
			newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
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
