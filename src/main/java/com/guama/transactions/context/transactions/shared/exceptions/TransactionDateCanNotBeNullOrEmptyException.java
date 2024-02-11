package com.guama.transactions.context.transactions.shared.exceptions;

import com.guama.transactions.context.shared.exceptions.GuamaTransactionException;

import java.time.LocalDateTime;

/**
 * Transaction name can not be null or empty exception
 */
public class TransactionDateCanNotBeNullOrEmptyException extends GuamaTransactionException {
  private static final long serialVersionUID = 5587698461159131744L;

  /**
   * Constructor
   */
  public TransactionDateCanNotBeNullOrEmptyException() {
    super("TransactionDateCanNotBeNullOrEmptyException", "The transaction date can not be null or empty exception", "GUAMA-TS-008", LocalDateTime.now().toString());
  }
}
