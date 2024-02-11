package com.guama.transactions.context.transactions.shared;

import com.guama.transactions.context.shared.DateTimeValueObject;

import java.time.LocalDateTime;

/**
 * The date time value object
 */
public class TransactionDateTime extends DateTimeValueObject {
  private static final long serialVersionUID = -2977087315991511771L;

  /**
   * Constructor 1
   *
   * @param dateTime The date time
   */
  public TransactionDateTime(String dateTime) {
    super(dateTime);
  }

  /**
   * Constructor 2
   *
   * @param dateTime The date time
   */
  public TransactionDateTime(LocalDateTime dateTime) {
    super(dateTime);
  }
}
