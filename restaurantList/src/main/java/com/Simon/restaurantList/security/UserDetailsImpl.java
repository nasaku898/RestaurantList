package com.Simon.restaurantList.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Simon.restaurantList.model.UserModel;

public class UserDetailsImpl implements UserDetails{

	private UserModel user;
	
	public UserDetailsImpl(UserModel user) {
		this.user = user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authories = new ArrayList<>();
		//get list of permission
		user.getPermissionList().forEach(permission ->{
			GrantedAuthority authority = new SimpleGrantedAuthority(permission);
			authories.add(authority);
		});
		
		//get role list
		user.getRoleList().forEach(role ->{
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" +role);
			authories.add(authority);
		});
		return authories;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getEmailAdress();
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
