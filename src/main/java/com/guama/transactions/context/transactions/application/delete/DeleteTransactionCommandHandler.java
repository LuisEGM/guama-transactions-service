package com.guama.transactions.context.transactions.application.delete;

import com.guama.transactions.context.shared.ICommandHandler;
import com.guama.transactions.context.transactions.domain.delete.DeleteTransactionCommand;
import com.guama.transactions.context.transactions.domain.delete.IDeleteTransaction;

/**
 * Delete transaction command handler
 */
public class DeleteTransactionCommandHandler implements ICommandHandler<Void, DeleteTransactionCommand> {

  private final IDeleteTransaction deleteTransaction;

  /**
   * Constructor
   *
   * @param deleteTransaction The delete transaction
   */
  public DeleteTransactionCommandHandler(IDeleteTransaction deleteTransaction) {
    this.deleteTransaction = deleteTransaction;
  }

  @Override
  public Void handle(DeleteTransactionCommand deleteTransactionCommand) {
    return deleteTransaction.execute(deleteTransactionCommand);
  }
}
