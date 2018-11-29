package com.greglturnquist.learningspringboot.learningspringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;

@Component
public class InitDatabase {
    @Bean
    CommandLineRunner init(MongoOperations opertations) {
        return args -> {
            opertations.dropCollection(Image.class);

            opertations.insert(new Image("1", "learning-spring-boot-cover.jpg"));
            opertations.insert(new Image("2", "learning-spring-boot-2nd-edition-cover.jpg"));
            opertations.insert(new Image("3", "bazinga.png"));

            opertations.findAll(Image.class).forEach(image -> {
                System.out.println(image.toString());
            });
        };
    }
}
