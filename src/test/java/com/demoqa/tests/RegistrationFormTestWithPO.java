package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class RegistrationFormTestWithPO extends PracticeFormConfig {
    @Test
    void successfulPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName("Venera")
                .setLastName("Tol")
                .setUserEmail("aaa@qa.com")
                .setGenderWrapper("Female")
                .setUserNumber("9999999999")
                .setBirthDate("30", "10", "1987")
                .setSubjectsInput("Math")
                .setHobbies("Sports")
                .setHobbies("Reading")
                .setUploadPicture("practiceFormPicture.jpg")
                .setCurrentAddress("Some street 1")
                .setState("Haryana")
                .setCity("Karnal")
                .setSubmit();

        registrationPage.verifyRegistrationResultModalAppears()
                .verifyResult("Student Name", "Venera Tol")
                .verifyResult("Student Email", "aaa@qa.com")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "9999999999")
                .verifyResult("Date of Birth", "30 November,1987")
                .verifyResult("Subjects", "Maths")
                .verifyResult("Hobbies", "Sports, Reading")
                .verifyResult("Picture", "practiceFormPicture.jpg")
                .verifyResult("Address", "Some street 1")
                .verifyResult("State and City", "Haryana Karnal");

       registrationPage.setCloseModal();
    }

}
