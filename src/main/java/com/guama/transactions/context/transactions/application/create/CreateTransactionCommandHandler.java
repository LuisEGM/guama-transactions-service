package com.guama.transactions.context.transactions.application.create;

import com.guama.transactions.context.shared.ICommandHandler;
import com.guama.transactions.context.transactions.domain.Transaction;
import com.guama.transactions.context.transactions.domain.create.CreateTransactionCommand;
import com.guama.transactions.context.transactions.domain.create.ICreateTransaction;

/**
 * Create transaction command handler
 */
public class CreateTransactionCommandHandler implements ICommandHandler<Transaction, CreateTransactionCommand> {

  private final ICreateTransaction createTransaction;

  /**
   * Constructor
   *
   * @param createTransaction The create transaction implementation
   */
  public CreateTransactionCommandHandler(ICreateTransaction createTransaction) {
    this.createTransaction = createTransaction;
  }

  @Override
  public Transaction handle(CreateTransactionCommand createTransactionCommand) {
    return createTransaction.execute(createTransactionCommand);
  }
}
