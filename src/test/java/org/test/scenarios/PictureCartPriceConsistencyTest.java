package org.test.scenarios;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import org.example.entity.Picture;
import org.example.pages.BasketPage;
import org.example.pages.HomePage;
import org.example.pages.PicturePage;
import org.test.config.BaseTest;
import org.testng.annotations.Test;


import java.io.ByteArrayInputStream;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PictureCartPriceConsistencyTest extends BaseTest {

    /* Тест 5
     * Перейти в “Ювелирное искусство”, добавить первое изделие в корзину,
     * проверить, что выбранный товар находится в корзине, стоимость товара не изменилась.
     * */
    @Test(testName = "Добавление первого изделия в корзину в разделе 'Ювелирное искусство'")
    public void verifyAddingFirstJewelryItemToCartAndPriceConsistency() {

        HomePage home = new HomePage(getDriver());
        PicturePage picture = new PicturePage(getDriver());
        BasketPage basket = new BasketPage(getDriver());

        home.clickShowMoreOnCategory();
        home.clickMenuItem("Ювелирное искусство");
        Picture firstPicture = picture.putInBasketSpecificPicture(0);

        basket.openBasketFromModalPage();
        boolean isExistAndEqualPrice = basket.checkPictureInBasket(firstPicture);

        assertTrue(isExistAndEqualPrice);
    }

    /* Тест 6
     * Перейти в “Ювелирное искусство”, добавить первое изделие в корзину,
     * проверить, что выбранный товар находится в корзине, стоимость товара не изменилась.
     * */
    @Test(testName = "Неудачное добавление первого изделия в корзину в разделе 'Ювелирное искусство'")
    @Description("Результат искусственно был сделан ошибочным")
    @Attachment(value = "Failure screenshot", type = "image/png")
    public void verifyAddingFirstJewelryItemToCartAndPriceConsistencyBadResult() {

        HomePage home = new HomePage(getDriver());
        PicturePage picture = new PicturePage(getDriver());
        BasketPage basket = new BasketPage(getDriver());

        home.clickShowMoreOnCategory();
        home.clickMenuItem("Ювелирное искусство");
        Picture firstPicture = picture.putInBasketSpecificPicture(0);

        basket.openBasketFromModalPage();
        boolean isExistAndEqualPrice = basket.checkPictureInBasket(firstPicture);

        try {
            assertFalse(isExistAndEqualPrice);
        } catch (AssertionError e) {
            byte[] bytes = captureScreenshot(getDriver());
            Allure.addAttachment("Failure screen", new ByteArrayInputStream(bytes));
            Allure.addAttachment("Failure details", "Тест завершился неудачей: " + e.getMessage());
            throw e;
        }
    }
}