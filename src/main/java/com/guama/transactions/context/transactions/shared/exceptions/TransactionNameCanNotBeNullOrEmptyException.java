package com.guama.transactions.context.transactions.shared.exceptions;

import com.guama.transactions.context.shared.exceptions.GuamaTransactionException;

import java.time.LocalDateTime;

/**
 * Transaction name can not be null or empty exception
 */
public class TransactionNameCanNotBeNullOrEmptyException extends GuamaTransactionException {
  private static final long serialVersionUID = 105651019189776132L;

  /**
   * Constructor
   */
  public TransactionNameCanNotBeNullOrEmptyException() {
    super("TransactionNameCanNotBeNullOrEmptyException", "The transaction name can not be null or empty exception", "GUAMA-TS-005", LocalDateTime.now().toString());
  }
}
