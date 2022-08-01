package com.simbirsoft.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.simbirsoft.pages.components.CalendarComponent;
import com.simbirsoft.pages.components.DropdownComponent;
import com.simbirsoft.pages.components.ModalWindowComponent;
import com.simbirsoft.pages.components.SubjectInputComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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

    @Step("Открыть страницу с формой регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
        if ($("#adplus-anchor").isDisplayed()) {
            $("#cbb").click();
            $("#report_btn").click();
            $("#report_btn").click();
            $(byText("Ad covered content")).parent().click();
            $("#close-fixedban").click();
        }
        return this;
    }

    @Step("Напечатать имя {firstName}")
    public RegistrationPage typeFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Напечатать фамилию {lastName}")
    public RegistrationPage typeLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    @Step("Напечатать email {email}")
    public RegistrationPage typeEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Напечатать телефон {phone}")
    public RegistrationPage typePhone(String phone) {
        phoneInput.setValue(phone);
        return this;
    }

    @Step("Загрузить аватар")
    public RegistrationPage uploadUserPic() {
        userPicUpload.uploadFromClasspath(userPicClasspath);
        return this;
    }

    @Step("Выбрать мужской пол")
    public RegistrationPage selectMaleGender() {
        selectorMaleGender.click();
        return this;
    }

    @Step("Выбрать женский пол")
    public RegistrationPage selectFemaleGender() {
        selectorFemaleGender.click();
        return this;
    }

    @Step("Выбрать другой пол")
    public RegistrationPage selectOtherGender() {
        selectorOtherGender.click();
        return this;
    }

    @Step("Выбрать хобби {hobby}")
    public RegistrationPage clickHobby(String hobby) {
        checkboxHobby.$(byText(hobby)).click();
        return this;
    }

    @Step("Напечатать адрес {address}")
    public RegistrationPage typeAddress(String address) {
        userAddressInput.setValue(address);
        return this;
    }

    @Step("Нажать кнопку Submit")
    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверить отображение элементов")
    public RegistrationPage checkPresenceOfElements() {
        formTitle.shouldBe(visible);
        firstNameInput.shouldBe(visible);
        lastNameInput.shouldBe(visible);
        emailInput.shouldBe(visible);
        phoneInput.shouldBe(visible);
        userPicUpload.shouldBe(visible);
        selectorMaleGender.shouldBe(visible);
        selectorFemaleGender.shouldBe(visible);
        selectorOtherGender.shouldBe(visible);
        checkboxHobby.shouldBe(visible);
        userAddressInput.shouldBe(visible);
        submitButton.shouldBe(visible);
        return this;
    }
}