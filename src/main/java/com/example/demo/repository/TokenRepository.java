package com.example.demo.repository;
import com.example.demo.model.Token;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface TokenRepository extends MongoRepository<Token, String> {

    @Query("{name:'?0'}")
    Token findTokenByName(String name);

    @Query("{category:'?0'}")
    List<Token> findAllByCategory(String category);
}