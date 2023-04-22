package com.demoqa.utils;

import com.demoqa.pages.components.enums.GendersEnum;
import com.demoqa.pages.components.enums.HobbiesEnum;
import com.demoqa.pages.components.enums.SubjectsEnum;
import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private static Faker faker = new Faker();
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
    static String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    static String[] cityForNCR = {"Delhi", "Gurgaon", "Noida"};
    static String[] cityForUttarPradesh = {"Agra", "Lucknow", "Merrut"};
    static String[] cityForHaryana = {"Karnal", "Panipat"};
    static String[] cityForRajasthan = {"Jaipur", "Jaiselmer"};

    public static void main(String[] args) {
        System.out.println(getRandomUuid());
        System.out.println(getRandomString(10));
        System.out.println(getRandomEmail());
        System.out.println(getRandomInt(11111111, 99999999));
    }
    public static String getRandomUuid() {
        String uuid = UUID.randomUUID().toString();
        return "uuid = " + uuid;
    }
    public static String getRandomString(int len){
        //String AB = "0123456789ABCDFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();

        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
            return sb.toString();
    }
    public static String getRandomEmail(){
        return getRandomString(5) + "@qa.com";
    }
    public static int getRandomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max+1);
    }
// getRandomItemFromArray можно было не писать, т.к. в фэйкере есть faker.options().option()
//    public static String getRandomItemFromArray(String[] values){
//        int index = getRandomInt(0, values.length-1);
//        return values[index];
//    }
    public static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        int index = getRandomInt(0,enumClass.getEnumConstants().length - 1);
        return enumClass.getEnumConstants()[index];
    }
    public static String getRandomGender(){
        return getRandomEnum(GendersEnum.class).getGenders();
    }
    public static String getRandomDay() {
        int day = getRandomInt(1, 30);
        if (day < 10) {
            return "0" + Integer.toString(day);
        } else {
            return Integer.toString(day);
        }
    }
    public static String getRandomMonths() {
        return faker.options().option(months);
    }
    public static String getRandomSubjects(){
        return getRandomEnum(SubjectsEnum.class).getSubjects();
    }
    public static String getRandomHobbies(){
        return getRandomEnum(HobbiesEnum.class).getHobbies();
    }
    public static String getRandomState(){
        return faker.options().option(state);
    }
    public static String getRandomCity(String state){
        String city;
        if (state == "NCR") {
            city = faker.options().option(cityForNCR);
            return city;
        } else if (state == "Uttar Pradesh") {
            city = faker.options().option(cityForUttarPradesh);
            return city;
        } else if (state == "Haryana") {
            city = faker.options().option(cityForHaryana);
            return city;
        } else if (state == "Rajasthan"){
            city = faker.options().option(cityForRajasthan);
            return city;
        }
        return null;
    }
}
