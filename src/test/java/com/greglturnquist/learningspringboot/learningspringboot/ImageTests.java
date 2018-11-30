package com.greglturnquist.learningspringboot.learningspringboot;

import com.greglturnquist.learningspringboot.learningspringboot.Image;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class ImageTests {
    @Test
    public void imagesManagedByLombokShouldWork() {
        Image image = new Image("id", "file-name.jpg");
        assertThat(image.getId()).isEqualTo("id");
        assertThat(image.getName()).isEqualTo("file-name.jpg");
    }
}
