package org.example.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PictureHelper {
    public static String getPictureName(WebElement picture, String tagName) {
        return picture.findElement(By.className(tagName)).getText();
    }

    public static long getPicturePrice(WebElement picture) {
        return Long.parseLong(picture.findElement(By.className("price")).getText().split(" ")[0]);
    }
}