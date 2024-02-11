package com.guama.transactions.context.transactions.application.update;

import com.guama.transactions.context.transactions.domain.ITransactionService;
import com.guama.transactions.context.transactions.domain.Transaction;
import com.guama.transactions.context.transactions.domain.update.IUpdateTransaction;
import com.guama.transactions.context.transactions.domain.update.UpdateTransactionCommand;
import com.guama.transactions.context.transactions.shared.TransactionAmount;
import com.guama.transactions.context.transactions.shared.TransactionDateTime;
import com.guama.transactions.context.transactions.shared.TransactionName;
import com.guama.transactions.context.transactions.shared.TransactionStatus;
import com.guama.transactions.context.transactions.shared.exceptions.TransactionNotFound;

/**
 * Update transaction use case
 */
public class UpdateTransaction implements IUpdateTransaction {

  private final ITransactionService transactionService;

  /**
   * Constructor
   *
   * @param transactionService The transaction service
   */
  public UpdateTransaction(ITransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @Override
  public Transaction execute(UpdateTransactionCommand updateTransactionCommand) {
    var name = new TransactionName(updateTransactionCommand.getName());
    var amount = new TransactionAmount(updateTransactionCommand.getAmount());
    var status = new TransactionStatus(updateTransactionCommand.getStatus());
    var date = new TransactionDateTime(updateTransactionCommand.getDate());

    var existsTransaction = transactionService.existsTransaction(updateTransactionCommand.getId());
    if (!existsTransaction) {
      throw new TransactionNotFound(updateTransactionCommand.getId());
    }

    var transaction = Transaction.load(updateTransactionCommand.getId(), name.value(), amount.value(), status.value(), date.value());
    return Transaction.fromEntity(transactionService.createOrUpdateTransaction(transaction));
  }
}
