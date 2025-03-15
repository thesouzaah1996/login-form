package com.backend.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.backend.dto.LoginDTO;
import com.backend.backend.model.Login;
import com.backend.backend.service.LoginService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LoginController {
    
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        Login login = new Login();
        login.setEmail(loginDTO.getEmail());
        login.setPassword(loginDTO.getPassword());

        boolean isAuthenticated = loginService.authenticate(login);
    
        if (isAuthenticated) {
            return ResponseEntity.ok("Login bem sucedido");
        } else {
            return ResponseEntity.status(401).body("Credenciais inválidas");
        }
    }
}
