package com.demoqa.testData;

import com.github.javafaker.Faker;

import static com.demoqa.utils.RandomUtils.*;

public class RegistrationPageValue {
    private static Faker faker = new Faker();
    //Faker faker = new Faker(new Locale("fr"));
    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            genderValue = getRandomGender(),
            dayValue = getRandomDay(),
            monthsValue = getRandomMonths(),
            yearValue = String.valueOf(getRandomInt(1900,2100)),
            phoneNumber = ("89" + getRandomInt(11111111,99999999)),
            subjectValue = getRandomSubjects(),
            hobbiesValue = getRandomHobbies(),
            uploadPicture = "practiceFormPicture.jpg",
            currentAddress = faker.address().fullAddress(),
            stateValue = getRandomState(),
            cityValue = getRandomCity(stateValue);
}
