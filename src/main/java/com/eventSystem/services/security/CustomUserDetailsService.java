package com.eventSystem.services.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import com.eventSystem.domain.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eventSystem.services.RestConsumerService;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CustomUserDetailsService implements UserDetailsService {
	
	private RestConsumerService restImp;
    private Converter<Optional<User>, UserDetails> userUserDetailsConverter;

    @Autowired
    public void setRestConsumerService(RestConsumerService restImp) {
        this.restImp = restImp;
    }

    @Autowired
    @Qualifier("userToUserDetails")
    public void setUserUserDetailsConverter(Converter <Optional<User>, UserDetails> userUserDetailsConverter) {
        this.userUserDetailsConverter = userUserDetailsConverter;
    }	
	
    public UserDetails loadUserByUsername(String username)
      throws UsernameNotFoundException {
    
	  return userUserDetailsConverter.convert(restImp.getByUsername(username));
  
    }
  
}
