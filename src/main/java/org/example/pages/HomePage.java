package org.example.pages;

import io.qameta.allure.Param;
import io.qameta.allure.Step;
import org.example.config.AllureListener;
import org.example.util.ElementFinder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;


import java.util.List;

@Listeners(AllureListener.class)
public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@id='left_container']//li[@class='menu-group gids']")
    private WebElement showMoreOnCategoryButton;

    @FindBy(xpath = "//*[@id='left_container']/div/ul[2]//li")
    private WebElement menuItemElement;

    @FindBy(css = "input[name='qs']")
    private WebElement searchField;

    @FindBy(css = "button[class^='control']")
    private WebElement searchButton;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Click on 'Show More' button in the category")
    public void clickShowMoreOnCategory() {
        waitForElementEnable(showMoreOnCategoryButton);
        showMoreOnCategoryButton.click();
    }

    @Step("Enter text '{request}' in the search field and perform the search")
    public void enteringTextInSearchField(@Param("request") String request) {
        waitForAllElementsTimeoutSeconds(List.of(searchField, searchButton));
        searchField.sendKeys(request);
        searchButton.click();
    }

    @Step("Click on the menu item: {menuItemName}")
    public void clickMenuItem(String menuItemName) {
        WebElement menuItem = ElementFinder.findByLink(menuItemElement, menuItemName);
        waitForElementEnable(menuItem);
        menuItem.click();
    }
}