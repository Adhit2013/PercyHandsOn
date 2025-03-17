package org.example;

import io.percy.selenium.Percy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class AppTest {
    private static WebDriver driver;
    private static Percy percy;

    @BeforeEach
    public void setUp() {
        // Set up ChromeDriver and Percy for the test
        ChromeOptions chromeOptions = new ChromeOptions();
        // You can set other options here, for example, for headless mode
        // options.addArguments("--headless");

        driver = new ChromeDriver(chromeOptions);  // Initialize the WebDriver
        percy = new Percy(driver);           // Initialize Percy with the WebDriver
    }

    @Test
    public void googleTest(TestInfo testInfo) {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("testCase", testInfo.getDisplayName());

        driver.get("https://google.com");
        percy.snapshot("Google Test", options);
    }

    @Test
    public void yahooTest(TestInfo testInfo) {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("testCase", testInfo.getDisplayName());

        driver.get("https://yahoo.com");
        percy.snapshot("Yahoo Test", options);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser after the test is finished
        }
    }
}