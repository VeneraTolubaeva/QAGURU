package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.helpers.Attach;
import com.demoqa.pages.RegistrationPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

public class RemotePracticeFormConfig {
    RegistrationPage registrationPage = new RegistrationPage();
    private static String baseURL = System.getProperty("baseUrl", "https://demoqa.com");
    private static String remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
    private static String browser = System.getProperty("browser", "chrome");
    private static String browserSize = System.getProperty("browserSize", "1920x1080");
    private static String browserVersion = System.getProperty("browserVersion", "100.0");
    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        Configuration.baseUrl = baseURL;
        Configuration.remote = remote;
        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
        Configuration.browserVersion = browserVersion;
        Configuration.browserPosition = "0x0";
        Configuration.pageLoadStrategy = "eager";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }
    @BeforeEach
    void addListener(){
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void addAttachments(){
        Attach.screenshotAs("My Screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}
