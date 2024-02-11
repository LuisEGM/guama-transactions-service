package com.guama.transactions.context.transactions.domain;

import com.guama.transactions.context.transactions.shared.PageSettings;
import com.guama.transactions.infrastructure.persistence.entities.TransactionEntity;
import org.springframework.data.domain.Page;

/**
 * Transaction service
 */
public interface ITransactionService {

  /**
   * Find transactions
   *
   * @param transactionFilters The transaction filters
   * @param pageSettings       The page settings
   * @return a transactions page
   */
  Page<TransactionEntity> findTransactions(TransactionFilters transactionFilters, PageSettings pageSettings);

  /**
   * Create transaction
   *
   * @param transaction The transaction
   * @return a transaction entity
   */
  TransactionEntity createOrUpdateTransaction(Transaction transaction);

  /**
   * Exists transaction
   *
   * @param id The transaction id
   * @return A boolean indicating if the transaction exists
   */
  boolean existsTransaction(Long id);

  /**
   * Delete transaction
   *
   * @param id The transaction id
   */
  void deleteTransaction(Long id);
}
