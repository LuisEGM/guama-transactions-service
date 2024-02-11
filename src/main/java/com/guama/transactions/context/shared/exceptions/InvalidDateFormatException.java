package com.guama.transactions.context.shared.exceptions;

import java.time.LocalDateTime;

/**
 * Invalid Date Format Exception
 */
public class InvalidDateFormatException extends GuamaTransactionException {
  private static final long serialVersionUID = -5525474640451498997L;

  /**
   * Constructor
   *
   * @param date   The date
   */
  public InvalidDateFormatException(String date) {
    super("InvalidDateFormatException", String.format("The date %s does not have the format ISO 8601", date), "GUAMA-TS-001", LocalDateTime.now().toString());
  }
}
