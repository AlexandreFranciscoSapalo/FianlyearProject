package com.eventSystem.services.repositories;

import com.eventSystem.domain.Role;
import com.eventSystem.domain.User;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;



public interface UserRepository extends PagingAndSortingRepository<User, Integer> {

	 Optional<User> findByUsername(String username);
	 List<User> findByRole(Role role, Pageable pageable);
	 Optional<User> findByUserToken(String userToken);
}
