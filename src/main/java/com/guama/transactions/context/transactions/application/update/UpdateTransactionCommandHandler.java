package com.guama.transactions.context.transactions.application.update;

import com.guama.transactions.context.shared.ICommandHandler;
import com.guama.transactions.context.transactions.domain.Transaction;
import com.guama.transactions.context.transactions.domain.update.IUpdateTransaction;
import com.guama.transactions.context.transactions.domain.update.UpdateTransactionCommand;

/**
 * Update transaction command handler
 */
public class UpdateTransactionCommandHandler implements ICommandHandler<Transaction, UpdateTransactionCommand> {

  private final IUpdateTransaction updateTransaction;

  /**
   * Constructor
   *
   * @param updateTransaction The update transaction implementation
   */
  public UpdateTransactionCommandHandler(IUpdateTransaction updateTransaction) {
    this.updateTransaction = updateTransaction;
  }

  @Override
  public Transaction handle(UpdateTransactionCommand updateTransactionCommand) {
    return updateTransaction.execute(updateTransactionCommand);
  }
}
