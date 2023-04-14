package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTests extends PracticeFormConfig {
    @Test
    void successfulPracticeFormTest() {
        registrationPage.openPage()
                .setFirstName("Venera")
                .setLastName("Tolubaeva")
                .setUserEmail("aaa@qa.com")
                .setGender("Female")
                .setPhoneNumber("9999999999")
                .setBirthDate("30", "November", "1987");




        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbies-checkbox-1").parent().click();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("practiceFormPicture.jpg");
        $("#currentAddress").setValue("Some street 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Venera Tolubaeva"),
                text("aaa@qa.com"),
                text("Female"),
                text("9999999999"),
                text("30 November,1987"),
                text("Maths"),
                text("Sports, Reading"),
                text("practiceFormPicture.jpg"),
                text("Some street 1"),
                text("Haryana Karnal"));
        $("#closeLargeModal").click();
    }

}
