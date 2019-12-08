package com.Simon.restaurantList.service;

import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.Simon.restaurantList.exceptions.InvalidEmailException;
import com.Simon.restaurantList.model.UserModel;

public interface UserService {
	
	public int updateEmail(UserModel updatedUser) throws InvalidEmailException;
	public int updateName(UserModel updatedUser);
	public int updatePassword(UserModel updatedUser);
	public void deleteUser(UserModel userToDelete);
	public UserModel getUserByEmail(String email);
	public List<UserModel> getAllUsers();
	public UserModel getCurrentUser();
}
