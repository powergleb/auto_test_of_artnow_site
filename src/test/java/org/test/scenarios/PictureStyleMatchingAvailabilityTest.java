package org.test.scenarios;

import lombok.extern.slf4j.Slf4j;
import org.example.pages.CatalogPage;
import org.example.pages.HomePage;
import org.example.pages.PicturePage;
import org.test.config.BaseTest;
import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;

public class PictureStyleMatchingAvailabilityTest extends BaseTest {

    /* T��� 1
     * ������� � ������ "������� �������", ��������� ����� �� ����� "��������� ������",
     * � ��������� ������� ������� "���������� ����" � ����������� ������.
     * */
    @Test(testName = "�������� ������� '����������� ����' �� ������� ��������� � ����� '��������� ������'")
    public void VerifyPresenceOfCityscapePaintingInEmbroideredPictures() {

        HomePage home = new HomePage(getDriver());
        CatalogPage catalog = new CatalogPage(getDriver());
        PicturePage picture = new PicturePage(getDriver());

        home.clickShowMoreOnCategory();
        home.clickMenuItem("������� �������");
        catalog.selectPictureGenre("��������� ������");
        boolean isCatalogExists = picture.isPictureByNameExists("���������� ����");

        assertTrue(isCatalogExists);
    }

    /* ���� 2
     * ������� � �������� ��������, ���������� ����� �� ����� ���������� ������, �������
     * ����������� ������� ����������� �����, ���������, ��� ����� ������� ��������.
     * */
    @Test(testName = "�������� ����� '�������' � ������� '���������� ����' � ������� '������� �������'")
    public void verifyPaintingStyleTramwayPath() {

        HomePage home = new HomePage(getDriver());
        CatalogPage catalog = new CatalogPage(getDriver());
        PicturePage picture = new PicturePage(getDriver());

        home.clickShowMoreOnCategory();
        home.clickMenuItem("������� �������");
        catalog.selectPictureGenre("��������� ������");

        boolean isCatalogExists = picture.isPictureByNameExists("���������� ����");

        if (isCatalogExists) {
            picture.openPictureInfo("���������� ����");
            boolean isRealism = picture.checkStylePicture("�������");

            assertTrue(isRealism);
        }
    }
}