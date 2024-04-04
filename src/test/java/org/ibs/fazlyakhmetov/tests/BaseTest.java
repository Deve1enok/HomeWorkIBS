package org.ibs.fazlyakhmetov.tests;

import org.ibs.fazlyakhmetov.tests.pages.QualitMainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;


    @BeforeAll
    static void beforeAll () {
        System.setProperty("webdriver.chromedriver.driver", "src/test/resources/apps/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/");
    }

    @AfterAll
    static void afterAll() {
        driver.close();
        driver.quit();
    }}

