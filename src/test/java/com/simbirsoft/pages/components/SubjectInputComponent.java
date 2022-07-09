package com.simbirsoft.pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectInputComponent {

    public SubjectInputComponent selectSubject(String subject) {
        $("input#subjectsInput").setValue(subject).pressEnter();
        return this;
    }
}