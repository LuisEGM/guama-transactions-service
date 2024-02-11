package com.guama.transactions.context.transactions.domain.delete;

/**
 * Delete transaction interface
 */
public interface IDeleteTransaction {

  /**
   * Execute
   *
   * @param deleteTransactionCommand The delete transaction command
   */
  Void execute(DeleteTransactionCommand deleteTransactionCommand);
}
