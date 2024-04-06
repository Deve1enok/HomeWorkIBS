package org.ibs.fazlyakhmetov.tests;

import org.aeonbits.owner.ConfigFactory;
import org.ibs.fazlyakhmetov.config.QualitConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    public static QualitConfig configOwner = ConfigFactory.create(QualitConfig.class);

    @BeforeAll
    static void beforeAll() {
        System.setProperty("webdriver.chromedriver.driver", configOwner.chromeDriver());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get(configOwner.baseUrl());

    }

    @AfterAll
    static void afterAll() {
        driver.close();
        driver.quit();
    }
}

