package com.guama.transactions.context.transactions.domain.find;

import com.guama.transactions.context.transactions.domain.TransactionsPage;

/**
 * Find transactions
 */
public interface IFindTransactions {

  /**
   * Execute method
   *
   * @param findTransactionsView The find transaction view
   * @return a transactions page
   */
  TransactionsPage execute(FindTransactionsView findTransactionsView);
}
