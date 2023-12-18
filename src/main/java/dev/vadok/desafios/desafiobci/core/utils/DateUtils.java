package dev.vadok.desafios.desafiobci.core.utils;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

public class DateUtils {
  public static String toIsoLocalDate(Timestamp timestamp) {
    return timestamp
        .toLocalDateTime().format(DateTimeFormatter.ISO_DATE_TIME);
  }
}
