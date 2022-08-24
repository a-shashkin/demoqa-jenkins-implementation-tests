package com.simbirsoft.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.simbirsoft.config.LaunchConfig;
import com.simbirsoft.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestBase {
    @BeforeAll
    static void beforeAll() {
        LaunchConfig launchConfig = ConfigFactory.create(LaunchConfig.class);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);

        String baseUrl = System.getProperty("baseUrl", "https://demoqa.com");

        Configuration.baseUrl = baseUrl;
        Configuration.browserCapabilities = capabilities;
        Configuration.browserSize = launchConfig.getSize();
        Configuration.browser = launchConfig.getBrowser();
        Configuration.browserVersion = launchConfig.getVersion();

        if (launchConfig.isRemote()) {
            String login = launchConfig.remoteLogin();
            String password = launchConfig.remotePassword();
            String browserURL = System.getProperty("url", launchConfig.getRemoteURL());
            Configuration.remote = format("https://%s:%s@%s", login, password, browserURL);
        }
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Последний скриншот");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}