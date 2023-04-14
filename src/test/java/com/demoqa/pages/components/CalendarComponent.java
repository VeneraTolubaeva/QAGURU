package com.demoqa.pages.components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        String dayPickerLocator = format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);

        $(".react-datepicker__year-select").selectOptionByValue(year);
        $(".react-datepicker__month-select").selectOptionByValue(month);
        $(dayPickerLocator).click();
    }
}
