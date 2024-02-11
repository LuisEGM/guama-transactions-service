package com.guama.transactions.context.transactions.shared.exceptions;

import com.guama.transactions.context.shared.exceptions.GuamaTransactionException;

import java.time.LocalDateTime;

/**
 * Transaction amount can not be null or less than zero exception
 */
public class TransactionAmountCanNotBeNullOrLessThanZeroException extends GuamaTransactionException {
  private static final long serialVersionUID = 105651019189776132L;

  /**
   * Constructor
   */
  public TransactionAmountCanNotBeNullOrLessThanZeroException() {
    super("TransactionAmountCanNotBeNullOrLessThanZeroException", "The transaction amount can't be null or less than zero", "GUAMA-TS-007", LocalDateTime.now().toString());
  }
}
