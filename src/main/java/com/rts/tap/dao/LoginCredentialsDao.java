package com.rts.tap.dao;

import com.rts.tap.model.LoginCredentials;

public interface LoginCredentialsDao {
	
	LoginCredentials save(LoginCredentials loginCredentials);

	LoginCredentials findById(Long userId);

	String updatePassword(LoginCredentials loginCredentials);
	void updateFailedAttempts(LoginCredentials loginCredentials);

	LoginCredentials findEmail(String email);

}
