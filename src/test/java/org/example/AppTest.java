package org.example;

import io.percy.selenium.Percy;
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

    @Test
    public void googleTest(TestInfo testInfo) {
        Map<String, Object> options = new HashMap<String, Object>();
        options.put("testCase", testInfo.getDisplayName());

        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://google.com");
        percy = new Percy(driver);
        percy.snapshot("Google Test", options);
    }
}