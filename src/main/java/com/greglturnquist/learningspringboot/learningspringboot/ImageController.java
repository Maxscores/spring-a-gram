package com.greglturnquist.learningspringboot.learningspringboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greglturnquist.learningspringboot.learningspringboot.Image;


@RestController
public class ImageController {
    @GetMapping("/api/images")
    Flux<Image> images() {
        return Flux.just(
                new Image("1", "logo-herlulenum.jpeg"),
                new Image("2", "logo-markerfelt.jpeg"),
                new Image("3", "logo-menlo.jpeg")
        );
    }

    @PostMapping("/api/images")
    Mono<Void> create(@RequestBody Flux<Image> images) {
        return images
                .map(image -> {
                    System.out.println("We will save " + image +
                            " to a Reactive database soon!");
                    return image;
                })
                .then();
    }
}
