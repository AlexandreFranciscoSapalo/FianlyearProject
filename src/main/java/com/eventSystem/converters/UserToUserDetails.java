package com.eventSystem.converters;

import com.eventSystem.controllers.web.IndexController;
import com.eventSystem.domain.User;
import com.eventSystem.services.security.UserDetailsImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Component
public class UserToUserDetails implements Converter<Optional<User>, UserDetails> {
    @Override
    public UserDetails convert(Optional<User> user) {
        UserDetailsImpl userDetails = new UserDetailsImpl();

        if (user.isPresent()) { 
        	User u = user.get();
            userDetails.setUsername(u.getUsername());
            userDetails.setPassword(u.getPasswordHash());
            userDetails.setEnabled(u.getEnabled());

            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority("ROLE_"+u.getRole().name()));
            
            userDetails.setAuthorities(authorities);
            
            return userDetails;
        }

        throw new UsernameNotFoundException("username not found");
        
    }
}
