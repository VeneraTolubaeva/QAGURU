package homeWork;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @Test
    void successfulPracticeFormTest(){
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Venera");
        $("#lastName").setValue("Tolubaeva");
        $("#userEmail").setValue("aaa@qa.com");
        $("#userNumber").setValue("9999214455");
        $("input#dateOfBirthInput").clear();
        $("#dateOfBirthInput").sendKeys("29 Mar 2023");
        $("#subjectsContainer").setValue("HomeWork 1");
        $("#gender-radio-2").click();
        $("#hobbies-checkbox-1").click();
        $("#hobbies-checkbox-2").click();
        $("#hobbies-checkbox-1").click();
        $("#currentAddress").setValue("Some street 1");
    }

}
