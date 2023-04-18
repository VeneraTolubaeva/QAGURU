package com.demoqa.utils;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    static String[] genders = {"Male", "Female", "Other"};
    static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
            "October", "November", "December"};
    static String[] subjects = {"Maths", "Accounting", "Arts", "Chemistry", "Physics", "History", "Economics",
            "Social Studies", "Civics", "Hindi", "English", "Biology", "Computer Science"};
    static String[] hobbies = {"Sports", "Reading", "Music"};
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
        System.out.println(getRandomItemFromArray(genders));
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
    public static String getRandomPhone(){
        return "+7 (9" + getRandomInt(11,99) + ")" + getRandomInt(111,999) + "-" + getRandomInt(1111,9999);
    }
    public static Long getRandomLong(){
        return null;
    }
    public static String getRandomItemFromArray(String[] values){
        int index = getRandomInt(0, values.length-1);
        return values[index];
    }
    public static String getRandomGender(){
        return getRandomItemFromArray(genders);
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
        return getRandomItemFromArray(months);
    }
    public static String getRandomSubjects(){
        return getRandomItemFromArray(subjects);
    }
    public static String getRandomHobbies(){
        return getRandomItemFromArray(hobbies);
    }
    public static String getRandomState(){
        return getRandomItemFromArray(state);
    }
    public static String getRandomCity(String state){
        String city;
        switch (state) {
            case "NCR": {
                city = getRandomItemFromArray(cityForNCR);
                return city;
            }
            case "Uttar Pradesh": {
                city = getRandomItemFromArray(cityForUttarPradesh);
                return city;
            }
            case "Haryana": {
                city = getRandomItemFromArray(cityForHaryana);
                return city;
            }
            case "Rajasthan": {
                city = getRandomItemFromArray(cityForRajasthan);
                return city;
            }
        }
        return null;
    }
}
