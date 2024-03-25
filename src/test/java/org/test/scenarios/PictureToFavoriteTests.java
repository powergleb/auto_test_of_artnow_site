package org.test.scenarios;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.FavoritePage;
import org.example.pages.HomePage;
import org.example.pages.PicturePage;
import org.test.config.BaseTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

@Slf4j
//@Listeners(AllureListener.class)
public class PictureToFavoriteTests extends BaseTest {

    /* ���� 3
     * ������� � ������, ����� �������� ������ ������� � ���������, ���������, ��� ��������� ������� ����������� � ������� ����������.
     * */
    @Test(testName = "�������� ���������� ������ ������� � ������� '�����' � ���������")
    public void verifyAddingFirstBatikPictureToFavorites() {
        log.info("Starting test: Verify adding the first '�����' picture to Favorites");

        HomePage home = new HomePage(getDriver());
        PicturePage picture = new PicturePage(getDriver());
        FavoritePage favoritePage = new FavoritePage(getDriver());

        home.clickShowMoreOnCategory();
        home.clickMenuItem("�����");

        String pictureName = picture.putInFavoriteSpecificPicture(0);

        favoritePage.openFavoriteListPage();
        boolean isExist = favoritePage.checkPictureInFavorite(pictureName);

        assertTrue(isExist);
    }
}