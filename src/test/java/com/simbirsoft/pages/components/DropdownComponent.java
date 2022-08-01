package com.simbirsoft.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class DropdownComponent {

    @Step("Выбрать географическую сущность {geographicName}")
    public DropdownComponent selectElementFromDropdown(String geoElement, String geographicName) {
        String selector = "div#%s";
        String formattedSelector = String.format(selector, geoElement);
        $(formattedSelector).click();
        $("div#stateCity-wrapper").$(byText(geographicName)).scrollIntoView(true).click();
        return this;
    }
}