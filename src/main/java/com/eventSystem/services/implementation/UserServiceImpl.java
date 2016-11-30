package com.eventSystem.services.implementation;

import com.eventSystem.domain.Role;
import com.eventSystem.domain.User;
import com.eventSystem.services.repositories.UserRepository;
import com.eventSystem.services.UserService;
import com.eventSystem.services.security.EncryptionService;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private EncryptionService encryptionService;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService) {
        this.encryptionService = encryptionService;
    }

    @Override
    public List<?> listAll() {
        List<User> users = new ArrayList<>();
        try {
			userRepository.findAll().forEach(users::add); //fun with Java 8
			return users;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public Optional<User> getById(Integer id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public User saveOrUpdate(User domainObject) {

        if(domainObject.getPassword() != null){
            domainObject.setPasswordHash(encryptionService.encryptString(domainObject.getPassword()));
        }
        try {
			return userRepository.save(domainObject);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public void delete(Integer id) {
        try {
			User user = userRepository.findOne(id);
			userRepository.delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

	@Override
	public List<User> findByRole(Role role, int page) {

		try {
			return userRepository.findByRole(role, new PageRequest(page, 10, Direction.DESC, "id"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public User createNewUser(String email, String username, String password, String role) {
		
		User u = new User();
        u.setEmail(email);
        u.setEnabled(true);
        u.setPassword(password);
        u.setUserToken(RandomStringUtils.randomAlphanumeric(30)+username);
        switch (role) {
			case "attendee":  u.setRole(Role.ATTENDEE); break;
			case "ATTENDEE":  u.setRole(Role.ATTENDEE); break;
			case "admin":  u.setRole(Role.ADMIN); break;
			case "ADMIN":  u.setRole(Role.ADMIN); break;
			case "organizer":  u.setRole(Role.ORGANIZER); break;
			case "ORGANIZER":  u.setRole(Role.ORGANIZER); break;
			default:  u.setRole(Role.ATTENDEE); break;
        }
        u.setUsername(username);
        
        try {
			return saveOrUpdate(u);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

	@Override
	public Optional<User> findByUserToken(String userToken) {
		try {
			return userRepository.findByUserToken(userToken);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
