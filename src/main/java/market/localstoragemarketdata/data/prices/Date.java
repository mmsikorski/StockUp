package market.localstoragemarketdata.data.prices;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.TemporalAccessor;
import java.util.Objects;

@Data
@Slf4j
public class Date {

    String date;
    LocalDate localDate;

    public void setDate(String date, Boolean transform) {
        try {
        this.date = date;
        if (transform) {
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.localDate = LocalDate.parse(date, dateTimeFormatter);
            }
        } catch (DateTimeParseException e) {
            log.info(e.getMessage());
        }
    }
}
