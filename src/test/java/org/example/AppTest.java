package org.example;

import io.percy.selenium.Percy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;

public class AppTest {
    private static WebDriver driver;
    private static Percy percy;

    @Test
    public void googleTest() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://google.com");
        percy = new Percy(driver);
        percy.snapshot("Google Test");
    }
}