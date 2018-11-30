package com.greglturnquist.learningspringboot.learningspringboot;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // outputs on a random AVAILABLE port
public class EndToEndTests {
    static ChromeDriverService service;
    static ChromeDriver driver;

    @LocalServerPort
    int port;

    @BeforeClass
    public static void setUp() throws IOException {
        System.setProperty("webdriver.chrome.driver", "ext/chromedriver");
        service = ChromeDriverService.createDefaultService();
        driver = new ChromeDriver(service);
        Path testResults = Paths.get("build", "test-results");
        if (!Files.exists(testResults)) {
            Files.createDirectory(testResults);
        }
    }

    @AfterClass
    public static void tearDown() {
        service.stop();
    }

    @Test
    public void homePageShouldWork() throws IOException {

    }
}
