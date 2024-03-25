package org.example.pages;

import io.qameta.allure.Step;
import org.example.config.AllureListener;
import org.example.entity.Picture;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Listeners;


import java.util.List;

import static org.example.util.PictureHelper.getPictureName;
import static org.example.util.PictureHelper.getPicturePrice;


@Listeners(AllureListener.class)
public class BasketPage extends BasePage {

    @FindBy(css = "img[alt='Избранное']")
    private WebElement basketButton;

    @FindBy(css = "button[onclick='sendCartForm();']")
    private WebElement basketModalButton;

    @FindBy(css = "div[class='c_row']")
    private List<WebElement> basketPictures;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open the basket from the modal page")
    public void openBasketFromModalPage() {
        waitForElementEnable(basketModalButton);
        basketModalButton.click();
    }

    @Step("Check that the picture {picture.getName()} is in the basket with the price {picture.getPrice()}")
    public boolean checkPictureInBasket(Picture picture) {
        waitForAllElementsTimeoutSeconds(basketPictures);

        String name = picture.name();

        if (!basketPictures.isEmpty()) {
            for (var pic : basketPictures) {

                String pictureName = getPictureName(pic, "c_name");

                if (pic.getText().contains(name) || name.contains(pictureName)) {
                    long picPrice = getPicturePrice(pic);
                    if (picPrice == picture.price()) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}