package com.guama.transactions.context.transactions.domain;

import com.guama.transactions.context.shared.exceptions.InvalidDateFormatException;
import com.guama.transactions.context.transactions.domain.find.FindTransactionsView;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Transaction filters
 */
@Getter
@EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TransactionFilters {
  private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
  private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

  private String name;
  private String status;
  private LocalDateTime fromDate;
  private LocalDateTime toDate;

  /**
   * Build method
   *
   * @param filterParameters The filter parameters
   * @return A TransactionFilters
   */
  public static TransactionFilters build(FindTransactionsView.FilterParameters filterParameters) {
    try {
      LocalDateTime fromDate = null;
      LocalDateTime toDate = null;

      if (!"".equals(filterParameters.getFromDate())) {
        fromDate = LocalDateTime.parse(filterParameters.getFromDate(), DATE_TIME_FORMATTER);
      }

      if (!"".equals(filterParameters.getToDate())) {
        toDate = LocalDateTime.parse(filterParameters.getToDate(), DATE_TIME_FORMATTER);
      }

      return new TransactionFilters(filterParameters.getName(), filterParameters.getStatus(), fromDate, toDate);
    } catch (DateTimeParseException ex) {
      throw new InvalidDateFormatException(String.format("%s or %s", filterParameters.getFromDate(), filterParameters.getFromDate()));
    }
  }
}
