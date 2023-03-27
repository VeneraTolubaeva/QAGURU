import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FirstTest {
    @Test
    void shouldOpen() {
        String date = "25.03.2023";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);

       Assertions.assertEquals(DayOfWeek.SATURDAY, localDate.getDayOfWeek());
    }
}
