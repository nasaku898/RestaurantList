package com.Simon.restaurantList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.Simon.restaurantList.facade.AccountFacade;
import com.Simon.restaurantList.model.UserModel;

//Implement Admin role in future
@Controller
public class AuthenticationController {
	
	AccountFacade accountFacade;
	
	@Autowired
	AuthenticationController(@Qualifier("defaultAccountFacade") AccountFacade accountFacade){
		this.accountFacade = accountFacade;
	}
	
	//Implement request body later
	@RequestMapping(value ="/register" , method= RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void registerUser(@RequestBody UserModel user)
	{
		user.setRoles("USER");
		accountFacade.createNewUser(user);
	} 
	
	
	@RequestMapping(value = "/authentication/login" , method=RequestMethod.GET)
	@ResponseBody
	public String validateLogin() {
		return "Login Succesful";
	}
	
	
}
