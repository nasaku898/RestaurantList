package com.Simon.restaurantList.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Simon.restaurantList.dao.UserDao;
import com.Simon.restaurantList.model.UserModel;

@Service("defaultUserDetailServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
	UserDao userDao;
	
	@Autowired
	public UserDetailsServiceImpl(@Qualifier("userDaoImpl") UserDao userDao) {
		this.userDao = userDao;
	}
	
	//handle exception like null value later
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserModel> user = userDao.getUser(username);
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(user.get());
		return userDetailsImpl;
	}

}
