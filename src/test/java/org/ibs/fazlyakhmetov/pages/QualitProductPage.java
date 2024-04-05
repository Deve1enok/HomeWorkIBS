package org.ibs.fazlyakhmetov.pages;

import org.ibs.fazlyakhmetov.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class QualitProductPage {
    public static WebDriver driver;

    public QualitProductPage(WebDriver webDriver) {
        PageFactory.initElements(BaseTest.driver, this);
        driver = webDriver;
    }

    @FindBy(xpath = "//div/button[@data-target='#editModal']")
    private WebElement addButton;
    @FindBy(xpath = "//div/input[@id='name']")
    private WebElement productNameField;
    @FindBy(xpath = "//div/select[@id='type']")
    private WebElement productType;
    @FindBy(xpath = "//div/select[@id='type']/option[@*='FRUIT']")
    private WebElement productTypeFruit;
    @FindBy(xpath = "//div/select[@id='type']/option[@*='VEGETABLE']")
    private WebElement productTypeVegetable;
    @FindBy(xpath = "//div/input[@*='exotic']")
    private WebElement exoticCheckbox;
    @FindBy(xpath = "//div/button[@*='save']")
    private WebElement saveButton;
    @FindBy(xpath = "//tbody/tr")
    private WebElement defaultTable;
    @FindBy(xpath = "//tbody/tr[5]")
    private WebElement tableResults;
    @FindBy(xpath = "//div/a[@id='reset']")
    private WebElement resetData;


    public QualitProductPage openMenuAddProducts() {
        addButton.click();
        return this;
    }

    public QualitProductPage setProductName(String value) {
        productNameField.sendKeys(value);
        return this;
    }

    public QualitProductPage selectProductTypeFruit() {
        productTypeFruit.click();
        return this;
    }

    public QualitProductPage selectProductTypeVegetable() {
        productTypeVegetable.click();
        return this;
    }

    public QualitProductPage selectExoticCheckboxTrue() {
        exoticCheckbox.click();
        return this;
    }

    public QualitProductPage clickSaveResults() {
        saveButton.click();
        return this;
    }

    public String checkResultAfterReset() {
        return defaultTable.getText();
    }

    public String checkResultAddProduct() {
        return tableResults.getText();
    }

    /**
     * Цикл для подсчета количества элементов(продуктов) в таблице.
     * Используается для проверки результата
     *
     * @author Fazlyakhmetov_Dinar
     */
    public static int checkQuantityProducts() {
        int count = 0;
        for (int i = 1; i < 10; i++) {
            try {
                WebElement wb = driver.findElement(By.xpath("//tbody/tr[" + i + "]"));
                count++;
            } catch (Exception ex) {
                return count;
            }
        }
        return count;
    }

    /**
     * Цикл для перебора строк в таблице.
     * Не смог использовать для тестирования в аннотации @test
     *
     * @author Fazlyakhmetov_Dinar
     */

    public static boolean checkAddResult() {
        String wb;
        for (int i = 1; i < 10; i++) {
            try {
                wb = driver.findElement(By.xpath("//tbody/tr[" + i + "]")).getText();
                if (wb.equals("5 Груша Фрукт false")) {
                    return true;
                }
            } catch (Exception ex) {
                return false;
            }
        }
        return false;
    }

}

