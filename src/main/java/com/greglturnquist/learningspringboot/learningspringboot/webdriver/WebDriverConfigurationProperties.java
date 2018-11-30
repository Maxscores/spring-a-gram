package com.greglturnquist.learningspringboot.learningspringboot.webdriver;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("com.greglturnquist.webdriver")
public class WebDriverConfigurationProperties {
    private Firefox firefox = new Firefox();
    private Safari safari = new Safari();
    private Chrome chrome = new Chrome();

    @Data
    static class Firefox {
        public boolean enabled = true;
    }
    @Data
    static class Safari {
        public boolean enabled = true;
    }
    @Data
    static class Chrome {
        public boolean enabled = true;
    }
}
