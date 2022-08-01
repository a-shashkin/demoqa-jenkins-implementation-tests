package com.simbirsoft.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class DropdownComponent {

    @Step("Выбрать географическую сущность {geographicName}")
    public DropdownComponent selectElementFromDropdown(String geoElement, String geographicName) {
        String selector = "div#%s";
        String formattedSelector = String.format(selector, geoElement);
        if ($("#adplus-anchor").isDisplayed()) {
            executeJavaScript(
                    "$('#adplus-anchor').hide();"
            );
        }
        $(formattedSelector).click();
        $("div#stateCity-wrapper").$(byText(geographicName)).scrollIntoView(true).click();
        return this;
    }
}