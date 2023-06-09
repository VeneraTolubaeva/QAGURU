package com.demoqa.pages.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModalComponent {
    public void verifyModalAppears() {
        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }

    public void verifyResult(String key, String value) {
        $(".table-responsive").$(byText(key)).sibling(0).shouldHave(text(value));
        //$(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        //$(".table-responsive").$(byText(key)).parent().$("td", 1).shouldHave(text(value));
        //Можно использовать любой из 3х вариантов, они все делают одно и тоже
    }
    public void closeModal() {
        $("#closeLargeModal").click();
    }


}
