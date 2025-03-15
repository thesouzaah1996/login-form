package com.backend.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.backend.model.Login;
import com.backend.backend.repository.LoginRepository;

@Service
public class LoginService {
    
    
    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public boolean authenticate(Login login) {
        Login user = loginRepository.findByEmail(login.getEmail());

        if (user != null && user.getPassword().equals(login.getPassword())) {
            user.setLoggedIn(true);
            loginRepository.save(user);
            return true;
        }

        return false;
    }
}
