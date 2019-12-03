package com.Simon.restaurantList.service.serviceImpl;


import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.Simon.restaurantList.dao.UserDao;
import com.Simon.restaurantList.exceptions.InvalidEmailException;
import com.Simon.restaurantList.model.UserModel;
import com.Simon.restaurantList.service.UserService;

@Service
public class DefaultUserService implements UserService {
	
	
	private UserDao userDao;

	@Autowired()
	public DefaultUserService(@Qualifier("UserDaoImpl") UserDao userDao)
	{
		this.userDao = userDao;
	}
	

	@Override
	public int updateEmail(UserModel updatedUser) throws InvalidEmailException {
		final String newEmail = updatedUser.getEmailAdress();
		if(isEmailValid(newEmail))
			return userDao.update(updatedUser);
		else
			return 0;
	}

	@Override
	public int updateName(UserModel updatedUser) {
		return userDao.update(updatedUser);
	}

	//Add password validation in the future
	@Override
	public int updatePassword(UserModel updatedUser) {
		return userDao.update(updatedUser);
	}
	
	public boolean isEmailValid(String email)
	{
		String regex = "\\w+\\@\\w+\\.[A-Za-z]+";
		return Pattern.matches(regex, email);		
	}
}
