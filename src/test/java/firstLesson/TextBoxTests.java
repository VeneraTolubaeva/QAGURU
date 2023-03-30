package firstLesson;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests extends TestBase {
    @Test
    void successfulFillFormTest() {

        open("/text-box");
        //$("id=userName").setValue("");
        $("#userName").setValue("Venera");
        $("#userEmail").setValue("aaa@qa.com");
        $("#currentAddress").setValue("Some street 1");
        $("#permanentAddress").setValue("Another street 1");
        $("#submit").click();

        $("#output").shouldHave(text("Venera"), text("aaa@qa.com"),
                text("Some street 1"), text("Another street 1"));

    }
}
