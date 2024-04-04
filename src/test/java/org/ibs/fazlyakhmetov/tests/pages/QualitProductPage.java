package org.ibs.fazlyakhmetov.tests.pages;

import org.ibs.fazlyakhmetov.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class QualitProductPage extends BaseTest {
    private final WebElement addButton = driver.findElement(By.xpath("//div/button[@data-target='#editModal']")),
    productNameField = driver.findElement(By.xpath("//div/input[@id='name']")),
//            productTypeDropBox = driver.findElement(By.xpath("//div/select[@id='type']")),
    productTypeFruit = driver.findElement(By.xpath("//div/select[@id='type']/option[@*='FRUIT']")),
    exoticCheckbox = driver.findElement(By.xpath("//div/input[@*='exotic']")),
    saveButton = driver.findElement(By.xpath("//div/button[@*='save']"));
}
