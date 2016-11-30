package com.eventSystem.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.eventSystem.comands.UserCreateCommand;
import com.eventSystem.domain.User;

@Component("userCreateToUser")
public class UserCreateToUser implements Converter<UserCreateCommand, User> {
    @Override
    public User convert(UserCreateCommand userCreateCommand) {
        User u = new User();
        
        u.setEmail(userCreateCommand.getEmail());
        u.setPassword(userCreateCommand.getPassword());
        u.setUsername(userCreateCommand.getUsername());
        u.setRole(userCreateCommand.getRole());
        
        return u;
        
    }


}
