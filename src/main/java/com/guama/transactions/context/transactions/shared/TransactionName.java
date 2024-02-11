package com.guama.transactions.context.transactions.shared;

import com.guama.transactions.context.shared.StringValueObject;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionNameCanNotBeNullOrEmptyException;

/**
 * The transaction name value object
 */
public class TransactionName extends StringValueObject {
  private static final long serialVersionUID = -3731369270395767070L;

  /**
   * Constructor.
   *
   * @param value the value.
   */
  public TransactionName(String value) {
    super(value);
    if (value == null || value.trim().isEmpty()) {
      throw new TransactionNameCanNotBeNullOrEmptyException();
    }
  }
}
