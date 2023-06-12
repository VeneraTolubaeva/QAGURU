package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.ResultsModalComponent;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.selenide.AllureSelenide;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModalComponent resultsModal = new ResultsModalComponent();
    SelenideElement formHeaderText = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumber = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureInput = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            submitButton = $("#submit");

    public static String
            studentNameField = "Student Name",
            studentEmailField = "Student Email",
            genderField = "Gender",
            mobileField = "Mobile",
            dateBirthField = "Date of Birth",
            subjectsField = "Subjects",
            hobbiesField = "Hobbies",
            pictureField = "Picture",
            addressField = "Address",
            stateCityField = "State and City";

    public RegistrationPage openPage() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("/automation-practice-form");
        formHeaderText.shouldHave(text("Student Registration Form"));
        return this;
    }
    public RegistrationPage closeBanner() {
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
    public RegistrationPage setGenderWrapper(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);
        return this;
    }
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }
    public RegistrationPage setSubjectsInput(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public RegistrationPage setHobbies (String value){
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setUploadPicture (String value){
        uploadPictureInput.uploadFromClasspath(value);
        return this;
    }
    public RegistrationPage setCurrentAddress (String value){
        currentAddressInput.setValue(value);
        return this;
    }
    public RegistrationPage setState (String value){
        stateInput.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setCity (String value){
        cityInput.click();
        $(byText(value)).click();
        return this;
    }
    public RegistrationPage setSubmit() {
        submitButton.click();
        return this;
    }

    public RegistrationPage verifyRegistrationResultModalAppears() {
        resultsModal.verifyModalAppears();
        return this;
    }
    public RegistrationPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);
        return this;

    }

    public RegistrationPage setCloseModal() {
        resultsModal.closeModal();
        return this;
    }
    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
