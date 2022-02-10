package com.mouritech.springbootsecuritythymeleafexample.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mouritech.springbootsecuritythymeleafexample.controller.dto.UserRegistrationDto;
import com.mouritech.springbootsecuritythymeleafexample.entity.Role;
import com.mouritech.springbootsecuritythymeleafexample.entity.User;
import com.mouritech.springbootsecuritythymeleafexample.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserEmail(username);
		if(user ==  null) {
			throw new UsernameNotFoundException("Invalid username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserEmail(),
				new BCryptPasswordEncoder().encode(user.getUserPassword()),mapRolesToAuthorities(user.getRoles()));
	}



	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(
			Collection<Role> roles) {

		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.collect(Collectors.toList());
	}



	@Override
	public User save(UserRegistrationDto registrationDto) {
		User user = new User(registrationDto.getUserFName(), 
				registrationDto.getUserLName(), 
				registrationDto.getUserEmail(), 
				registrationDto.getUserPassword(), 
				
				Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
	}



}