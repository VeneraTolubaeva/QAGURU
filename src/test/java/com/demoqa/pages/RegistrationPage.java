package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.demoqa.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static java.lang.String.format;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#lastName"),
            gender = $("#genterWrapper"),
            phoneNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        formHeaderText.shouldHave(text("Student Registration Form"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
}
