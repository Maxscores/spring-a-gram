package com.greglturnquist.learningspringboot.learningspringboot;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest(excludeAutoConfiguration = EmbeddedMongoAutoConfiguration.class)
public class LiveImageRepositoryTests {
    @Autowired
    ImageRepository repository;

    @Autowired
    MongoOperations operations;

    @Before
    public void setUp() {
        ImageRepositoryTestMethods.setUp(operations);
    }

    @Test
    public void findAllShouldWork() {
        ImageRepositoryTestMethods.findAllShouldWork(repository);
    }

    @Test
    public void findOneByNameShouldWork() {
        ImageRepositoryTestMethods.findOneByNameShouldWork(repository);
    }

}
