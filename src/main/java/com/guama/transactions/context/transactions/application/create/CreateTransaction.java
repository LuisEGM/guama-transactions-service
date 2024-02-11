package com.guama.transactions.context.transactions.application.create;

import com.guama.transactions.context.transactions.domain.ITransactionService;
import com.guama.transactions.context.transactions.domain.Transaction;
import com.guama.transactions.context.transactions.domain.create.CreateTransactionCommand;
import com.guama.transactions.context.transactions.domain.create.ICreateTransaction;
import com.guama.transactions.context.transactions.shared.TransactionAmount;
import com.guama.transactions.context.transactions.shared.TransactionDateTime;
import com.guama.transactions.context.transactions.shared.TransactionName;
import com.guama.transactions.context.transactions.shared.TransactionStatus;

/**
 * Create transaction use case
 */
public class CreateTransaction implements ICreateTransaction {

  private final ITransactionService transactionService;

  /**
   * Constructor
   *
   * @param transactionService The transaction service
   */
  public CreateTransaction(ITransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @Override
  public Transaction execute(CreateTransactionCommand createTransactionCommand) {
    var name = new TransactionName(createTransactionCommand.getName());
    var amount = new TransactionAmount(createTransactionCommand.getAmount());
    var status = new TransactionStatus(createTransactionCommand.getStatus());
    var date = new TransactionDateTime(createTransactionCommand.getDate());

    var transaction = Transaction.build(name.value(), amount.value(), status.value(), date.value());
    return Transaction.fromEntity(transactionService.createOrUpdateTransaction(transaction));
  }
}
