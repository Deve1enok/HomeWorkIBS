package org.ibs.fazlyakhmetov.tests;

import org.ibs.fazlyakhmetov.tests.pages.QualitMainPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FirstTest extends BaseTest {

    public static QualitMainPage qualitMainPage;

    @Test
    void test2() throws InterruptedException {
        qualitMainPage.sandboxDropDownClick();
        Thread.sleep(3000);
        qualitMainPage .menuProductClick();
        Thread.sleep(3000);
    }

    @Test
    void test()  throws InterruptedException {
        WebElement sandboxDropDown = driver.findElement(By.xpath("//li/a[@id='navbarDropdown']"));
        sandboxDropDown.click();
        WebElement products = driver.findElement(By.xpath("//a[@href='/food']"));
        products.click();
        WebElement btn = driver.findElement(By.xpath("//div/button[@data-target='#editModal']"));
        btn.click();
        WebElement nameTovar = driver.findElement(By.xpath("//div/input[@id='name']"));
        nameTovar.sendKeys("Яблоко");
        WebElement type = driver.findElement(By.xpath("//div/select[@id='type']"));
        type.click();
        WebElement typeFruit = driver.findElement(By.xpath("//div/select[@id='type']/option[@*='FRUIT']"));
        typeFruit.click();
        WebElement exoticBtn = driver.findElement(By.xpath("//div/input[@*='exotic']"));
        exoticBtn.click();
        WebElement btnSave = driver.findElement(By.xpath("//div/button[@*='save']"));
        btnSave.click();

        Thread.sleep(3000);
    }
}