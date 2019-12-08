package com.Simon.restaurantList.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Simon.restaurantList.facade.AccountFacade;
import com.Simon.restaurantList.model.UserModel;

@Controller
@RequestMapping(value = "/Users")
public class UserController {

	AccountFacade accountFacade;

	@Autowired
	public UserController(@Qualifier("defaultAccountFacade") AccountFacade accountFacade) {
		this.accountFacade = accountFacade;
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
	public UserModel getUserByEmail(String email) {
		return accountFacade.getUserByEmail(email);
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public List<UserModel> getAllUsers() {
		return accountFacade.getAllUsers();
	}
	
	@RequestMapping(value = "/usernamesModification", method = RequestMethod.PUT)
	@ResponseBody
	public Map<String, String> updateName(@RequestBody Map<String, String> names) {
		String firstName = names.get("firstName");
		String lastName = names.get("lastName");
		accountFacade.updateName(firstName, lastName);
		return names;
	}
	
	@RequestMapping(value = "/passwordModification", method = RequestMethod.PUT)
	@ResponseBody
	public String updatePassword(String newPassword) {
		accountFacade.updatePassword(newPassword);
		return "Password Changed Successfully";
	}
	
	@RequestMapping(value = "/emaildModification", method = RequestMethod.PUT)
	@ResponseBody
	public String updateEmail(String newEmail) {
		accountFacade.updateEmail(newEmail);
		return "Email Changed Successfully";
	}
	
}
