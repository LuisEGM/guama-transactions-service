package com.guama.transactions.context.transactions.domain.update;

import com.guama.transactions.context.transactions.domain.Transaction;

/**
 * Update transaction
 */
public interface IUpdateTransaction {

  /**
   * Execute method
   *
   * @param updateTransactionCommand The update transaction command
   * @return a transaction
   */
  Transaction execute(UpdateTransactionCommand updateTransactionCommand);
}
