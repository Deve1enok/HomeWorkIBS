package org.ibs.fazlyakhmetov.tests.pages;

import org.ibs.fazlyakhmetov.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class QualitMainPage extends BaseTest {


//    @FindBy(xpath = "//li/a[@id='navbarDropdown']")
//    private WebElement sandboxDropDown;
//
//    @FindBy(xpath = "//a[@href='/food']")
//    private WebElement products;

    private final WebElement
            sandboxDropDown = driver.findElement(By.xpath("//li/a[@id='navbarDropdown']")),
            products = driver.findElement(By.xpath("//a[@href='/food']"));


    public QualitMainPage sandboxDropDownClick() {
        sandboxDropDown.click();
        return this;
    }
    public QualitMainPage menuProductClick() {
        products.click();
        return this;
    }


}
