package org.test.scenarios;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.CatalogPage;
import org.example.pages.HomePage;
import org.example.pages.PicturePage;
import org.test.config.BaseTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

@Slf4j
//@Listeners(AllureListener.class)
public class PictureStyleMatchingAvailabilityTest extends BaseTest {

    /* Tест 1
     * Перейти в раздел "Вышитые картины", выполнить поиск по жанру "Городской пейзаж",
     * и проверить наличие картины "Трамвайный путь" в результатах поиска.
     * */
    @Test(testName = "Проверка наличия 'Трамвайного пути' на вышитых картинках в жанре 'Городской пейзаж'")
    public void VerifyPresenceOfCityscapePaintingInEmbroideredPictures() {
        log.info("Starting test: Navigating to 'Вышитые картины', searching for 'Городской пейзаж' genre, and verifying the presence of 'Трамвайный путь'.");

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
        log.info("Starting test: Navigate to 'Вышитые картины', search for 'Городской пейзаж', " +
                "open details of painting 'Трамвайные пути', and verify its style - 'Реализм'.");

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