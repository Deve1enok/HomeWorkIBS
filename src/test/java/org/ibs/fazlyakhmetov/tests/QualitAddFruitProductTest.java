package org.ibs.fazlyakhmetov.tests;

import org.ibs.fazlyakhmetov.data.DataFakeAssertResults;
import org.ibs.fazlyakhmetov.data.DataProductName;
import org.ibs.fazlyakhmetov.pages.QualitMainPage;
import org.ibs.fazlyakhmetov.pages.QualitProductPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class QualitAddFruitProductTest extends BaseTest {

    QualitMainPage qualitMainPage = new QualitMainPage(driver);
    QualitProductPage qualitProductPage = new QualitProductPage(driver);
    DataProductName dataProductName = new DataProductName();
    DataFakeAssertResults dataFakeAssertResults = new DataFakeAssertResults();

    @Test
    @DisplayName("Добавление в список товаров \"фрукта\" с типом \"фрукт\" и чек-боксом \"экзотический\"")
    @Tag("positive")
    void addFruitWithTypeFruitAndCheckboxExotic() {

        qualitMainPage.sandboxDropDownClick()
                .menuProductClick();
        qualitProductPage.openMenuAddProducts()
                .setProductName(dataProductName.exoticFruit)
                .selectProductTypeFruit()
                .selectExoticCheckboxTrue()
                .clickSaveResults();

        QualitProductPage.checkAddedFruit(dataFakeAssertResults.exoticFruitResult);
        Assertions.assertEquals(5, QualitProductPage.checkQuantityProducts(),
                "Количество строк в таблице не равно 5");

        qualitMainPage.sandboxDropDownClick()
                .resetResults();

        QualitProductPage.checkAddedFruit(dataFakeAssertResults.defaultFruitNum4);
        Assertions.assertEquals(4, QualitProductPage.checkQuantityProducts(),
                "Количество строк в таблице не равно 4");
    }

    @Test
    @DisplayName("Добавление в список товаров \"фрукта\" с типом \"фрукт\", без чек-бокса \"экзотический\"")
    @Tag("positive")
    void addFruitWithTypeFruitAndWithoutCheckboxExotic() {

        qualitMainPage.sandboxDropDownClick()
                .menuProductClick();
        qualitProductPage.openMenuAddProducts()
                .setProductName(dataProductName.notExoticFruit)
                .selectProductTypeFruit()
                .clickSaveResults();

        QualitProductPage.checkAddedFruit(dataFakeAssertResults.notExoticFruitResult);
        Assertions.assertEquals(5, QualitProductPage.checkQuantityProducts(),
                "Количество строк в таблице не равно 5");

        qualitMainPage.sandboxDropDownClick()
                .resetResults();

        QualitProductPage.checkAddedFruit(dataFakeAssertResults.defaultFruitNum4);
        Assertions.assertEquals(4, QualitProductPage.checkQuantityProducts(),
                "Количество строк в таблице не равно 4");

    }

    @ValueSource(strings = {
            "Дыня",
            "Банан",
            "Вишня"
    })
    @ParameterizedTest(name = "Добавления фркута {0} с типом фрукт")
    @Tag("parameterized")
    void parameterizedFruitNotExoticTest(String testData) {

        qualitMainPage.sandboxDropDownClick()
                .menuProductClick();
        qualitProductPage.openMenuAddProducts()
                .setProductName(testData)
                .selectProductTypeFruit()

                .clickSaveResults();
    }

    @Test
    @DisplayName("Пример теста без PageObject")
    @Disabled("Тест без PageObject - не востребован")
    @Tag("positive")
    void exampleTestWithoutPageObject() {
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
        Assertions.assertEquals("5 Яблоко Фрукт true", driver.findElement(By.xpath(
                "//tbody/tr[5]")).getText());
    }

}