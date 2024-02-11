package com.guama.transactions.context.transactions.domain.create;

import com.guama.transactions.context.transactions.domain.Transaction;

/**
 * Create transaction
 */
public interface ICreateTransaction {

  /**
   * Execute method
   *
   * @param createTransactionCommand The create transaction command
   * @return a transaction
   */
  Transaction execute(CreateTransactionCommand createTransactionCommand);
}
