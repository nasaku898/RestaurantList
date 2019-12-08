package com.Simon.restaurantList.service.serviceImpl;

import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.Simon.restaurantList.dao.UserDao;
import com.Simon.restaurantList.exceptions.InvalidEmailException;
import com.Simon.restaurantList.model.UserModel;
import com.Simon.restaurantList.service.UserService;

@Service("defaultUserService")
public class DefaultUserService implements UserService {

	private UserDao userDao;
	private UserDetailsService userDetailsService;

	@Autowired
	public DefaultUserService(@Qualifier("userDaoImpl") UserDao userDao,
			@Qualifier("defaultUserDetailServiceImpl") UserDetailsService userDetailsService) {
		this.userDao = userDao;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public int updateEmail(UserModel updatedUser) throws InvalidEmailException {
		final String newEmail = updatedUser.getEmailAdress();
		if (isEmailValid(newEmail))
			return userDao.update(updatedUser);
		else
			return 0;
	}

	@Override
	public int updateName(UserModel updatedUser) {
		return userDao.update(updatedUser);
	}

	// Add password validation in the future
	@Override
	public int updatePassword(UserModel updatedUser) {
		return userDao.update(updatedUser);
	}

	// Add validation for repeated email already in DB
	public boolean isEmailValid(String email) {
		String regex = "\\w+\\@\\w+\\.[A-Za-z]+";
		return Pattern.matches(regex, email);
	}

	// Add force relogin eventually
	@Override
	public void deleteUser(UserModel userToDelete) {
		userDao.delete(userToDelete);
	}

	@Override
	public UserModel getUserByEmail(String email) {
		return userDao.getUser(email).get();
	}

	@Override
	public List<UserModel> getAllUsers() {
		return userDao.getAll();
	}

	@Override
	public UserModel getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			String username = userDetailsService.loadUserByUsername(((UserDetails) principal).getUsername()).getUsername();
			return userDao.getUser(username).get();
		} else {
			throw new IllegalStateException("No user authenticated");
		}

	}
}
