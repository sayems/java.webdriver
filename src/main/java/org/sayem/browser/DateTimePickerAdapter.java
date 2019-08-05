package org.sayem.browser;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateTimePickerAdapter implements DateTimePicker {

    @Override
    public String addWeekday() {
        LocalDate result = LocalDate.now();
        int addedDays = 0;
        while (addedDays < 1) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
    }

    @Override
    public String addWeekday(int day) {
        LocalDate result = LocalDate.now();
        int addedDays = 0;
        while (addedDays < day) {
            result = result.plusDays(1);
            if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY ||
                    result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
                ++addedDays;
            }
        }
        return result.format(DateTimeFormatter.ofPattern("dd MMMM yyyy"));
    }
}
