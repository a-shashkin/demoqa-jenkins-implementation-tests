package com.simbirsoft.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    @Step("Выбрать день {day}, месяц {month} и год рождения {year}")
    public CalendarComponent setDate(String day, String month, String year) {
        $("input#dateOfBirthInput").click();
        $("select.react-datepicker__month-select").selectOption(month);
        $("select.react-datepicker__year-select").selectOption(year);

        String selector1 = "div.react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";
        String formattedSelector = String.format(selector1, day);
        $(formattedSelector).click();
        return this;
    }
}