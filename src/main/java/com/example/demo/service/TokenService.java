package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.model.Token;
import com.example.demo.repository.TokenRepository;

@Service
public class TokenService {
    private static final Logger log = LoggerFactory.getLogger(TokenService.class);

    @Autowired
    private TokenRepository tokenRepo;

    public Token saveToken(String name, String description, String category) {
        Token newToken = tokenRepo.save(new Token(name, description, category));
        log.info("Save complete");
        return newToken;
    }

    public Token getTokenByName(String name) {
        log.info(" Getting token by name : " + name);
        Token token = tokenRepo.findTokenByName(name);
        log.info(token.getId());
        return token;
    }

    public List<Token> findAllTokensByCategory(String category) {
        List<Token> tokenList = tokenRepo.findAllByCategory(category);
        tokenList.forEach(token -> log.info(token.getId()));
        return tokenList;
    }

    public List<Token> findAllTokens() {
        List<Token> tokenList = tokenRepo.findAll();
        tokenList.forEach(token -> log.info(token.getId()));
        return tokenList;
    }
}