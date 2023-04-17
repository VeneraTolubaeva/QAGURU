package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class CalendarComponent {
    String dayPickerLocator = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";
    private SelenideElement
        yearElement = $(".react-datepicker__year-select"),
        monthElement = $(".react-datepicker__month-select");
    public void setDate(String day, String month, String year) {
        monthElement.selectOption(month);
        yearElement.selectOption(year);
        $(format(dayPickerLocator, day)).click();
    }
}
