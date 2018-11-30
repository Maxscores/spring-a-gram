package com.greglturnquist.learningspringboot.learningspringboot.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;


@Configuration
@ConditionalOnClass(WebDriver.class)
@EnableConfigurationProperties(WebDriverConfigurationProperties.class)
@Import({
    ChromeDriverFactory.class,
    FirefoxDriverFactory.class,
    SafariDriverFactory.class
})
public class WebDriverAutoConfiguration {
    @Autowired
    WebDriverConfigurationProperties properties;

    @Primary
    @Bean(destroyMethod = "quit")
    @ConditionalOnMissingBean(WebDriver.class)
    public WebDriver webDriver(
            FirefoxDriverFactory firefoxDriverFactory,
            SafariDriverFactory safariDriverFactory,
            ChromeDriverFactory chromeDriverFactory) {
        WebDriver driver = null;

        if  (driver == null) {
            driver = firefoxDriverFactory.getObject();
        }

        if  (driver == null) {
            driver = chromeDriverFactory.getObject();
        }

        if  (driver == null) {
            driver = safariDriverFactory.getObject();
        }

        if (driver == null) {
            driver = new HtmlUnitDriver();
        }

        return driver;
    }
}
