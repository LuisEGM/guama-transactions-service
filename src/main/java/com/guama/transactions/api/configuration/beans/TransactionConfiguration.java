package com.guama.transactions.api.configuration.beans;

import com.guama.transactions.context.transactions.application.create.CreateTransaction;
import com.guama.transactions.context.transactions.application.create.CreateTransactionCommandHandler;
import com.guama.transactions.context.transactions.application.delete.DeleteTransaction;
import com.guama.transactions.context.transactions.application.delete.DeleteTransactionCommandHandler;
import com.guama.transactions.context.transactions.application.find.FindTransactions;
import com.guama.transactions.context.transactions.application.find.FindTransactionsViewHandler;
import com.guama.transactions.context.transactions.application.update.UpdateTransaction;
import com.guama.transactions.context.transactions.application.update.UpdateTransactionCommandHandler;
import com.guama.transactions.context.transactions.domain.ITransactionService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The transaction configuration beans
 */
@Configuration
public class TransactionConfiguration {

  /**
   * Find transactions bean
   *
   * @param transactionService   The transaction service
   * @return The find transactions bean
   */
  @Bean
  public FindTransactions findTransactions(ITransactionService transactionService) {
    return new FindTransactions(transactionService);
  }

  /**
   * Find transactions view handler bean
   *
   * @param findTransactions The find transactions bean
   * @return The find transactions view handler bean
   */
  @Bean
  public FindTransactionsViewHandler findTransactionsViewHandler(FindTransactions findTransactions) {
    return new FindTransactionsViewHandler(findTransactions);
  }

  /**
   * Create transaction bean
   *
   * @param transactionService The transaction service
   * @return The create transaction bean
   */
  @Bean
  public CreateTransaction createTransaction(ITransactionService transactionService) {
    return new CreateTransaction(transactionService);
  }

  /**
   * Create transaction command handler bean
   *
   * @param createTransaction The create transaction bean
   * @return The create transaction command handler bean
   */
  @Bean
  public CreateTransactionCommandHandler createTransactionCommandHandler(CreateTransaction createTransaction) {
    return new CreateTransactionCommandHandler(createTransaction);
  }

  /**
   * Update transaction bean
   *
   * @param transactionService The transaction service
   * @return A new update transaction bean
   */
  @Bean
  public UpdateTransaction updateTransaction(ITransactionService transactionService) {
    return new UpdateTransaction(transactionService);
  }

  /**
   * Update transaction command handler bean
   *
   * @param updateTransaction The update transaction bean
   * @return A new update transaction command handler bean
   */
  @Bean
  public UpdateTransactionCommandHandler updateTransactionCommandHandler(UpdateTransaction updateTransaction) {
    return new UpdateTransactionCommandHandler(updateTransaction);
  }

  /**
   * Delete transaction bean
   *
   * @param transactionService The transaction service
   * @return A new delete transaction bean
   */
  @Bean
  public DeleteTransaction deleteTransaction(ITransactionService transactionService) {
    return new DeleteTransaction(transactionService);
  }

  /**
   * Delete transaction command handler bean
   *
   * @param deleteTransaction The delete transaction bean
   * @return A new delete transaction command handler bean
   */
  @Bean
  public DeleteTransactionCommandHandler deleteTransactionCommandHandler(DeleteTransaction deleteTransaction) {
    return new DeleteTransactionCommandHandler(deleteTransaction);
  }
}
