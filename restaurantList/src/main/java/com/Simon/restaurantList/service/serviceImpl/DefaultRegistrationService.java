package com.Simon.restaurantList.service.serviceImpl;

import org.springframework.beans.factory.annotation.Qualifier;

import com.Simon.restaurantList.dao.UserDao;
import com.Simon.restaurantList.service.RegistrationService;

public class DefaultRegistrationService implements RegistrationService {
	
	UserDao userDao;
	
	public DefaultRegistrationService(@Qualifier("UserDao") UserDao userDao)
	{
		
	}
	@Override
	public void createNewUser() {
		// TODO Auto-generated method stub
		
	}
	
}
