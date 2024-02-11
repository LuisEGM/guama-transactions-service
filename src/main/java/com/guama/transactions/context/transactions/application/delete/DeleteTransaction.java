package com.guama.transactions.context.transactions.application.delete;

import com.guama.transactions.context.transactions.domain.ITransactionService;
import com.guama.transactions.context.transactions.domain.delete.DeleteTransactionCommand;
import com.guama.transactions.context.transactions.domain.delete.IDeleteTransaction;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionNotFound;

/**
 * Delete transaction use case
 */
public class DeleteTransaction implements IDeleteTransaction {

  private final ITransactionService transactionService;

  /**
   * Constructor
   *
   * @param transactionService The transaction service
   */
  public DeleteTransaction(ITransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @Override
  public Void execute(DeleteTransactionCommand deleteTransactionCommand) {
    var transactionId = deleteTransactionCommand.getId();

    var existsTransaction = transactionService.existsTransaction(transactionId);
    if (!existsTransaction) {
      throw new TransactionNotFound(transactionId);
    }

    transactionService.deleteTransaction(deleteTransactionCommand.getId());
    return null;
  }
}
