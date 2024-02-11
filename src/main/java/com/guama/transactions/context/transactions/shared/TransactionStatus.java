package com.guama.transactions.context.transactions.shared;

import com.guama.transactions.context.shared.StringValueObject;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionStatusCanNotBeNullOrEmptyAndShouldValidException;

/**
 * The transaction status value object
 */
public class TransactionStatus extends StringValueObject {
  private static final long serialVersionUID = -3731369270395767070L;

  /**
   * Constructor.
   *
   * @param value the value.
   */
  public TransactionStatus(String value) {
    super(value);
    if ((value == null || value.trim().isEmpty()) || (!value.equals(TransactionStates.PAID.name()) && !value.equals(TransactionStates.PENDING.name()) && !value.equals(TransactionStates.DECLINED.name()))) {
      throw new TransactionStatusCanNotBeNullOrEmptyAndShouldValidException();
    }
  }
}
