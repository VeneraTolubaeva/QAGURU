package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.demoqa.pages.RegistrationPage.*;
import static com.demoqa.testData.RegistrationPageValue.*;
import static io.qameta.allure.Allure.attachment;

public class RemotePracticeFormTest extends RemotePracticeFormConfig {
    @Test
    @Tag("remote")
    void remotePracticeFormTest() {

        registrationPage.openPage()
                .closeBanner()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGenderWrapper(genderValue)
                .setUserNumber(phoneNumber)
                .setBirthDate(dayValue, monthsValue, yearValue)
                .setSubjectsInput(subjectValue)
                .setHobbies(hobbiesValue)
                .setUploadPicture(uploadPicture)
                .setCurrentAddress(currentAddress)
                .setState(stateValue)
                .setCity(cityValue)
                .setSubmit();

        registrationPage.verifyRegistrationResultModalAppears()
                .verifyResult(studentNameField, (firstName+ " " + lastName))
                .verifyResult(studentEmailField, userEmail)
                .verifyResult(genderField, genderValue)
                .verifyResult(mobileField, phoneNumber)
                .verifyResult(dateBirthField, dayValue+ " " + monthsValue + "," + yearValue)
                .verifyResult(subjectsField, subjectValue)
                .verifyResult(hobbiesField, hobbiesValue)
                .verifyResult(pictureField, uploadPicture)
                .verifyResult(addressField, currentAddress)
                .verifyResult(stateCityField, (stateValue + " " + cityValue));

        registrationPage.setCloseModal();
    }
}