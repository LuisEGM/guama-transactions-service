package com.guama.transactions.context.transactions.shared;

import com.guama.transactions.context.shared.DoubleValueObject;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionAmountCanNotBeNullOrLessThanZeroException;

import java.util.Objects;

/**
 * The transaction amount value object
 */
public class TransactionAmount extends DoubleValueObject {
  private static final long serialVersionUID = -3311549091361459186L;

  /**
   * Constructor
   *
   * @param value The value
   */
  public TransactionAmount(Double value) {
    super(value);

    if (Objects.isNull(value) || value <= 0) {
      throw new TransactionAmountCanNotBeNullOrLessThanZeroException();
    }
  }
}
