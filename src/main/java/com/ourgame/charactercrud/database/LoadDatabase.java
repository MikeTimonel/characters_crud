package com.ourgame.charactercrud.database;

import com.ourgame.charactercrud.dto.CharacterDTO;
import com.ourgame.charactercrud.repository.CharacterRepository;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
public class LoadDatabase {
    /*private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CharacterRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new CharacterDTO("1","Mike Timonel", "Brown" , "Brown", 18, 166)));
            log.info("Preloading " + repository.save(new CharacterDTO("2", "Charles Darwin", "Light Brown", "Brown", 20, 168)));
        };
    }*/
}
