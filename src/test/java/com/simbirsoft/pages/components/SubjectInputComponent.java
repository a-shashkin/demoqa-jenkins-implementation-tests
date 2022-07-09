package com.simbirsoft.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class SubjectInputComponent {

    @Step("Выбрать предмет {subject}")
    public SubjectInputComponent selectSubject(String subject) {
        $("input#subjectsInput").setValue(subject).pressEnter();
        return this;
    }
}