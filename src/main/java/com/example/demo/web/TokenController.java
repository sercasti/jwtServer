package com.example.demo.web;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.example.demo.model.Token;
import com.example.demo.service.TokenService;

@RestController
public class TokenController {
    
    @Autowired
    private TokenService service;

    @GetMapping("/tokens")
    List<Token> all() {
      return service.findAllTokens();
    }

    @PostMapping("/create")
    Token createToken(@RequestBody Token newToken) {
      return service.saveToken(newToken.getName(), newToken.getDescription(), newToken.getCategory());
    }
}