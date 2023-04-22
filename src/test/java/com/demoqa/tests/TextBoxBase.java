package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.TextBoxPage;
import org.junit.jupiter.api.BeforeAll;

public class TextBoxBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1000";
        //Configuration.holdBrowserOpen = true;
        Configuration.pageLoadStrategy = "eager";
        //Configuration.browser = "chrome";
        //Configuration.timeout = 3000;
    }
}
