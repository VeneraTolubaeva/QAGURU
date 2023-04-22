package com.demoqa.tests;

import org.junit.jupiter.api.Test;

import static com.demoqa.testData.TextBoxPageValue.*;

public class TextBoxTestsWithTestData extends TextBoxBase {
    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .setUserName(userName)
                .setUserEmail(userEmail)
                .setCurrentAddress(currentAddressTextBox)
                .setPermanentAddress(permanentAddress)
                .setSubmit();

        textBoxPage.verifyNameOutput( userName)
                .verifyEmailOutput(userEmail)
                .verifyCurrentAddressOutput(currentAddressTextBox)
                .verifyPermanentAddressOutput(permanentAddress);
    }
}
