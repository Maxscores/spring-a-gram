package com.greglturnquist.learningspringboot.learningspringboot;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Image {

    public Integer id;
    public String name;

    public Image(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Image() {}
}
