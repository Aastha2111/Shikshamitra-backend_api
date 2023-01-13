package com.ncuindia.peermentoring.service;

import java.util.List;

import com.ncuindia.peermentoring.model.UserDetails;

public interface UserDetailsService {
    UserDetails saveUserDetails(UserDetails uDetails);
	List<UserDetails> getAllUserDetails();
	UserDetails getUserDetailsById(String id);
	UserDetails updateUserDetails(UserDetails uDetails, String id);
	void deleteUser(String id);
}
