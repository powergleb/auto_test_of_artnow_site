package org.test.scenarios;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.HomePage;
import org.example.pages.PicturePage;
import org.test.config.BaseTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

//@Listeners(AllureListener.class)
public class PictureSearchResultsTest extends BaseTest {

    /* ���� 4
     * ������ � ��������� ������ �������, ���������, ��� �������� ������ ������� �������� ����� �������.
     * */
    @Test(testName = "����� �� ��������� ����� '�����'")
    public void verifyTitleOfFirstPaintingInSearchResultsForGiraffe() {

        HomePage home = new HomePage(getDriver());
        PicturePage picture = new PicturePage(getDriver());

        String request = "�����";

        home.enteringTextInSearchField(request);
        boolean isContains = picture.checkContainsRequestInName(request);

        assertTrue(isContains);
    }
}