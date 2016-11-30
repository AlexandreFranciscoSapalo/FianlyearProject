package com.eventSystem.services.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class EncryptionServiceImpl implements EncryptionService {

    private BCryptPasswordEncoder encryptor;

    @Autowired
    public void setBCryptPasswordEncoder(BCryptPasswordEncoder encryptor) {
        this.encryptor = encryptor;
    }

    public String encryptString(String input){
        return encryptor.encode(input);
    }

    public boolean checkPassword(String plainPassword, String encryptedPassword){
        return encryptor.matches(plainPassword, encryptedPassword);
    }
}
