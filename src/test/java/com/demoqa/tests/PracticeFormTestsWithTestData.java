package com.demoqa.tests;

import org.junit.jupiter.api.Test;


import static com.demoqa.pages.RegistrationPage.*;
import static com.demoqa.testData.RegistrationPageValue.*;

public class PracticeFormTestsWithTestData extends PracticeFormConfig {

    @Test
    void successfulPracticeFormTest() {

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
