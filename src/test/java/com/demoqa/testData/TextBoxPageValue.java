package com.demoqa.testData;

import com.github.javafaker.Faker;

public class TextBoxPageValue {
    private static Faker faker = new Faker();
    public static String userName = faker.name().firstName(),
            userEmail = faker.internet().emailAddress(),
            currentAddressTextBox = faker.address().fullAddress(),
            permanentAddress = faker.address().fullAddress();
}
