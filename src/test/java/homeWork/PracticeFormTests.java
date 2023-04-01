package homeWork;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Character.CONTROL;

public class PracticeFormTests extends PracticeFormConfig {

    @Test
    void successfulPracticeFormTest() {
        //��������� ���� demoqa.com
        open("https://demoqa.com/automation-practice-form");
        //�������� ������� � footer
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        //��������� ���� Name
        $("#firstName").setValue("Venera");
        $("#lastName").setValue("Tolubaeva");
        //��������� ���� email
        $("#userEmail").setValue("aaa@qa.com");
        //�������� Gender
        $("#gender-radio-2").parent().click();
        //��������� ���� Mobile
        $("#userNumber").setValue("9999999999");
        //�������� Date of Birth
        $("#dateOfBirthInput").pressEnter();
        $("#dateOfBirthInput").clear();
        $(".react-datepicker__year-select").selectOptionByValue("1987");
        $(".react-datepicker__month-select").selectOptionByValue("10");
        $(".react-datepicker__day--030").click();
//      ���� ����� ������� ���� �������, �� ��� ����� ���������������� �������
//        $("#dateOfBirthInput").sendKeys(CONTROL + "A");
//        $("#dateOfBirthInput").sendKeys("01 Mar 1990");
//        $("#dateOfBirthInput").pressEnter();
        //��������� ���� Subjects
        $("#subjectsInput").setValue("Math").pressEnter();
        //�������� Hobbies
        $("#hobbies-checkbox-1").parent().click();
        $(byText("Reading")).click();
        //��������� picture
        $("#uploadPicture").uploadFromClasspath("practiceFormPicture.jpg");
        //��������� Current address
        $("#currentAddress").setValue("Some street 1");
        //�������� State
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        //�������� City
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Venera Tolubaeva"),
                text("aaa@qa.com"),text("Female"),
                text("9999999999"),text("30 November,1987"),
                text("Maths"),text("Sports, Reading"),
                text("practiceFormPicture.jpg"),text("Some street 1"),
                text("Haryana Karnal"));
        $("#closeLargeModal").click();
    }

}
