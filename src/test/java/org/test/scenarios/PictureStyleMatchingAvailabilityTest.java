package org.test.scenarios;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.CatalogPage;
import org.example.pages.HomePage;
import org.example.pages.PicturePage;
import org.test.config.BaseTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class PictureStyleMatchingAvailabilityTest extends BaseTest {

    /* Tест 1
     * Перейти в раздел "Вышитые картины", выполнить поиск по жанру "Городской пейзаж",
     * и проверить наличие картины "Трамвайный путь" в результатах поиска.
     * */
    @Test(testName = "Проверка наличия 'Трамвайного пути' на вышитых картинках в жанре 'Городской пейзаж'")
    public void VerifyPresenceOfCityscapePaintingInEmbroideredPictures() {

        HomePage home = new HomePage(getDriver());
        CatalogPage catalog = new CatalogPage(getDriver());
        PicturePage picture = new PicturePage(getDriver());

        home.clickShowMoreOnCategory();
        home.clickMenuItem("Вышитые картины");
        catalog.selectPictureGenre("Городской пейзаж");
        boolean isCatalogExists = picture.isPictureByNameExists("Трамвайный путь");

        assertTrue(isCatalogExists);
    }

    /* Тест 2
     * Перейти в “Вышитые картины”, произвести поиск по жанру «Городской пейзаж», открыть
     * подробности картины “Трамвайный путь”, проверить, что стиль картины «Реализм».
     * */
    @Test(testName = "Проверка стиля 'Реализм' у картины 'Трамвайный путь' в разделе 'Вышитые картины'")
    public void verifyPaintingStyleTramwayPath() {

        HomePage home = new HomePage(getDriver());
        CatalogPage catalog = new CatalogPage(getDriver());
        PicturePage picture = new PicturePage(getDriver());

        home.clickShowMoreOnCategory();
        home.clickMenuItem("Вышитые картины");
        catalog.selectPictureGenre("Городской пейзаж");

        boolean isCatalogExists = picture.isPictureByNameExists("Трамвайный путь");

        if (isCatalogExists) {
            picture.openPictureInfo("Трамвайный путь");
            boolean isRealism = picture.checkStylePicture("Реализм");

            assertTrue(isRealism);
        }
    }
}