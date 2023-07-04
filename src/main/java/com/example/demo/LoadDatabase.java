package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Token;
import com.example.demo.repository.TokenRepository;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TokenRepository tokenRepository) {
        if (tokenRepository.count() == 0) {
            return args -> {
                log.info("Preloading "
                        + tokenRepository.save(new Token("SampleToken1", "Bilbo Baggins", "burglar")));
                log.info("Preloading "
                        + tokenRepository.save(new Token("SampleToken2", "Frodo Baggins", "thief")));
            };
        } else {
            return args -> {
                log.info("Database already loaded");
            };
        }
    }
}