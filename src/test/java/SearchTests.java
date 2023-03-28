import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void successfulSearchTests() {
        open("https://www.google.com/");
        //$("[name=q]").setValue()
    }
}
