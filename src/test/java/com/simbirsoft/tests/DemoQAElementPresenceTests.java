package com.simbirsoft.tests;

import com.codeborne.selenide.Condition;
import com.simbirsoft.pages.RegistrationPage;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;

@Feature("Страница регистрации студента DemoQA")
@Owner("Alexander Shashkin")
public class DemoQAElementPresenceTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("open_only")
    @Story("Открытие страницы")
    @DisplayName("Проверка отображения элементов на странице (без заполнения)")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "Страница регистрации", url = "http://demoqa.com/automation-practice-form")
    void openPageAndCheckElements() {

        registrationPage.openPage()
                        .checkPresenceOfElements();
    }
}
