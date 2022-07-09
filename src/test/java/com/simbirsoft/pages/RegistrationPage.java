package com.simbirsoft.pages;

import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.pages.components.CalendarComponent;
import com.simbirsoft.pages.components.DropdownComponent;
import com.simbirsoft.pages.components.ModalWindowComponent;
import com.simbirsoft.pages.components.SubjectInputComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    public static String userPicClasspath = "img/7dBulQtN5gc.jpg";
    private SelenideElement formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("input#firstName"),
            lastNameInput = $("input#lastName"),
            emailInput = $("input#userEmail"),
            phoneInput = $("input#userNumber"),
            userPicUpload = $("input#uploadPicture"),
            selectorMaleGender = $("input#gender-radio-1").parent(),
            selectorFemaleGender = $("input#gender-radio-2").parent(),
            selectorOtherGender = $("input#gender-radio-3").parent(),
            checkboxHobby = $("#hobbiesWrapper"),
            userAddressInput = $("textarea#currentAddress"),
            submitButton = $("button#submit");

    private final String FORM_TITLE = "Student Registration Form";

    public CalendarComponent calendarComponent = new CalendarComponent();
    public SubjectInputComponent subjectInputComponent = new SubjectInputComponent();
    public DropdownComponent dropdownComponent = new DropdownComponent();
    public ModalWindowComponent modalWindowComponent = new ModalWindowComponent();

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        return this;
    }

    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage typeEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationPage typePhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    public RegistrationPage uploadUserPic() {
        userPicUpload.uploadFromClasspath(userPicClasspath);
        return this;
    }

    public RegistrationPage selectMaleGender() {
        selectorMaleGender.click();
        return this;
    }

    public RegistrationPage selectFemaleGender() {
        selectorFemaleGender.click();
        return this;
    }

    public RegistrationPage selectOtherGender() {
        selectorOtherGender.click();
        return this;
    }

    public RegistrationPage clickHobby(String hobby) {
        checkboxHobby.$(byText(hobby)).click();
        return this;
    }

    public RegistrationPage typeAddress(String address) {
        userAddressInput.setValue(address);
        return this;
    }

    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }
}