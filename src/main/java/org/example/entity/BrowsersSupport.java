package org.example.entity;

import lombok.Getter;

@Getter
public enum BrowsersSupport {
    FIREFOX("firefox"),
    CHROME("chrome");

    private final String browserName;

    BrowsersSupport(String browserName) {
        this.browserName = browserName;
    }
}