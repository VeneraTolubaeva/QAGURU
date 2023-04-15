package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    SelenideElement userNameInput = $("#userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit"),
            emailOutput = $("#email"),
            nameOutput = $("#name"),
            currentAddressOutput = $("#currentAddress.mb-1"),
            permanentAddressOutput = $("#permanentAddress.mb-1");

    public TextBoxPage openPage () {
        open("/text-box");
        return this;
    }
    public TextBoxPage setUserName (String value) {
        userNameInput.setValue(value);
        return this;
    }
    public TextBoxPage setUserEmail (String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public TextBoxPage setCurrentAddress (String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage setPermanentAddress (String value) {
        permanentAddressInput.setValue(value);
        return this;
    }
    public TextBoxPage setSubmit () {
        submitInput.click();
        return this;
    }
    public TextBoxPage verifyNameOutput (String value) {
        nameOutput.shouldHave(text(value));
        return this;
    }
    public TextBoxPage verifyEmailOutput (String value) {
        emailOutput.shouldHave(text(value));
        return this;
    }public TextBoxPage verifyCurrentAddressOutput (String value) {
        currentAddressOutput.shouldHave(text(value));
        return this;
    }public TextBoxPage verifyPermanentAddressOutput (String value) {
        permanentAddressOutput.shouldHave(text(value));
        return this;
    }

}
