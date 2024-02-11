package com.guama.transactions.context.transactions.shared.exceptions;

import com.guama.transactions.context.shared.exceptions.GuamaTransactionException;

import java.time.LocalDateTime;

/**
 * Transaction not found exception
 */
public class TransactionNotFound extends GuamaTransactionException {
  private static final long serialVersionUID = 4485367173588247306L;

  /**
   * Constructor
   *
   * @param id The transaction id
   */
  public TransactionNotFound(Long id) {
    super("TransactionNotFound", String.format("The transaction with id <%d> was not found", id), "GUAMA-TS-009", LocalDateTime.now().toString());
  }
}
