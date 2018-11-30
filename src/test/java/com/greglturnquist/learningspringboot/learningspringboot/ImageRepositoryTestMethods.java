package com.greglturnquist.learningspringboot.learningspringboot;

import org.springframework.data.mongodb.core.MongoOperations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

public class ImageRepositoryTestMethods {

    /**
     * To avoid @code block() calls, use @link MongoOperations, to make everything block
     * ImageRepository is non-blocking reactive insertions
     */
    public static void setUp(MongoOperations operations) {
        operations.dropCollection(Image.class);
        operations.insert(new Image("1", "test-image-1.jpg"));
        operations.insert(new Image("2", "test-image-2.jpg"));
        operations.insert(new Image("3", "test-image-3.jpg"));
        operations.findAll(Image.class).forEach(image -> {
            System.out.println(image.toString());
        });
    }

    public static void findAllShouldWork(ImageRepository repository) {
        Flux<Image> images = repository.findAll();
        StepVerifier.create(images)
            .recordWith(ArrayList::new)
            .expectNextCount(3)
            .consumeRecordedWith(results -> {
                assertThat(results).hasSize(3);
                assertThat(results)
                    .extracting(Image::getName)
                    .contains(
                            "test-image-1.jpg",
                            "test-image-2.jpg",
                            "test-image-3.jpg"
                    );
            })
            .expectComplete()
            .verify();
    }

    public static void findOneByNameShouldWork(ImageRepository repository) {
        Mono<Image> image = repository.findByName("test-image-1.jpg");
        StepVerifier.create(image)
            .expectNextMatches(results -> {
                assertThat(results.getName()).isEqualTo("test-image-1.jpg");
                assertThat(results.getId()).isEqualTo("1");
                return true;
            });

    }
}
