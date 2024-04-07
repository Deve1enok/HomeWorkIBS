package org.ibs.fazlyakhmetov.tests;

import org.ibs.fazlyakhmetov.data.DataFakeAssertResults;
import org.ibs.fazlyakhmetov.data.DataProductName;
import org.ibs.fazlyakhmetov.pages.QualitMainPage;
import org.ibs.fazlyakhmetov.pages.QualitProductPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class QualitAddVegetableProductTest extends BaseTest {

    QualitMainPage qualitMainPage = new QualitMainPage(driver);
    QualitProductPage qualitProductPage = new QualitProductPage(driver);
    DataProductName dataProductName = new DataProductName();
    DataFakeAssertResults dataFakeAssertResults = new DataFakeAssertResults();

    @Test
    @DisplayName("Добавление в список товаров \"овоща\" с типом \"овощ\", без чек-бокса \"экзотический\"")
    @Tag("positive")
    void addVegetableWithTypeVegetableAndWithoutCheckboxExotic() {

        qualitMainPage.sandboxDropDownClick()
                .menuProductClick();
        qualitProductPage.openMenuAddProducts()
                .setProductName(dataProductName.notExoticVegetable)
                .selectProductTypeVegetable()
                .clickSaveResults();

        QualitProductPage.checkAddedFruit(dataFakeAssertResults.notExoticVegResult);
        Assertions.assertEquals(5, QualitProductPage.checkQuantityProducts(),
                "Количество строк в таблице не равно 5");

        qualitMainPage.sandboxDropDownClick()
                .resetResults();

        QualitProductPage.checkAddedFruit(dataFakeAssertResults.defaultFruitNum4);
        Assertions.assertEquals(4, QualitProductPage.checkQuantityProducts(),
                "Количество строк в таблице не равно 4");
    }

    @Test
    @DisplayName("Добавление в список товаров \"овоща\" с типом \"овощ\" и чек-боксом \"экзотический\"")
    @Tag("positive")
    void addVegetableWithTypeVegetableAndCheckboxExotic() {

        qualitMainPage.sandboxDropDownClick()
                .menuProductClick();
        qualitProductPage.openMenuAddProducts()
                .setProductName(dataProductName.exoticVegetable)
                .selectProductTypeVegetable()
                .selectExoticCheckboxTrue()
                .clickSaveResults();

        QualitProductPage.checkAddedFruit(dataFakeAssertResults.exoticVegResult);
        Assertions.assertEquals(5, QualitProductPage.checkQuantityProducts(),
                "Количество строк в таблице не равно 4");

        qualitMainPage.sandboxDropDownClick()
                .resetResults();

        QualitProductPage.checkAddedFruit(dataFakeAssertResults.defaultFruitNum4);
        Assertions.assertEquals(4, QualitProductPage.checkQuantityProducts(),
                "Количество строк в таблице не равно 4");
    }
}
