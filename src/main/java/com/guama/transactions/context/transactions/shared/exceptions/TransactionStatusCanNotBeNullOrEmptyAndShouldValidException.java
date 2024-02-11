package com.guama.transactions.context.transactions.shared.exceptions;

import com.guama.transactions.context.shared.exceptions.GuamaTransactionException;

import java.time.LocalDateTime;

/**
 * Transaction status can not be null or empty and should valid exception
 */
public class TransactionStatusCanNotBeNullOrEmptyAndShouldValidException extends GuamaTransactionException {
  private static final long serialVersionUID = 105651019189776132L;

  /**
   * Constructor
   */
  public TransactionStatusCanNotBeNullOrEmptyAndShouldValidException() {
    super("TransactionStatusCanNotBeNullOrEmptyAndShouldValidException", "The transaction status cannot be null or empty and must be PAID, PENDING or DECLINED", "GUAMA-TS-006", LocalDateTime.now().toString());
  }
}
