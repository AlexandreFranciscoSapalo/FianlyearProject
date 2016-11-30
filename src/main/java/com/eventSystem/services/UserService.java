package com.eventSystem.services;

import java.util.List;
import java.util.Optional;

import com.eventSystem.domain.Role;
import com.eventSystem.domain.User;

public interface UserService extends CRUDService<User> {

	Optional<User> findByUserName(String userName);
	Optional<User> findByUserToken(String userToken);
	List<User> findByRole(Role role, int page);
	User createNewUser(String email, String username, String password, String role);

}
