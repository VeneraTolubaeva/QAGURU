package com.demoqa.tests;

import org.junit.jupiter.api.Test;

public class TextBoxTestsWithPO extends TextBoxBase {
    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .setUserName("Venera")
                .setUserEmail("aaa@qa.com")
                .setCurrentAddress("Some street 1")
                .setPermanentAddress("Another street 1")
                .setSubmit();

        textBoxPage.verifyNameOutput( "Venera")
                .verifyEmailOutput("aaa@qa.com")
                .verifyCurrentAddressOutput("Some street 1")
                .verifyPermanentAddressOutput("Another street 1");
    }
}
